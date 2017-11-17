<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />
	<xsl:template match="/">
		<html>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

	<xsl:template match="/ARTICLE/TITLE">
		<h1 align="center">
			<xsl:apply-templates />
		</h1>
	</xsl:template>
	<xsl:template match="/ARTICLE/SECT">
		<h2>
			<xsl:apply-templates select="text()|B|I|U|DEF|LINK" />
		</h2>
		<xsl:apply-templates select="SECT|PARA|LIST|NOTE" />
	</xsl:template>

	<xsl:template match="/ARTICLE/SECT/SECT">
		<h3>
			<xsl:apply-templates select="text()|B|I|U|DEF|LINK" />
		</h3>
		<xsl:apply-templates select="SECT|PARA|LIST|NOTE" />
	</xsl:template>

	<xsl:template match="/ARTICLE/SECT/SECT/SECT">
		<xsl:message terminate="yes">
			Error: Sections can only be nested 2 deep.
		</xsl:message>
	</xsl:template>

	<xsl:template match="PARA">
		<p>
			<xsl:apply-templates />
		</p>
	</xsl:template>
</xsl:stylesheet>