var savedlayoutbeforeleavingpage = false;

function savelayout(){
    if (!savedlayoutbeforeleavingpage){
        setHiddenFormFieldToLayoutValues(fen);
        var fieldorderholder = document.getElementById('fieldorderholder').value;
        var logid = document.getElementById('slf-logid').value;
        FieldLayoutSave.processLayoutChange(savelayoutcallback, logid, 0, 0, "savelayout", fieldorderholder);
        savedlayoutbeforeleavingpage = true;
    }
}

function savelayoutcallback(result){

}