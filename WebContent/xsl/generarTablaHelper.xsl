<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2004/07/xpath-functions" xmlns:xdt="http://www.w3.org/2004/07/xpath-datatypes">

	<!-- template que recorre los tag 'registro' y pinta los controles correspondientes -->
	<xsl:template match="registro">
		<xsl:variable name="estilo">
			<xsl:if test="(position() mod 2)=0">Color</xsl:if>
		</xsl:variable>
		<tr align="left" valign="middle">
			<td align="center" width="4%">
				<xsl:attribute name="class">ContenTabla<xsl:value-of select="$estilo"/></xsl:attribute>
				
				<!-- Por cada 'registro' se agregara un checkbox cuyo valor sera el numero de registro -->
				<input type="checkbox">
					<xsl:attribute name="value"><xsl:value-of select="@numero"/></xsl:attribute>
					<xsl:attribute name="name">id</xsl:attribute>
					<!-- Esta version solo soporta seleccion unica. -->
					<xsl:attribute name="onclick">seleccionUnica(<xsl:value-of select="@numero"/>);</xsl:attribute>
				</input>
			</td>
			
			<!-- por cada tag 'campo' se guarda el valor en un control de tipo hidden y se pintan los datos en la pantalla -->
			<xsl:for-each select="campo">
				<td style="border-right-width: 3px;border-right-color: white;border-right-style: solid;">
					<xsl:attribute name="class">ContenTabla<xsl:value-of select="$estilo"/></xsl:attribute>
					<input type="hidden">
						<xsl:attribute name="name"><xsl:value-of select="@columNom"/>_<xsl:value-of select="../@numero"/></xsl:attribute>
						<xsl:attribute name="value"><xsl:value-of select="normalize-space(.)"/></xsl:attribute>
					</input>
          <xsl:if test="@visible='t'">
            &#160;<xsl:value-of select="."/>&#160;&#160;&#160;
          </xsl:if>
          <xsl:if test="@visible='f' or string-length(.)=0"></xsl:if>
				</td>
			</xsl:for-each>
		</tr>
	</xsl:template>
</xsl:stylesheet>
