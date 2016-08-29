package mx.com.seguros.utils;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class JasperReportCompile {
	 public static void main(String[] args) {
	      String sourceFileName = "C:\\apache-tomcat-7.0.67\\webapps\\seguros4\\WEB-INF\\classes\\jasper" +
	 
	    		  
	      "\\"+ "ReporteResumenCalculoBonoPolizaAgente" + ".jrxml";

	      System.out.println("Compilando Reporte  ...");
	      try {
	         /**
	          * Compile the report to a file name same as
	          * the JRXML file name
	          */
	         JasperCompileManager.compileReportToFile(sourceFileName);
	         System.out.println("Compilacion satisfactoria!!! ...");
	      } catch (JRException e) {
	         e.printStackTrace();
	      }
	      
	   }
}
