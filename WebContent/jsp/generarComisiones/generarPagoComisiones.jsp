<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>

        <title>Generar reporte de pago de comisiones</title>
        <script language="JavaScript" type="text/javascript">
            //desactivar bot&oacute;n "Qna Anterior"
            function desactiva_enlace(enlace)
            {
                enlace.disabled='disabled';
            }

            //funcion de activacion
            function activar(formulario) {
                formulario.reporte.disabled = false
                formulario.quincena.disabled = true
            }

            //funcion de activacion
            function activar2(formulario) {
                formulario.quincena.disabled = false
                formulario.reporte.disabled = true
            }

            //asignaci&oacute;n de fecha inicial de quincena
            function asignarFechaInicio(){
                var fecha_actual = new Date()
                var dia = fecha_actual.getDate()
                var mes = fecha_actual.getMonth() + 1
                var anio = fecha_actual.getFullYear()

                if (mes < 10)
                    mes = '0' + mes

                if (dia < 10)
                    dia = '0' + dia

                if(dia <=15){
                    var fechainicio=1
                    fechainicio='0'+fechainicio
                    return (fechainicio + "/" + mes + "/" + anio)
                }

                if(dia >15){
                    var fechainicio=16
                    return (fechainicio + "/" + mes + "/" + anio) }
            }

            //asignaci&oacute;n de fecha final de quincena
            function asignarFechaFin(){
                var fecha_actual = new Date()
                var dia = fecha_actual.getDate()
                var mes = fecha_actual.getMonth() + 1
                var anio = fecha_actual.getFullYear()

                if (mes < 10)
                    mes = '0' + mes

                if (dia < 10)
                    dia = '0' + dia

                if(dia <=15){
                    var fechafin=15


                    return (fechafin + "/" + mes + "/" + anio)
                }

                if(dia >15){
                    var QuincenaMes=2
                    var mes =fecha_actual.getMonth()
                    var totald = 30;
                    if(mes==0
                        || mes == 2
                        || mes == 4
                        || mes == 6
                        || mes == 7
                        || mes == 9
                        || mes == 11) {totald = 31;}

                    if (mes == 1) {
                        fecha_actual = new Date();
                        var mes1 =fecha_actual.getMonth()
                        var anio = fecha_actual.getFullYear();
                        if (anio % 4 == 0 && (anio  % 400 == 0 || anio  % 100 != 0))
                            totald = 29;

                        else
                            totald = 28;

                    }
                    var mes =fecha_actual.getMonth()+1
                    if (mes < 10)
                        mes = '0' + mes
                    return (totald + "/" + mes + "/" + anio)}
            }


            //asignacion de fecha inicial de la quincena anterior
            function asignarFechaInicioAnterior(){
                var fecha_actual = new Date()
                var dia = fecha_actual.getDate()
                var mes = fecha_actual.getMonth() + 1
                var anio = fecha_actual.getFullYear()



                if(dia <=15){
                    var fechainicio=16
                    mes=mes-1

                    if(mes==0)
                        mes=12
                    anio=anio-1

                    if (mes < 10)
                        mes = '0' + mes

                    return (fechainicio + "/" + mes + "/" + anio)
                }

                if(dia >15){
                    var fechainicio=1
                    fechainicio='0'+fechainicio
                    if (mes < 10)
                        mes = '0' + mes
                    return (fechainicio + "/" + mes + "/" + anio)
                }
            }

            //asignacion de la fecha final de la quincena anterior
            function asignarFechaFinAnterior(){
                var fecha_actual = new Date()
                var dia = fecha_actual.getDate()
                var mes = fecha_actual.getMonth() + 1
                var anio = fecha_actual.getFullYear()


                if(dia <=15){
                    var mes =fecha_actual.getMonth()-1


                    var totald = 30;
                    if(mes==0
                        || mes == 2
                        || mes == 4
                        || mes == 6
                        || mes == 7
                        || mes == 9
                        || mes == 11) {totald = 31;}

                    if (mes == 1) {
                        fecha_actual = new Date();
                        var mes1 =fecha_actual.getMonth()
                        var anio = fecha_actual.getFullYear();
                        if (anio % 4 == 0 && (anio  % 400 == 0 || anio  % 100 != 0))
                            totald = 29;

                        else
                            totald = 28;
                    }
                    var mes =fecha_actual.getMonth()

                    if(mes==0){
                        mes=12
                        anio=anio-1
                        totald=31}

                    if (mes < 10)
                        mes = '0' + mes


                    return (totald + "/" + mes + "/" + anio) }

                if(dia >15){
                    var fechafin=15
                    if (mes < 10)
                        mes = '0' + mes
                    return (fechafin + "/" + mes + "/" + anio)}
            }


            //asignaci&oacute;n del n&uacute;mero de quincena
            function asignarQuincena(){
                var fecha_actual = new Date()
                var dia = fecha_actual.getDate()
                var mes = fecha_actual.getMonth() + 1
                var anio = fecha_actual.getFullYear()
                var numQuincenaPar=mes*2

                document.form1.anioQuincenaFrm.value = anio;
                if(dia<=15){
                    var quincenaMes=1
                    var numQuincenaComision=numQuincenaPar-1
                    return(numQuincenaComision)
                }

                if(dia >15){
                    var quincenaMes=2
                    var numQuincenaComision=numQuincenaPar
                    return(numQuincenaComision)
                }

            }


            //impresi&oacute;n de datos en pantalla
            function MostrarDatos() {
                document.form1.Fecha_actu.value = asignarFechaInicio();
                document.form1.Fecha_actu2.value = asignarFechaFin();
                document.form1.Quincena.value = asignarQuincena();
                document.form1.fechaInicioPeriodoComisionesFrm.value = asignarFechaInicio();
                document.form1.fechaFinPeriodoComisionesFrm.value = asignarFechaFin();
                document.form1.numQuincenaReporteFrm.value = asignarQuincena();
            }

            function MostrarDatos2(){
                document.form1.Fecha_actu.value = asignarFechaInicioAnterior();
                document.form1.Fecha_actu2.value = asignarFechaFinAnterior();
                document.form1.fechaInicioPeriodoComisionesFrm.value = asignarFechaInicioAnterior();
                document.form1.fechaFinPeriodoComisionesFrm.value = asignarFechaFinAnterior();
            }
        </script>

        <script language="JavaScript" type="text/javascript">
            function procesando(){
                document.getElementById('img').style.visibility = "visible";
            }
        </script>

        <script language="JavaScript" type="text/javascript">
            function DecrementoQuincena(){
                document.form1.numQuincenaReporteFrm.value--;

                if(document.form1.numQuincenaReporteFrm.value==0){
                    document.form1.numQuincenaReporteFrm.value=24
                    document.form1.anioQuincenaFrm.value--;
                }
            }
        </script>

    </head>
    <body onsubmit="procesando()">
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 

        <tag:errors name="comisiones"/>
        <spring:nestedPath path="comisiones">
            <form action="#" method="post" name="form1">

                <table width="524" align="center">
                    <td ><div id="titleg664x16">3.1.1.3.CUP.001.GUI Generar reporte de pago de comisiones</div>

                    <tr>
                        <td><table width="580" border="0" align="center">

                                <div id="titleg664x16">Periodo</div>
                                <label class="label135">De:&nbsp;&nbsp;</label>
                                <span class="field195">
                                    <input type="hidden" name="Fecha_actu" value=""  class="input" />
                                    <spring:bind path="comisionBrutaAgente.fechaInicioPeriodoComisiones">
                                        <input type="text" id="fechaInicioPeriodoComisionesFrm" name="${status.expression}" value="${status.value}"  class="input" />
                                    </spring:bind>
                                </span>

                                <label class="label135">A:&nbsp;</label>
                                <span class="field195">
                                    <input type="hidden" name="Fecha_actu2"   class="input" />
                                    <spring:bind path="comisionBrutaAgente.fechaFinPeriodoComisiones">
                                        <input type="text" id="fechaFinPeriodoComisionesFrm" name="${status.expression}" value="${status.value}"  class="input"  />
                                    </spring:bind>
                                </span>

                                <label class="label135">Quincena:&nbsp;</label>
                                <span class="field195">
                                    <input type="hidden" name="Quincena" value=""  class="input" />
                                    <spring:bind path="comisionBrutaAgente.numQuincenaReporte">
                                        <input type="text" id="numQuincenaReporteFrm" name="${status.expression}" value="${status.value}"  class="input" />
                                    </spring:bind>
                                </span>

                                <label class="label135">Año quincena:&nbsp;</label>
                                <span class="field195">
                                    <input type="hidden" name="anioQuincena"   class="input" />
                                    <spring:bind path="comisionBrutaAgente.anioQuincena">
                                        <input type="text" id="anioQuincenaFrm" name="${status.expression}" value="${status.value}"  class="input"  />
                                    </spring:bind>
                                </span>


                                <div align="center" class="submit664">
                                    <input type="button" name="quincena" value="Qna. Anterior" class="input" disabled onClick="MostrarDatos2();desactiva_enlace(this);DecrementoQuincena();"/>
                                </div>
                                <div>
                                    <p align="center">La informaci&oacute;n anterior se utilizar&aacute; para el C&aacute;lculo de comisiones. &iquest;Es correcta ?

                                </p></div>

                                <div align="center" class="submit664">
                                    <input type="button" name="Submit52" value="S&iacute;" class="input" onClick="activar(this.form)"/>
                                    <input type="button" name="Submit5" value="NO" class="input" onClick="activar2(this.form);desactiva_enlace(this);"/>
                                </div>


                                <td>
                                <div align="center" class="submit664">
                                    <input id="reporte" type="submit" name="_finish" value="Generar reporte" class="input" disabled/>
                                    <a href="<c:url value="/"/>app/logoutcontroller">
                                        <input type="button" name="Submit3" value="Salir" class="input" />
                                    </a>
                                </div>
                                <div id="img" style="visibility:hidden">
                                    <img src="<c:url value="/img/procesando.gif"/>">
                                </div>


                        </table></td>
                    </tr>
                </table>
            </form>
            <script language="JavaScript" type="text/javascript">
                MostrarDatos();
            </script>
        </spring:nestedPath>
    </body>
</html>
