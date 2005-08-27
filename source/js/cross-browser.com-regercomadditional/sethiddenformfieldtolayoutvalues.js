
function setHiddenFormFieldToLayoutValues(arrayOfResizableWindows){
    var output = "";
    for (var i = 0; i < arrayOfResizableWindows.length; ++i) {
        output = output + arrayOfResizableWindows[i].getCoordsAsString()+"|";
    }
    document.getElementById('fieldorderholder').value = output;
}