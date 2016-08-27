<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2004/07/xpath-functions" xmlns:xdt="http://www.w3.org/2004/07/xpath-datatypes">
	<xsl:include href="generarTablaHelper.xsl"/>
	<xsl:template match="helper">
        <html>
            <head>
                <link href="../css/stilosTablas.css" rel="stylesheet" type="text/css"/>
                <title>
                        <xsl:value-of select="titulo"/> 
                        
                </title>
                <script language="javascript">
                <!-- Funcion que controla que para las helproutines de seleccion unica se elija un solo valor -->
        function seleccionUnica(controlValue) {
          //alert('seleccionUnica(' + controlValue + ')');
          // Cuando hay mas de un registro se debe de tratar como arreglo
          if (document.forms[0].id.length) {
                for (i=0; i &lt; document.forms[0].id.length; i++) {
                  if(document.forms[0].id[i].checked) {
                        if (document.forms[0].id[i].value != controlValue) {
                          document.forms[0].id[i].checked=false;
                        }
                  }
                }
          } else { 
                if(document.forms[0].id.checked) {
                  if (document.forms[0].id.value != controlValue) {
                        document.forms[0].id.checked=false;
                  }
                }
          }
        }
				
        <!-- Funcion utilizada en helper de seleccion unica para devolver el valor seleccionado al control en la ventana padre -->
        function valorSeleccionado() {
          // Cuando hay mas de un registro se debe de tratar como arreglo
          if (document.forms[0].id.length) {
            for (i=0; i &lt; document.forms[0].id.length;i++) {             
				//alert('for i=' + i);
                <xsl:for-each select="columnas/columna">
                  <xsl:if test="@control!='f'"> 
                   if(document.forms[0].id[i].checked) {
                   //alert((i+1)+' checked');
                   //alert('<xsl:value-of select="@columNom"/>_' + (i+1));
                    cadena = document.getElementsByName('<xsl:value-of select="@columNom"/>_' + (i+1));
                    if (window.opener.document.getElementById('<xsl:value-of select="@columNom"/>')) {
                      window.opener.document.getElementById('<xsl:value-of select="@columNom"/>').value = cadena.item(0).value;
                    } else {
                      alert('No existe el campo <xsl:value-of select="@columNom"/> en la pantalla de origen');
                    }
                   }
                  </xsl:if>
                </xsl:for-each> 
                recargable = true;
                //break;
            }
          } else {            
              <xsl:for-each select="columnas/columna">
                <xsl:if test="@control!='f'"> 
                if(document.forms[0].id.checked) {
                  cadena = document.getElementsByName('<xsl:value-of select="@columNom"/>_1');
                  if (window.opener.document.getElementById('<xsl:value-of select="@columNom"/>')) {
                    window.opener.document.getElementById('<xsl:value-of select="@columNom"/>').value = cadena.item(0).value;
                  } else {
                    alert('No existe el campo <xsl:value-of select="@columNom"/> en la pantalla de origen');
                  }
                 }
                </xsl:if>
              </xsl:for-each> 
              recargable = true;
          }
          
          //Mantenimiento Smart Sol febrero 2012 - Invocar una función al terminar de asignar valores
         try{
          	window.opener.<xsl:value-of select="funcion"/>();
          }catch(ex){}
        }
         
    </script>
    </head>
    <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="background-color: #FFFFEE">
            <form name="formulario">
            
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tr align="left" valign="middle" height="20">
                                    <td colspan="20" class="TopTabla">
                                            <strong>
                                                    <xsl:value-of select="titulo"/>
                                            </strong>
                                    </td>
                            </tr>
                            <xsl:variable name="estilo">
                                    <xsl:if test="(position() mod 2)=0">Color</xsl:if>
                            </xsl:variable>
                            <!-- Titulos de las columnas -->
                            <tr>
                                    <td class="ContenTablaColor">&#160;</td>
                                    <xsl:for-each select="columnas/columna">
                                            <td align="center" class="ContenTablaColor">
                                                    <xsl:if test="@visible='t'">
                                                            <strong>
                                                                    <xsl:value-of select="."/>
                                                            </strong>
                                                    </xsl:if>
                                                    <xsl:if test="@visible='f'"></xsl:if>
                                            </td>
                                    </xsl:for-each>
                            </tr>
                            <xsl:if test="@numregistros &gt; 0">
                                    <!-- template que recorre los tag 'registro' y dibuja en la pantalla las columnas y registros-->
                                    <xsl:apply-templates select="./registros/registro"/>
                            </xsl:if>
                            <xsl:if test="@numregistros = 0">No se encontraron regitros.</xsl:if>
			</table>
					<!-- Dibuja el boton aceptar y hace el llamado a las funciones correspondientes -->
        &#160;
        <input type="button" value=" Aceptar " size="100" class="input">
						<xsl:attribute name="onclick">valorSeleccionado();window.close();</xsl:attribute>
		</input>&#160;
          <input type="button" value=" Cancelar " size="100" class="input">
						<xsl:attribute name="onclick">window.close();</xsl:attribute>
		  </input>
		</form>
			</body>
			
			<!--script language="javascript"> 
          var controles=obtieneOrigenDestino();
          
          if (controles[1]) {
            if (document.forms[0].id.length > 1) {
              for (a=0; a &lt; document.forms[0].id.length;a++) {
                document.forms[0].id[a].checked = controles[1].value == document.getElementsByName(controles[2] + "_" + document.forms[0].id[a].value)[0].value;
              }
            } else if (document.forms[0].id.length == 1) {
              document.forms[0].id.checked = controles[1].value == document.getElementsByName(controles[2] + "_" + document.forms[0].id.value)[0].value;
            }
          }
        </script-->
		</html>
	</xsl:template>
</xsl:stylesheet>
