function leaveEntryPage(href) {
    xGetElementById('entryform').action.value = "leavepage";
    xGetElementById('gotopage').value = href;
    //document.entryform.action.value = "leavepage";
    //document.entryform.gotopage.value = href;
    //This submitPost() is a javascript method required by any editor that I put in place.
    //It can be a simple wrapper method that just calls document.entryform.submit()
    submitPost();
}