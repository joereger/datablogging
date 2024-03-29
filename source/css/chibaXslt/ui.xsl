<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
    xmlns:xhtml="http://www.w3.org/2002/06/xhtml2"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xforms="http://www.w3.org/2002/xforms"
    xmlns:xlink="http://www.w3.org/1999/xlink"
    xmlns:chiba="http://chiba.sourceforge.net/xforms"
    exclude-result-prefixes="xhtml xforms chiba xlink">



    <!-- ####################################################################################################### -->
    <!-- This stylesheet handles the XForms UI constructs [XForms 1.0, Chapter 9]'group', 'repeat' and           -->
    <!-- 'switch' and offers some standard interpretations for the appearance attribute.                         -->
    <!-- author: joern turner                                                                                    -->
    <!-- ####################################################################################################### -->

    <!-- ############################################ PARAMS ################################################### -->
    <!-- ##### should be declared in html4.xsl ###### -->
    <!-- ############################################ VARIABLES ################################################ -->


    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"
        doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN"/>

    <!-- ### transcodes the XHMTL namespaced elements to HTML ### -->
    <xsl:namespace-alias stylesheet-prefix="xhtml" result-prefix="#default"/>

    <xsl:preserve-space elements="*"/>

    <!-- ####################################################################################################### -->
    <!-- #################################### GROUPS ########################################################### -->
    <!-- ####################################################################################################### -->

    <!--
    processing of groups and repeats is handled with a computational pattern (as mentioned in Michael Kay's XSLT
    Programmers Reference) in this stylesheet, that means that when a group or repeat is found its children will
    be processed with for-each. this top-down approach seems to be more adequate for transforming XForms markup
    than to follow a rule-based pattern. Also note that whenever nodesets of XForms controls are processed the
    call template 'buildControl' is used to handle the control. In contrast to apply-templates a call-template
    preserves the position() of the control inside its parent nodeset and this can be valuable information for
    annotating controls with CSS classes that refer to their parent.
    -->
    <!-- ###################################### MINIMAL GROUP ################################################## -->
    <!-- handle 'minimal' group - this is the default for groups and only annotates CSS to labels + controls and
    outputs them in a kind of flow-layout -->
    <xsl:template match="xforms:group[@xforms:appearance='minimal']">
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>
        <xsl:variable name="id" select="@id"/>
        <div class="{normalize-space(concat('minimal-group',' ',$group-css))}" id="{$id}">
            <xsl:for-each select="*">

                <xsl:choose>

                    <!-- **** handle group label ***** -->
                    <xsl:when test="self::xforms:label">
                        <!-- if inside a compact repeat our label is already handled and should be ignored here -->
                        <xsl:if test="not(ancestor::xforms:repeat[@xforms:appearance='compact'])">
                            <span id="{$id}-label" class="minimal-group-label">
                                <xsl:apply-templates select="."/>
                            </span>
                        </xsl:if>
                    </xsl:when>

                    <!-- **** handle group alert ***** -->
                    <xsl:when test="self::xforms:alert">
                        <xsl:apply-templates select="xforms:alert"/>
                    </xsl:when>

                    <!-- **** handle sub group ***** -->
                    <xsl:when test="self::xforms:group">
                        <xsl:apply-templates select="."/>
                    </xsl:when>

                    <!-- **** handle repeat ***** -->
                    <xsl:when test="self::xforms:repeat">
                        <xsl:apply-templates select="."/>
                    </xsl:when>

                    <!-- **** handle switch ***** -->
                    <xsl:when test="self::xforms:switch">
                        <xsl:apply-templates select="."/>
                    </xsl:when>

                    <!-- **** handle chiba:data element ***** -->
                    <xsl:when test="self::chiba:data">
                    </xsl:when>

                    <!-- **** handle trigger + submit ***** -->
                    <xsl:when test="self::xforms:trigger or self::xforms:submit">
                        <xsl:variable name="css">
                            <xsl:call-template name="assembleClasses"/>
                        </xsl:variable>
                        <span class="{$css}" id="{@id}">
                            <xsl:call-template name="buildControl"/>
                        </span>
                    </xsl:when>

                    <!-- **** handle xforms control ***** -->
                    <xsl:when test="self::xforms:*">
                        <xsl:variable name="css">
                            <xsl:call-template name="assembleClasses"/>
                        </xsl:variable>
                        <xsl:variable name="label-class">
                            <xsl:call-template name="labelClasses"/>
                        </xsl:variable>

                        <span id="{@id}" class="{$css}">
                            <span id="{@id}-label" class="{$label-class}">
                                <xsl:apply-templates select="xforms:label"/>
                            </span>
                            <xsl:call-template name="buildControl"/>
                        </span>
                    </xsl:when>

                    <!-- **** handle all other ***** -->
                    <xsl:otherwise>
                        <xsl:call-template name="handle-foreign-elements"/>
                    </xsl:otherwise>

                </xsl:choose>
            </xsl:for-each>
        </div>
    </xsl:template>


    <!-- ###################################### COMPACT GROUP ################################################## -->
    <xsl:template match="xforms:group[@xforms:appearance='compact']">
        <xsl:variable name="id" select="@id"/>
        <xsl:variable name="control-count" select="count(./*/xforms:label)"/>
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>
        <table border="0" class="{normalize-space(concat('compact-group',' ',$group-css))}" id="{$id}">
            <!-- ***** build caption with column labels ***** -->
            <!-- ***** ignore label row if inside a compact repeat ***** -->
            <xsl:if test="not(ancestor::xforms:repeat[@xforms:appearance='compact'])">
                <tr>
                    <td colspan="{$control-count}" id="{$id}-label" class="compact-group-label">
                        <xsl:apply-templates select="xforms:label"/>
                    </td>
                </tr>
            </xsl:if>
            <tr>
                <xsl:for-each select="./*/xforms:label">
                    <xsl:variable name="label-class">
                        <xsl:call-template name="labelClasses"/>
                    </xsl:variable>
                    <td id="{../@id}-label" class="{$label-class}">
                        <xsl:apply-templates select="self::node()[not(name(..)='xforms:trigger' or name(..)='xforms:submit')]"/>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <xsl:for-each select="*">
                    <xsl:choose>

                        <!-- **** handle group label ***** -->
                        <xsl:when test="self::xforms:label">
                            <!-- ignore label for compact groups - it's separately build while processing the header -->
                        </xsl:when>

                        <!-- **** handle group alert ***** -->
                        <xsl:when test="self::xforms:alert">
                            <xsl:apply-templates select="xforms:alert"/>
                        </xsl:when>

                        <!-- **** handle sub group ***** -->
                        <xsl:when test="self::xforms:group">
                            <td colspan="{$control-count}">
                                <xsl:apply-templates select="."/>
                            </td>
                        </xsl:when>

                        <!-- **** handle repeat ***** -->
                        <xsl:when test="self::xforms:repeat">
                            <td colspan="{$control-count}">
                                <xsl:apply-templates select="."/>
                            </td>
                        </xsl:when>

                        <!-- **** handle switch ***** -->
                        <xsl:when test="self::xforms:switch">
                            <td colspan="{$control-count}">
                                <xsl:apply-templates select="."/>
                            </td>
                        </xsl:when>

                        <!-- **** handle trigger + submit ***** -->
                        <xsl:when test="self::xforms:trigger or self::xforms:submit">
                            <xsl:variable name="css">
                                <xsl:call-template name="assembleClasses"/>
                            </xsl:variable>
                            <td class="{$css}" id="{@id}">
                                <xsl:call-template name="buildControl"/>
                            </td>
                        </xsl:when>

                        <!-- **** handle xforms control ***** -->
                        <xsl:when test="self::xforms:*">
                            <xsl:variable name="css">
                                <xsl:call-template name="assembleClasses"/>
                            </xsl:variable>
                            <td id="{@id}" class="{$css}">
                                <xsl:call-template name="buildControl"/>
                            </td>
                        </xsl:when>

                        <!-- **** handle chiba:data element ***** -->
                        <xsl:when test="self::chiba:data">
                        </xsl:when>

                        <!-- **** handle all other ***** -->
                        <xsl:otherwise>
                            <xsl:call-template name="handle-foreign-elements"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
            </tr>
        </table>
    </xsl:template>

    <!-- ###################################### FULL GROUP ################################################## -->
    <!-- handle group with apprearance 'full' - will render controls in a two-column table with labels on
    the left side. -->
    <xsl:template match="xforms:group" name="full-group">
        <xsl:variable name="id" select="@id"/>
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>

        <table class="{normalize-space(concat('full-group',' ',$group-css))}" id="{$id}" border="0">
            <!-- handling group children -->
            <xsl:for-each select="*">
                <xsl:choose>

                    <!-- ***** build caption with column labels ***** -->
                    <xsl:when test="self::xforms:label">
                        <xsl:if test="not(ancestor::xforms:repeat[@xforms:appearance='compact'])">
                            <tr>
                                <td colspan="2" id="{$id}-label" class="full-group-label">
                                    <xsl:apply-templates select="."/>
                                </td>
                            </tr>
                        </xsl:if>
                    </xsl:when>

                    <!-- **** handle group alert ***** -->
                    <xsl:when test="self::xforms:alert">
                        <xsl:apply-templates select="xforms:alert"/>
                    </xsl:when>

                    <!-- **** handle sub group ***** -->
                    <xsl:when test="self::xforms:group">

                        <tr>
                            <td colspan="2">
                                <xsl:apply-templates select="."/>
                            </td>
                        </tr>
                    </xsl:when>

                    <!-- **** handle repeat ***** -->
                    <xsl:when test="self::xforms:repeat">
                        <tr>
                            <td colspan="2">
                                <xsl:apply-templates select="."/>
                            </td>
                        </tr>
                    </xsl:when>

                    <!-- **** handle switch ***** -->
                    <xsl:when test="self::xforms:switch">
                        <tr>
                            <td colspan="2">
                                <xsl:apply-templates select="."/>
                            </td>
                        </tr>
                    </xsl:when>

                    <!-- **** handle trigger + submit ***** -->
                    <xsl:when test="self::xforms:trigger or self::xforms:submit">
                        <tr>
                            <xsl:variable name="css">
                                <xsl:call-template name="assembleClasses"/>
                            </xsl:variable>
                            <td class="{$css}" id="{@id}" colspan="2">
                                <xsl:call-template name="buildControl"/>
                            </td>
                        </tr>
                    </xsl:when>

                    <!-- **** handle xforms control ***** -->
                    <xsl:when test="self::xforms:*">
                        <tr>
                            <xsl:variable name="css">
                                <xsl:call-template name="assembleClasses"/>
                            </xsl:variable>
                            <xsl:variable name="label-class">
                                <xsl:call-template name="labelClasses"/>
                            </xsl:variable>
                            <td id="{@id}-label" class="{$label-class}">
                                <xsl:apply-templates select="xforms:label"/>
                            </td>
                            <td id="{@id}" class="{$css}">
                                <xsl:call-template name="buildControl"/>
                            </td>
                        </tr>
                    </xsl:when>

                    <!-- **** handle chiba:data element ***** -->
                    <xsl:when test="self::chiba:data">
                    </xsl:when>

                    <!-- **** handle all other ***** -->
                    <xsl:otherwise>
                        <xsl:call-template name="handle-foreign-elements"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </table>
    </xsl:template>

    <!-- ###################################### MULTI-COLUMN GROUP ############################################## -->
    <!-- ### based upon compact apprearance the mulit-column group puts child groups into columns of a        ### -->
    <!-- ### table and allow groups to appear side by side.                                                   ### -->
    <!-- ### ATTENTION: ONLY GROUPS ARE PROCESSED BY THIS TEMPLATE - EVERYTHING ELSE IS IGNORED               ### -->
    <!-- ######################################################################################################## -->
    <xsl:template match="xforms:group[@xforms:appearance='multi-column']">
        <xsl:variable name="id" select="@id"/>
        <xsl:variable name="group-count" select="count(./xforms:group)"/>
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>
        <table class="{normalize-space(concat('multi-column-group',' ',$group-css))}" id="{$id}">
            <!-- ***** build caption with column labels ***** -->
            <tr>
                <td colspan="{$group-count}" width="100%" id="{$id}-label" class="multi-column-group-label">
                    <xsl:apply-templates select="xforms:label"/>
                </td>
            </tr>
            <tr>
                <xsl:for-each select="xforms:group">
                    <td>
                        <xsl:apply-templates select="."/>
                    </td>
                </xsl:for-each>
            </tr>
        </table>
    </xsl:template>



    <!-- ####################################### GROUP HELPER ################################################### -->
    <xsl:template name="handle-foreign-elements">
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates/>
        </xsl:copy>
    </xsl:template>


    <!-- ######################################################################################################## -->
    <!-- ####################################### REPEAT ######################################################### -->
    <!-- ######################################################################################################## -->

    <!-- ### handle repeat with 'minimal' appearance ### -->
    <xsl:template match="xforms:repeat">
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>
        <table class="{concat('minimal-repeat',' ',$group-css)}" id="{@id}">
            <xsl:if test="$scripted='true'">
                <!-- clone repeat prototype -->
                <!-- style attribute for safety in case CSS file is not there -->
                <tr class="repeat-prototype" onclick="setRepeatIndex('{@id}');" style="display:none;">
                    <xsl:for-each select="chiba:data/xforms:group[@chiba:transient]">
                        <xsl:call-template name="processMinimalChilds"/>
                    </xsl:for-each>
                </tr>
            </xsl:if>

            <xsl:variable name="outermost-id" select="ancestor-or-self::xforms:repeat/@id"/>
            <xsl:variable name="repeat-id" select="@id"/>

            <!-- ***** loop repeat entries ***** -->
            <xsl:for-each select="xforms:group[@chiba:transient]">
                <xsl:choose>
                    <xsl:when test="@chiba:selected='true'">
                        <xsl:choose>
                            <xsl:when test="$scripted='true'">
                                <tr class="repeat-item repeat-index" onclick="setRepeatIndex('{$repeat-id}');">
                                    <xsl:call-template name="processMinimalChilds"/>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr class="repeat-item repeat-index">
                                    <td class="minimal-repeat-selector">
                                        <input type="radio" name="{$selector-prefix}{$outermost-id}" value="{$repeat-id}:{@chiba:position}" checked="checked"/>
                                    </td>
                                    <xsl:call-template name="processMinimalChilds"/>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                            <xsl:when test="$scripted='true'">
                                <tr class="repeat-item" onclick="setRepeatIndex('{$repeat-id}');">
                                    <xsl:call-template name="processMinimalChilds"/>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr class="repeat-item">
                                    <td class="minimal-repeat-selector">
                                        <input type="radio" name="{$selector-prefix}{$outermost-id}" value="{$repeat-id}:{@chiba:position}"/>
                                    </td>
                                    <xsl:call-template name="processMinimalChilds"/>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </table>
    </xsl:template>

    <!-- ### used by minimal repeat ### -->
    <xsl:template name="processMinimalChilds">
        <xsl:for-each select="*">
            <xsl:variable name="css">
                <xsl:call-template name="assembleClasses"/>
            </xsl:variable>
            <xsl:variable name="label-class">
                <xsl:call-template name="labelClasses"/>
            </xsl:variable>
            <td id="{@id}" class="{$css}">
                <span id="{@id}-label" class="{$label-class}">
                    <xsl:apply-templates select="./xforms:label"/>
                </span>

                <xsl:call-template name="buildControl"/>
            </td>
        </xsl:for-each>
    </xsl:template>

    <!-- ### handle repeat with 'compact' appearance ### -->
    <xsl:template match="xforms:repeat[@xforms:appearance='compact']" priority="1">
        <xsl:variable name="repeat" select="."/>
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>
        <table border="0" id="{@id}" class="{concat('compact-repeat',' ',$group-css)}">
            <xsl:if test="$scripted='true'">
                <!-- clone repeat prototype -->
                <!-- style attribute for safety in case CSS file is not there -->
                <tr class="repeat-prototype" onclick="setRepeatIndex('{@id}');" style="display:none;">
                    <xsl:for-each select="chiba:data/xforms:group[@chiba:transient]">
                        <xsl:call-template name="processCompactChilds"/>
                    </xsl:for-each>
                </tr>
            </xsl:if>
            <tr class="compact-repeat-label">
                <xsl:if test="not($scripted='true')">
                    <!-- ***** build empty selector cell ***** -->
                    <td>&#160;</td>
                </xsl:if>
                <!-- ***** build header ***** -->
                <xsl:for-each select="xforms:group[1]/*/xforms:label">
                    <xsl:variable name="enabled">
                        <xsl:choose>
                            <xsl:when test="../chiba:data/@chiba:enabled='false'">disabled</xsl:when>
                            <xsl:otherwise>enabled</xsl:otherwise>
                        </xsl:choose>
                    </xsl:variable>

                    <td id="{../@id}-label" class="{concat('label ',$enabled)}">
                        <xsl:apply-templates select="self::node()[not(name(..)='xforms:trigger' or name(..)='xforms:submit')]"/>
                    </td>
                </xsl:for-each>
            </tr>

            <xsl:variable name="outermost-id" select="ancestor-or-self::xforms:repeat/@id"/>
            <xsl:variable name="repeat-id" select="@id"/>

            <xsl:for-each select="xforms:group[@chiba:transient]">
                <xsl:choose>
                    <xsl:when test="@chiba:selected='true'">
                        <xsl:choose>
                            <xsl:when test="$scripted='true'">
                                <tr class="repeat-item repeat-index" onclick="setRepeatIndex('{$repeat/@id}');">
                                    <xsl:call-template name="processCompactChilds"/>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr class="repeat-item repeat-index">
                                    <td class="selector-cell">
                                        <input type="radio" name="{$selector-prefix}{$outermost-id}" value="{$repeat-id}:{@chiba:position}" checked="checked"/>
                                    </td>
                                    <xsl:call-template name="processCompactChilds"/>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                            <xsl:when test="$scripted='true'">
                                <tr class="repeat-item" onclick="setRepeatIndex('{$repeat/@id}');">
                                    <xsl:call-template name="processCompactChilds"/>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr class="repeat-item">
                                    <td class="selector-cell">
                                        <input type="radio" name="{$selector-prefix}{$outermost-id}" value="{$repeat-id}:{@chiba:position}"/>
                                    </td>
                                    <xsl:call-template name="processCompactChilds"/>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </table>
    </xsl:template>

    <!-- ### used by compact repeat ### -->
    <xsl:template name="processCompactChilds">
        <xsl:for-each select="*">
            <xsl:variable name="css">
                <xsl:call-template name="assembleClasses"/>
            </xsl:variable>
            <td id="{@id}" class="{$css}" valign="top">
                <xsl:call-template name="buildControl"/>
            </td>
        </xsl:for-each>
    </xsl:template>

    <!-- ### handle repeat with 'full' appearance ### -->
    <xsl:template match="xforms:repeat[@xforms:appearance='full']">
        <xsl:variable name="repeat" select="."/>
        <xsl:variable name="group-css">
            <xsl:call-template name="assembleClasses"/>
        </xsl:variable>

        <table border="0" class="{normalize-space(concat('full-repeat',' ',$group-css))}" id="{@id}">
            <xsl:if test="$scripted='true'">
                <!-- clone repeat prototype -->
                <!-- style attribute for safety in case CSS file is not there -->
                <tr class="repeat-prototype" onclick="setRepeatIndex('{@id}');" style="display:none;">
                    <xsl:for-each select="chiba:data/xforms:group[@chiba:transient]">
                        <td>
                            <xsl:call-template name="full-group"/>
                        </td>
                    </xsl:for-each>
                </tr>
            </xsl:if>

            <xsl:variable name="outermost-id" select="ancestor-or-self::xforms:repeat/@id"/>
            <xsl:variable name="repeat-id" select="@id"/>

            <!-- ***** loop repeat entries ***** -->
            <xsl:for-each select="xforms:group[@chiba:transient]">
                <xsl:choose>
                    <xsl:when test="@chiba:selected='true'">
                        <xsl:choose>
                            <xsl:when test="$scripted='true'">
                                <tr class="repeat-item repeat-index" onclick="setRepeatIndex('{$repeat-id}');">
                                    <td>
                                        <xsl:call-template name="full-group"/>
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr class="repeat-item repeat-index">
                                    <td class="selector-cell">
                                        <input type="radio" name="{$selector-prefix}{$outermost-id}" value="{$repeat-id}:{@chiba:position}" checked="checked"/>
                                    </td>
                                    <td>
                                        <xsl:call-template name="full-group"/>
                                    </td>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                            <xsl:when test="$scripted='true'">
                                <tr class="repeat-item" onclick="setRepeatIndex('{$repeat-id}');">
                                    <td>
                                        <xsl:call-template name="full-group"/>
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr class="repeat-item">
                                    <td class="selector-cell">
                                        <input type="radio" name="{$selector-prefix}{$outermost-id}" value="{$repeat-id}:{@chiba:position}"/>
                                    </td>
                                    <td>
                                        <xsl:call-template name="full-group"/>
                                    </td>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </table>
    </xsl:template>

    <!-- ### handle repeats attribute on foreign elements ### -->
    <xsl:template match="*[@xforms:repeat-bind]|*[@xforms:repeat-nodeset]">
        <xsl:apply-templates/>
    </xsl:template>


    <!-- ######################################################################################################## -->
    <!-- ####################################### SWITCH ######################################################### -->
    <!-- ######################################################################################################## -->

    <!-- ### handle xforms:switch ### -->
    <xsl:template match="xforms:switch">
        <xsl:apply-templates/>
    </xsl:template>

    <!-- ### handle selected xforms:case ### -->
    <xsl:template match="xforms:case[@xforms:selected='true']">
        <xsl:apply-templates/>
    </xsl:template>

    <!-- ### skip unselected xforms:case ### -->
    <xsl:template match="xforms:case">
    </xsl:template>

</xsl:stylesheet>
