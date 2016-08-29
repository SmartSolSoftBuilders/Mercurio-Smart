package mx.com.seguros.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {

	public static Date parseFromQnaToDate(Integer numQnaInt) {
		Integer anio = getYear(numQnaInt);
		Integer qna = getQna(numQnaInt);
		Integer mes = null;
		Integer diaMes = null;

		if (1 <= qna && qna <= 24) {
			if (qna % 2 == 0) {
				mes = qna / 2;
				if (mes == 2) {
					diaMes = 28;
				} else {
					diaMes = 30;
				}
			} else {
				mes = qna / 2 + 1;
				diaMes = 15;
			}
		} else {
			throwDateFormatException(qna);
		}

		if (log.isTraceEnabled()) {
			log.trace("anio: " + anio);
			log.trace("qna: " + qna);
			log.trace("mes: " + mes);
			log.trace("diaMes: " + diaMes);
		}

		DateTime dateTime;
		dateTime = new DateTime(anio.intValue(), mes.intValue(), diaMes
				.intValue(), 0, 0, 0, 0);
		Date dateParsed;
		dateParsed = dateTime.toDate();
		log.trace("Fecha analizada: " + dateFormat.format(dateParsed));
		return determinarFechaInicioReal(dateParsed);
	}

	private static void throwDateFormatException(Integer qna) {
		StringBuilder sb = new StringBuilder();
		sb.append("Valor de quincena no valido: qna = ");
		sb.append(qna);
		String msgError = sb.toString();
		log.error(msgError);
		throw new DateFormatException(msgError);
	}

	public static Integer getYear(Integer numQnaInt) {
		Integer anio;
		if (hasValidFormatQnaInt(numQnaInt)) {
			String numQnaStr = numQnaInt.toString();
			String anioStr = numQnaStr.substring(0, NUM_POSICIONES_ANIO);
			anio = Integer.parseInt(anioStr);
		} else {
			anio = 0;
		}
		return anio;
	}

	public static Integer getQna(Integer numQnaInt) {
		Integer qna;
		if (hasValidFormatQnaInt(numQnaInt)) {
			String numQnaStr = numQnaInt.toString();
			String qnaStr = numQnaStr.substring(NUM_POSICIONES_ANIO,
					NUM_POSICIONES_ANIO_QNA);
			qna = Integer.parseInt(qnaStr);
		} else {
			qna = null;
		}
		// log.debug("qna: " + qna);
		return qna;
	}

	private static Boolean hasValidFormatQnaInt(Integer numQnaInt) {
		String numQnaStr = numQnaInt.toString();
		Boolean validFormat;
		if (numQnaStr == null || numQnaStr.length() < NUM_POSICIONES_ANIO_QNA) {
			log.error("El formato de la quincena no es valido: " + numQnaInt);
			validFormat = Boolean.FALSE;
		} else {
			validFormat = Boolean.TRUE;
		}
		return validFormat;
	}

	public static Integer calcularNumQnas(Integer fechaInicialInt,
			Integer fechaFinalInt) {
		if (log.isTraceEnabled()) {
			log.trace("fechaInicialInt: " + fechaInicialInt);
			log.trace("fechaFinalInt: " + fechaFinalInt);
		}
		Integer anioFechaInicial;
		Integer anioFechaFinal;

		anioFechaInicial = DateUtils.getYear(fechaInicialInt);
		anioFechaFinal = DateUtils.getYear(fechaFinalInt);

		Integer qnaFechaInicial;
		Integer qnaFechaFinal;

		qnaFechaInicial = DateUtils.getQna(fechaInicialInt);
		qnaFechaFinal = DateUtils.getQna(fechaFinalInt);

		Integer numQnas;

		if (anioFechaFinal > anioFechaInicial) {
			Integer numQnasAnios;
			Integer numQnasPrimerAnio;
			Integer numQnasUltimoAnio;
			numQnasAnios = (anioFechaFinal - anioFechaInicial - 1) * 24;
			numQnasPrimerAnio = (24 - qnaFechaInicial + 1);
			numQnasUltimoAnio = qnaFechaFinal;

			numQnas = numQnasPrimerAnio + numQnasAnios + numQnasUltimoAnio;
		} else if (anioFechaFinal.equals(anioFechaInicial)
				&& qnaFechaFinal >= qnaFechaInicial) {
			numQnas = qnaFechaFinal - qnaFechaInicial + 1;
		} else {
			StringBuilder sb = new StringBuilder();
			sb
					.append("La fecha de c\u00F3mputo no puede ser anterior a la fecha ");
			sb.append("del primer pago. Verifique el estado de la base de ");
			sb.append("datos.");
			sb.append("\nFecha Inicial: ");
			sb.append(fechaInicialInt);
			sb.append("\nFecha Final: ");
			sb.append(fechaFinalInt);
			log.error(sb.toString());
			// TODO - To change type
			throw new RuntimeException(sb.toString());
			// throw new PagosBusinessException(sb.toString());
		}
		return numQnas;
	}

	private static Logger log;
	private static final SimpleDateFormat dateFormat;
	private static final Integer NUM_POSICIONES_ANIO = 4;
	private static final Integer NUM_POSICIONES_QNA = 2;
	public static final Integer NUM_POSICIONES_ANIO_QNA = NUM_POSICIONES_ANIO
			+ NUM_POSICIONES_QNA;

	static {
		log = LoggerFactory.getLogger(DateUtils.class);
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	}
	/**
	 * Determina el número de quincena a partir de la fecha
	 * @param fecha
	 * @return
	 */
	public static int getQuincenaFromFecha(Date fecha){
		Date fechaRealQuincena = determinarFechaInicioReal(fecha);
		Calendar calUtil = Calendar.getInstance();
		calUtil.setTime(fechaRealQuincena);
		int quincena = (calUtil.get(Calendar.MONTH)+1)*2;
		if(calUtil.get(Calendar.DATE) == 15){
			quincena--;
		}
		return Integer.parseInt(calUtil.get(Calendar.YEAR) + ""+ (quincena<10?"0":"")+quincena);
	}
	/**
	 * Suma 1 mes de cobertura de manera no exacta:
	 * Si la fecha es del día 15 suma un mes
	 * Si no entonces retorna la fecha máxima del siguiente mes correspondiente a la fecha
	 * @param fecha
	 * @return
	 */
	public static Date sumar1MesCobertura(Date fecha){
		Calendar calUtil = Calendar.getInstance();
		calUtil.setTime(fecha);
		if(calUtil.get(Calendar.DATE) == 15){
			calUtil.add(Calendar.MONTH, 1);
		}else{
			calUtil.set(Calendar.DATE, calUtil.getActualMinimum(Calendar.DATE));
			calUtil.add(Calendar.MONTH, 1);
			calUtil.set(Calendar.DATE, calUtil.getActualMaximum(Calendar.DATE));
		}
		return calUtil.getTime();
	}
	
	
	/**
	 * Determina la fecha real de inicio de una cobertura dependiendo del día
	 * Si el día es 15 +/- 3 días el inicio de cobertura es para el dia 15 del mes de la fecha
	 * Si el día es 30,31,28,29,1,2 el día de incio de cobertura es el último día del mes de la fecha
	 * @param fechaInicioCobertura
	 * @return
	 */
	public static  Date determinarFechaInicioReal(Date fechaInicioCobertura) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaInicioCobertura);
		
		int dia = cal.get(Calendar.DATE);
		
		if( Math.abs(dia - 15) <=3){
			cal.set(Calendar.DATE, 15);
		}else if(dia == 30 || dia == 31 || dia == 28 || dia == 29 || dia == 1 || dia == 2){
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		return cal.getTime();
		
	}
	/**
	 * Sumar número de quincena a la quincena de parámetro
	 * @param quincena
	 * @param sumar
	 * @return
	 */
	public static int sumarAQuincena(int quincena,int sumar){
		int anio = getYear(quincena);
		int qna = getQna( quincena);
		for(int i=1;i<=sumar;i++){
			if(qna == 24){
				//sumar uno al año, reiniciar quincena
				anio++;
				qna=1;
			}else{
				qna++;
			}
		}
		return Integer.parseInt(anio + "" + (qna<10?"0":"")+qna);
		
	}
	
	public static Date parseDate(String fecha){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			return df.parse(fecha);
		}catch(Exception ex){
			;
		}
		return null;
	}
}
