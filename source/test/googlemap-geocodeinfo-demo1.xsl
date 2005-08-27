<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <xsl:apply-templates select="location"/>
  </xsl:template>

  <xsl:template match="location">
    <div style="padding-right: 8px; margin-top: 2px">
      <xsl:apply-templates select="info"/>
    </div>

  </xsl:template>

  <xsl:template match="info">

    <xsl:variable name="page" select="../@arg0"/>
    <xsl:variable name="address">
        <xsl:for-each select="address/line">
          <xsl:if test="position() &gt; 1">, </xsl:if>
          <xsl:value-of select="."/>
        </xsl:for-each>

    </xsl:variable>

    <div style="font-weight: bold"> </div>

    <div>
	<img>
	   <xsl:attribute name="src">
		<xsl:value-of select="image"/>
	   </xsl:attribute>
	</img>

    </div>

    <div style="font-size: small; margin-top: 14px">
      <xsl:apply-templates select="address/line"/>
    </div>

  </xsl:template>

  <xsl:template match="line">
    <div style="margin-top: 2px"><xsl:value-of select="."/></div>
  </xsl:template>

  <xsl:template name="getSingleLineAddress">
    <xsl:for-each select="address/line">
      <xsl:if test="position() &gt; 1">, </xsl:if>
      <xsl:value-of select="."/>
    </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>
