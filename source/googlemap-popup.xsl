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
    <div style="font-size: small; margin-top: 14px">
      <xsl:apply-templates select="title"/>
      <xsl:apply-templates select="url"/>
    </div>
  </xsl:template>


  <xsl:template match="title">
    <div style="margin-top: 2px"><b><xsl:value-of select="."/></b></div>
  </xsl:template>


  <xsl:template match="url">
    <div style="margin-top: 2px">
    <a>
    <xsl:attribute name="href">
    <xsl:value-of select="@href" />
    </xsl:attribute>
    View Entries
    </a>
    </div>
  </xsl:template>

  <!--<xsl:template name="getSingleLineAddress">
    <xsl:for-each select="address/line">
      <xsl:if test="position() &gt; 1">, </xsl:if>
      <xsl:value-of select="."/>
      Test C
    </xsl:for-each>
  </xsl:template>-->

</xsl:stylesheet>
