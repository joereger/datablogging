// JavaScript Document

function chomp (inputString) {
	if(inputString.length == 0) return inputString;
	var returnString = inputString;
	var removeChar = " ";
	while(''+returnString.charAt(0)==removeChar){
	  returnString=returnString.substring(1,returnString.length);
	}
	while(''+returnString.charAt(returnString.length-1)==removeChar) {
	returnString=returnString.substring(0,returnString.length-1);
	}
	return returnString;
}
function removeLeadingChar (inputString, removeChar){
	var returnString = inputString;
	if (removeChar.length){
	  while(''+returnString.charAt(0)==removeChar){
		  returnString=returnString.substring(1,returnString.length);
		}
	}
	return returnString;
}
function hasAtLeastOneCharacter (inputString){
  return chomp(inputString).length;
}
// Check whether string s is empty.

function isEmpty(s)
{   return ((s == null) || (s.length == 0))
}

function isEmptyString (inputString){
	if(chomp(inputString).length > 0)
  		return false;
	else
		return true;
}
function isMMDDYYYYFormat(inputString){
	//alert('Input String ' + inputString);
	var theString = chomp(inputString);
	if(theString.length != 10) return false;
	if(theString.charAt(2) != "/") return false;
	if(theString.charAt(5) != "/") return false;
	var month = theString.substring(0,2);
	var day = theString.substring(3,5);
	var year = theString.substring(6,10);
	//alert(month + ' ' + day + ' ' + year);
	if(isNaN(month)) return false;
	if(isNaN(day)) return false;
	if(isNaN(year)) return false;
	return true;
}
function isCurrency(inputString){
	var theString = chomp(inputString);
	theString = removeLeadingChar(theString, "$");
	return !isNaN(theString);
}
function isCurrencyWithAlert(inputString){
	if(!isCurrency(inputString)){
		alert("This field must be currency: $00.00 or 00.00 format.");
		return false;
	}
	return true;
}