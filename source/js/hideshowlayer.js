
<!--

ns4x = (document.layers)? true:false
ie4x = (document.all)? true:false

// Show/Hide functions for pointer objects

function show(id) {
    ////if (ns4x) document.layers[id].visibility = "show"
    //if (ns4x) document.getElementById(id).style.visibility = "visible"
    //else if (ie4x) document.all[id].style.visibility = "visible"

    ////if (ns4x) document.layers[id].display = "inline"
    //if (ns4x) document.getElementById(id).style.display = "inline"
    //else if (ie4x) document.all[id].style.display = "inline"

     if (ie4x || document.all) {
        document.all[id].style.visibility = "visible"
        document.all[id].style.display = "inline"
     } else if (document.getElementById!= null){
        document.getElementById(id).style.visibility = "visible"
        document.getElementById(id).style.display = "inline"
     } //else if (document.all) {
        //document.all[id].style.visibility = "visible"
        //document.all[id].style.display = "inline"
     //}



}

function hide(id) {
    ////if (ns4x) document.layers[id].visibility = "hide"
    //if (ns4x) document.getElementById(id).style.visibility = "hide"
    //else if (ie4x) document.all[id].style.visibility = "hidden"

    ////if (ns4x) document.layers[id].display = "none"
    //if (ns4x) document.getElementById(id).style.display = "none"
    //else if (ie4x) document.all[id].style.display = "none"

    if (ie4x || document.all) {
        document.all[id].style.visibility = "hidden"
        document.all[id].style.display = "none"
    } else if (document.getElementById!= null){
        document.getElementById(id).style.visibility = "hidden"
        document.getElementById(id).style.display = "none"
     } //else if (document.all) {
        //document.all[id].style.visibility = "hidden"
        //document.all[id].style.display = "none"
     //}


}

function changevalueofinputbox(id, newvalue) {
    ////if (ns4x) document.layers[id].value = newvalue
    //if (ns4x) document.getElementById(id).value = newvalue
    //else if (ie4x) document.all[id].value = newvalue

    if (document.getElementById!= null){
        document.getElementById(id).value = newvalue
     } else if (document.all) {
        document.all[id].value = newvalue
     }

}

function hideandshow(idtohide, idtoshow){
    hide(idtohide)
    show(idtoshow)
}

//-->
