function Is () {
	// convert all characters to lowercase to simplify testing
	var agt=navigator.userAgent.toLowerCase();
	this.nameB=navigator.userAgent.toLowerCase();
	// *** BROWSER VERSION ***
	// Note: On IE5, these return 4, so use is.ie5up to detect IE5.
	this.major = parseInt(navigator.appVersion);
	this.minor = parseFloat(navigator.appVersion);

	this.nav = ((agt.indexOf('mozilla')!=-1) && (agt.indexOf('spoofer')==-1) && (agt.indexOf('compatible') == -1) && (agt.indexOf('opera')==-1) && (agt.indexOf('webtv')==-1));
	this.nav2 = (this.nav && (this.major == 2));
    this.nav3 = (this.nav && (this.major == 3));
    this.nav4 = (this.nav && (this.major == 4));
    this.nav47up = (this.nav && this.major == 4 && this.minor > 4.6);
    this.nav4up = (this.nav && (this.major >= 4));
    this.navonly = (this.nav && ((agt.indexOf(";nav") != -1) ||
    (agt.indexOf("; nav") != -1)) );
    this.nav5 = (this.nav && (this.major == 5));
    this.nav5up = (this.nav && (this.major >= 5));

    this.ie = (agt.indexOf("msie") != -1);
    this.ie3 = (this.ie && (this.major < 4));
    this.ie4 = (this.ie && (this.major == 4) && (agt.indexOf("msie 5.")==-1) );
    this.ie4up = (this.ie &&(this.major >= 4));
    this.ie5 = (this.ie && (this.major == 4) && (agt.indexOf("msie 5.")!=-1) );
    this.ie5up = (this.ie &&!this.ie3 && !this.ie4);
    this.ie6 = (this.ie && (this.major == 4) && (agt.indexOf("msie 6.")!=-1) );

    // *** PLATFORM ***
    this.win = ( (agt.indexOf("win")!=-1) || (agt.indexOf("16bit")!=-1) );
    this.os2 = ((agt.indexOf("os/2")!=-1) ||
    (navigator.appVersion.indexOf("OS/2")!=-1) ||
    (agt.indexOf("ibm-webexplorer")!=-1));

    this.mac = (agt.indexOf("mac")!=-1);
}

/************************************************************************************
(c) frog werk inc., Copyright 2000, 2001, 2002,  All rights reserved.

THE CONTENTS OF THIS FILE ARE PROPRIETARY AND CONFIDENTIAL INFORMATION
*************************************************************************************/

var is = new Is();
var balFilename = null;
var isSupported = true;

if ( is.win )
{
	// Supported Windows browsers
	if ( is.ie5 || is.ie6 )
	{
		balFilename = "WindowsIE.js";
	}
	else if ( is.nav5up )
	{
		balFilename = "WindowsNav6.js";
	}
	else if ( is.nav47up )
	{
		//balFilename = "WindowsNav.js";
	}
}
else if (is.mac)
{
	if ( is.ie5up )
	{
		balFilename = "MacIE5.js";
	}
	else if ( is.ie4up )
	{
		//balFilename = "MacIE4.js";
	}
	else if ( is.nav4 )
	{
		//balFilename = "MacNav4.js";
	}
	else if ( is.nav5up )
	{
		balFilename = "WindowsNav6.js";
	}
}
if ( balFilename != null )
{
	document.writeln('<script language="javascript" src="' + balPath + balFilename + '"></script>');
}
else
{
	isSupported = false;
//	alert("browser not supported");
}
