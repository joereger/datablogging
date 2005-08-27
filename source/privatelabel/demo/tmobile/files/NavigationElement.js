/************************************************************************************
(c) frog werk inc., Copyright 2000, 2001, 2002,  All rights reserved.

THE CONTENTS OF THIS FILE ARE PROPRIETARY AND CONFIDENTIAL INFORMATION
*************************************************************************************/

var g_selectedWidget = null;

//instance name start, number subelements,
function NavigationElement(id,instanceName,numberElements,imageDir,isMouseOut,sInactiveColor, sActiveColor)
{
	this.id = id;
	this.instanceName = instanceName + "Element";

	this.divObjArr = new Array();
	this.imageArr = new Array();
	this.imgOffObjArr = new Array();
	this.imgOnObjArr = new Array();
	this.imageName =  imageDir + instanceName + "_";
	this.numberElements = numberElements;
	this.selectedElement = -1;
	this.isMouseOut = isMouseOut;
	this.init = false;
	this.inactiveColor = sInactiveColor;
	this.activeColor = sActiveColor;

	// method declarations
	this.changeElementVisibility = changeElementVisibilityMethod;
	this.swapImage 		= swapImageMethod;
	this.activate		= activateMethod;
	this.openElement	= openElementMethod;
	this.setup			= setupMethod;
	this.deactivate		= deactivate;
    this.toggleDropDown = toggleDropDown;

	function setNavElementAttributes(divObj,instanceName,visibleValue,displayValue,isMouseOut)
	{
		if (isMouseOut) BrowserAbstractionLayer.addEventHandler(divObj,"OUT","onMouseOutHandler");
		BrowserAbstractionLayer.setVisibility(divObj,visibleValue)
		BrowserAbstractionLayer.setDisplay(divObj,displayValue)
	}

	function setupMethod()
	{
		for ( x = 0; x < this.numberElements; x++ )
		{
			this.divObjArr[x] = BrowserAbstractionLayer.getDivObj(this.instanceName + x);
			if (typeof this.divObjArr[x] != "undefined")
			{
				setNavElementAttributes(this.divObjArr[x], this.instanceName, "hidden", "none", this.isMouseOut);
			}
		}
		this.init = true;
	}

	function activateMethod(selectedElement)
	{
		if( this.init == false || this.selectedElement == selectedElement ) { return false; };
		if( g_selectedWidget != null) {g_selectedWidget.deactivate();}
		this.deactivate();
		this.selectedElement = selectedElement;
        this.toggleDropDown(false);
		this.changeElementVisibility(this.divObjArr[selectedElement],"visible","");
		var eElement = BrowserAbstractionLayer.getDivObj( this.instanceName + "Parent" + selectedElement );
		BrowserAbstractionLayer.swapBackground( eElement, this.activeColor )
		g_selectedWidget = this;
        return true;
	}

	function deactivate()
	{
		if( this.init == false ) { return false };
		if ( this.selectedElement != -1 )
		{
			var selEl = this.selectedElement;
			this.changeElementVisibility(this.divObjArr[selEl],"hidden","none");
            this.toggleDropDown(true);
			if( this.selectedElement != window.defaultMenuItem ) {
				var eElement = BrowserAbstractionLayer.getDivObj( this.instanceName + "Parent" + selEl );
				BrowserAbstractionLayer.swapBackground( eElement, this.inactiveColor )
			} else {
				//this.swapImage(this.imageArr[selEl],window.defaultMenuImage);
			}
			this.selectedElement = -1;
			g_selectedWidget = null;
		}
        return true;
	}

	function swapImageMethod(imageObjRef,newImage)
	{
		imageObjRef.src = newImage.src;
	}

	function changeElementVisibilityMethod(obj,visibilityProp,displayProp)
	{
		BrowserAbstractionLayer.setVisibility(obj,visibilityProp);
		BrowserAbstractionLayer.setDisplay(obj,displayProp);
	}

	function openElementMethod(selectedElement)
	{
		this.activate(selectedElement);
		return false;
	}

    function toggleDropDown(bShow)
    {
        eSelects = document.getElementsByTagName("SELECT");
        for( var i=0; i < eSelects.length; i++)
        {
            if( bShow == false && eSelects[i].isHide == "true" )
            {
                eSelects[i].style.visibility = "hidden";
            }
            else
            {
                eSelects[i].style.visibility = "visible";
            }
        }
    }

}

function displayMenu(oNavElement,thisElement){
	eval("if (typeof "+oNavElement+" != 'undefined') "+oNavElement+".openElement(thisElement)");
}
