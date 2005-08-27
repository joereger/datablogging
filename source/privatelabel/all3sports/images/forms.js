// JavaScript Document

// I won't work without Basic.js!!!!

function isValidEmail(str) {
		str = chomp(str);
		if(str.length < 1) return false;
		
		var firstChar = str.charAt(0);
		var lastChar = str.charAt(str.length - 1);
		
		if(firstChar == "@" || firstChar == ".")
			return false;
		if(lastChar == "@" || lastChar == ".")
			return false;
		if(str.indexOf("@") != str.lastIndexOf("@"))
			return false;
		if(str.indexOf("..") > -1)
			return false;
		if(str.indexOf(".@") > -1 || str.indexOf("@.") > -1)
			return false;
		
		if (str.indexOf("@") == -1 || str.indexOf("@") == "")
		   return false;
		if (str.indexOf(".")==-1 || str.indexOf(".") == "")
		    return false;	
		if (str.indexOf(" ") != -1)
		    return false;
		if(str.lastIndexOf(".") < str.lastIndexOf("@"))
			return false;
		
 		return true;					
	}
function isValidEmailAlert(str){
	if(! isValidEmail(str)){
		alert("Invalid email address!");
		return false;
	}
	return true;	
}