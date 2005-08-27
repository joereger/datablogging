package reger;

/**
 *
 */
public class MegaHtmlFormWysiwyg {

    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, boolean displayasadmin){
        StringBuffer mb = new StringBuffer();

        //Get the javascript form
        mb.append(theScript(pageProps));

        mb.append("<textarea name=\"comments\" class=input cols=35 rows=15 style=\"display:none; visibility:hidden;\"></textarea>");
        //mb.append("<textarea name=\"comments\" class=input cols=35 rows=15></textarea>");

        mb.append("<table cellpadding=0 cellspacing=0 border=0 bgcolor='cccccc' width='100%'>");
        mb.append("<tr><td>");

        mb.append("<table cellpadding=0 width='100%'>");
        mb.append("<tr><td>");
        mb.append("<div id='toolbar'>");
        mb.append("<table cellpadding=0 cellspacing=4 border=0>");
        mb.append("<tr><td nowrap>");
        mb.append("<select name='fontfaces' onchange=\"parent.formatText('FontName',this.value);\">");
        mb.append("<option value=''>Font Name");
        mb.append("<option value='Arial'>Arial");
        mb.append("<option value='Century'>Century");
        mb.append("<option value='Comic Sans MS'>Comic Sans");
        mb.append("<option value='Courier New'>Courier New");
        mb.append("<option value='Garamond'>Garamond");
        mb.append("<option value='Verdana'>Verdana");
        mb.append("<option value='Webdings'>Webdings");
        mb.append("<option value='Wingdings'>Wingdings");
        mb.append("</select>&nbsp;<select name='fontsizes' onchange=\"parent.formatText('FontSize',this.value);\">");
        mb.append("<option value=''>Font Size");
        mb.append("<option value='1'>xx-small");
        mb.append("<option value='2'>x-small");
        mb.append("<option value='3'>small");
        mb.append("<option value='4'>medium");
        mb.append("<option value='5'>large");
        mb.append("<option value='6'>x-large");
        mb.append("<option value='7'>xx-large");
        mb.append("</select></td><td nowrap><span onclick=\"colorPicker(this);\" onmouseover=\"this.style.cursor='hand';\"><img src='images/dhtmlimg/post_text-color.gif'  width=22 height=22 alt='Change the Font Color' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("></span></td>");
        mb.append("</tr></table>");
        mb.append("<table cellpadding=4 cellspacing=4 border=0>");
        mb.append("<tr><td class=clickable><img src='images/dhtmlimg/post_cut.gif' width=22 height=22	onclick=\"formatText('cut');\"		alt='Cut (Ctrl-X)' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_copy.gif' width=22 height=22	onclick=\"formatText('copy');\"		alt='Copy (Ctrl-C)' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_paste.gif' width=22 height=22 onclick=\"formatText('paste');\"	alt='Paste (Ctrt-V)' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_divider.gif' width=2 height=24 hspace=2><img src='images/dhtmlimg/post_bold.gif' onclick=\"formatText('bold');\" alt='Bold (Ctrl-B)' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_italics.gif' width=22 height=22 onclick=\"formatText('italic');\"	 alt='Italics (Ctrl-I)' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_underline.gif'  width=22 height=22 onclick=\"formatText('underline');\"	 alt='Underline (Ctrl-U)' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_strikethru.gif'  width=22 height=22 onclick=\"formatText('strikethrough');\"	 alt='Strikethrough' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_divider.gif' width=2 height=24 hspace=2><span onclick=\"smileyPicker(this);\"><img src='images/dhtmlimg/post_emoticons.gif'  width=22 height=22 alt='Insert Smilies' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("></span><img src='images/dhtmlimg/post_divider.gif' width=2 height=24 hspace=2><img src='images/dhtmlimg/post_hr.gif' onclick=\"formatText('inserthorizontalrule');\"	 alt='Insert a Horizontal Line' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_insert-link.gif'  width=22 height=22 onclick=\"formatText('CreateLink');\" alt='Insert a Hyperlink' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_insert-image.gif'  width=22 height=22 onclick=\"formatText('InsertImage');\" alt='Insert an Image' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_divider.gif' width=2 height=24 hspace=2><img src='images/dhtmlimg/post_justify-left.gif' onclick=\"formatText('justifyleft');\"	alt='Align Left' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_justify-center.gif'  width=22 height=22 onclick=\"formatText('justifycenter');\"	alt='Align Center' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_justify-right.gif'  width=22 height=22 onclick=\"formatText('justifyright');\"	alt='Align Right' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_divider.gif' width=2 height=24 hspace=2><img src='images/dhtmlimg/post_indent-left.gif' onclick=\"formatText('outdent');\"	alt='Outdent' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_indent-right.gif'  width=22 height=22 onclick=\"formatText('indent');\"	alt='Indent' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_divider.gif' width=2 height=24 hspace=2><img src='images/dhtmlimg/post_list-numbered.gif' onclick=\"formatText('insertorderedlist');\"	alt='Numbered List' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("><img src='images/dhtmlimg/post_list-bullet.gif'  width=22 height=22 onclick=\"formatText('insertunorderedlist');\"	alt='UnOrdered List' border=0 class='norm' onmouseover=\"this.className='raise';\" onmouseout=\"this.className='norm'\" onmousedown=\"this.className='depressed'\" onmouseup=\"this.className='raise';\"");
        mb.append("></td>");
        mb.append("</tr></table>");
        mb.append("</div>");

        mb.append("<iframe width='100%' height='200' id='vTextArea' tabindex=2></iframe>");
        mb.append("</td></tr></table>");

        mb.append("</td></tr></table>");


        return mb;
    }



    public static StringBuffer theScript(reger.pageFramework.PageProps pageProps){
        StringBuffer mb = new StringBuffer();


        mb.append("<style>" + "\n");
        mb.append("	<!--" + "\n");
        mb.append("	.norm {" + "\n");
        mb.append("		border: 1px solid #cccccc;" + "\n");
        mb.append("	}" + "\n");

        mb.append("	.raise {" + "\n");
        mb.append("		border-left: 1px solid buttonhighlight; border-right: 1px solid buttonshadow; border-top: 1px solid buttonhighlight; border-bottom: 1px solid buttonshadow;" + "\n");
        mb.append("	}" + "\n");

        mb.append("	.depressed {" + "\n");
        mb.append("		border-left:	1px solid buttonshadow;" + "\n");
        mb.append("		border-right:	1px solid buttonhighlight;" + "\n");
        mb.append("		border-top:		1px solid buttonshadow;" + "\n");
        mb.append("		border-bottom:	1px solid buttonhighlight;" + "\n");
        mb.append("	}" + "\n");
        mb.append("	-->" + "\n");
        mb.append("	</style>" + "\n");


        mb.append("	<script language=\"javascript\" type=\"text/javascript\">" + "\n");
        mb.append(" 	<!--" + "\n");
        mb.append("	var editTypeState;" + "\n");

        mb.append("	window.onload	= initPost" + "\n");
        mb.append("	document.forms.post.onSubmit = doSubmit;" + "\n");

        mb.append("	function initPost() {" + "\n");

        mb.append("		editTypeState = \"wysiwyg\";" + "\n");

        mb.append("		vTextArea.document.designMode = \"on\"" + "\n");
        mb.append("		vTextArea.document.open();" + "\n");
        mb.append("		vTextArea.document.write(\"<BODY STYLE=\\\"font:11pt Arial,Geneva,Sans-Serif;color:#000000;background-color:#ffffff \\\">\");" + "\n");
        mb.append("vTextArea.document.write( \"" + pageProps.entry.comments.replaceAll("(\n|\r)", "").replaceAll("\"", "\\\\\"") + "\" );" + "\n");


        mb.append("		vTextArea.document.close();" + "\n");


        mb.append("			}" + "\n");

        mb.append("	function formatText(command,optname) {" + "\n");

        mb.append("		var range = vTextArea.document.selection.createRange();" + "\n");
        mb.append("		var selectedText = range.text;" + "\n");

        mb.append("		if (selectedText == \"\") range = vTextArea.document;" + "\n");
        mb.append("		vTextArea.focus();" + "\n");

        mb.append("		switch(command) {" + "\n");
        mb.append("			case \"BackColor\":" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			case \"ForeColor\":" + "\n");
        mb.append("				if (optname == \"\") break;" + "\n");
        mb.append("				range.execCommand(\"ForeColor\",false,optname);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			case \"FormatBlock\":" + "\n");
        mb.append("				if (optname == \"\") break;" + "\n");
        mb.append("				range.execCommand(\"FormatBlock\",false,optname);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			case \"FontName\":" + "\n");
        mb.append("				if (optname == \"\") break;" + "\n");
        mb.append("				range.execCommand(\"FontName\",false,optname);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			case \"FontSize\":" + "\n");
        mb.append("				if (optname == \"\") break;" + "\n");
        mb.append("				range.execCommand(\"FontSize\",false,optname);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			case \"RemoveFormat\":" + "\n");
        mb.append("				if (optname == \"\") break;" + "\n");
        mb.append("				range.execCommand(\"RemoveFormat\",false,optname);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			case \"InsertImage\":" + "\n");
        mb.append("				var url = prompt(\"Enter the URL of the image you would like to link to: (the image must be hosted on another server)\", \"http://\");" + "\n");
        mb.append("				range.execCommand(\"InsertImage\",false,url);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("			default:" + "\n");
        mb.append("				range.execCommand(command);" + "\n");
        mb.append("				break;" + "\n");
        mb.append("		}" + "\n");

        mb.append("		if (selectedText != \"\")" + "\n");
        mb.append("			range.select();" + "\n");

        mb.append("		vTextArea.focus();" + "\n");
        mb.append("	}" + "\n");


        mb.append("	function insertSmilies(imageEl) {" + "\n");

        mb.append("		vTextArea.focus();" + "\n");
        mb.append("		var thisSelection = vTextArea.document.selection.createRange();" + "\n");

        mb.append("		thisSelection.pasteHTML(\"<img src=\" + imageEl.src + \" width=\" + imageEl.width + \" height=\" + imageEl.height + \">\");" + "\n");
        mb.append("		vTextArea.focus();" + "\n");
        mb.append("	}" + "\n");

        mb.append("	var cPopup;" + "\n");

        mb.append("	function colorPicker(el)" + "\n");
        mb.append("	{" + "\n");
        mb.append("		cPopup = window.createPopup();" + "\n");
        mb.append("		var baseC = new Array(\"00\",\"33\",\"66\",\"99\",\"CC\",\"FF\");" + "\n");
        mb.append("		var ct = \"<table cellpadding=10 cellspacing=0 border=0><tr><td><table cellpadding=0 cellspacing=1 border=0 bgcolor=666666>\";" + "\n");

        mb.append("		for (j = 0; j < 18; j++) {" + "\n");
        mb.append("			if (j < 6) g = 5-j;	else if (j < 12) g = j - 6;	else g = 17 - j;" + "\n");
        mb.append("			if (j < 7) { r1 = 5; r2 = 4; } else if (j < 13) { r1 = 2; r2 = 3; } else { r1 = 1; r2 = 0; }" + "\n");

        mb.append("			ct += \"<tr>\"" + "\n");
        mb.append("			for (i = 0; i < 12; i++) {" + "\n");
        mb.append("				if (i > 5) {" + "\n");
        mb.append("					b = 11 - i;" + "\n");
        mb.append("					color = baseC[r2] + baseC[g] + baseC[b];" + "\n");
        mb.append("				} else {" + "\n");
        mb.append("					b = i;" + "\n");
        mb.append("					color = baseC[r1] + baseC[g] + baseC[b];" + "\n");
        mb.append("				}" + "\n");
        mb.append("				ct += \"<td bgcolor=\" + color + \"><span onmouseover=\\\"textColor.style.backgroundColor='\" + color + \"';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','\" + color + \"');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td>\"" + "\n");
        mb.append("			}" + "\n");
        mb.append("			ct += \"</tr>\"" + "\n");

        mb.append("		}" + "\n");

        mb.append("		ct += \"</table></td><td style=\\\"padding-left: 10px\\\" align=center valign=top><br><br><table cellpadding=3 cellspacing=1 border=0 bgcolor=666666 onmouseover=\\\"textColor.style.backgroundColor='000000';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('RemoveFormat');parent.cPopup.hide();\\\"><tr bgcolor=ffffff><td><span style=\\\"background-color:000000\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=1></span></td><td style=\\\"font: 10pt Arial\\\" width=80 align=center>Automatic</td></tr></table><br><br><span id=\\\"textColor\\\"><img src=images/dhtmlimg/p.gif width=70 height=70 border=1></span><br><br><table cellpadding=0 cellspacing=1 border=0 bgcolor=666666 align=center><tr><td bgcolor=000000><span onmouseover=\\\"textColor.style.backgroundColor='000000';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','#000000');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td><td bgcolor=333333><span onmouseover=\\\"textColor.style.backgroundColor='333333';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','#333333');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td><td bgcolor=666666><span onmouseover=\\\"textColor.style.backgroundColor='666666';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','#666666');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td><td bgcolor=999999><span onmouseover=\\\"textColor.style.backgroundColor='999999';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','#999999');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td><td bgcolor=CCCCCC><span onmouseover=\\\"textColor.style.backgroundColor='CCCCCC';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','#CCCCCC');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td><td bgcolor=FFFFFF><span onmouseover=\\\"textColor.style.backgroundColor='FFFFFF';this.style.cursor='hand';\\\" onclick=\\\"parent.formatText('ForeColor','#FFFFFF');parent.cPopup.hide();\\\"><img src=images/dhtmlimg/p.gif width=15 height=15 border=0><br></span></td></tr></table></td></tr></table>\"" + "\n");

        mb.append("		cPopup.document.body.style.border = \"solid black 2px\";" + "\n");
        mb.append("		cPopup.document.body.innerHTML = ct;" + "\n");
        mb.append("		cPopup.show(0, 20, 340, 310, el);" + "\n");
        mb.append("	}" + "\n");

        mb.append("	function smileyPicker(el)" + "\n");
        mb.append("	{" + "\n");
        mb.append("		cPopup = window.createPopup();" + "\n");
        mb.append("		var types = new Array(\"smiley\",\"robot\",\"man\",\"woman\");" + "\n");
        mb.append("		var emotions = new Array(\"happy\",\"indifferent\",\"mad\",\"sad\",\"surprised\",\"tongue\",\"very-happy\",\"wink\");" + "\n");
        mb.append("		var img_start = \"<td><img src=images/dhtmlimg/16x16_\"" + "\n");
        mb.append("		var img_end = \".gif width=16 height=16 onclick=\\\"parent.insertSmilies(this);parent.cPopup.hide();\\\" onmouseover=\\\"this.style.cursor='hand';\\\"></td>\"" + "\n");
        mb.append("		var sbody = \"<table cellpadding=3 cellspacing=1 border=0>\";" + "\n");

        mb.append("		for (i = 0; i < types.length; i++) {" + "\n");
        mb.append("			sbody += \"<tr>\"" + "\n");
        mb.append("			for (j = 0; j < emotions.length; j++) {" + "\n");
        mb.append("				sbody += img_start + types[i] + \"-\" + emotions[j] + img_end" + "\n");
        mb.append("			}" + "\n");
        mb.append("			sbody += \"</tr>\"" + "\n");
        mb.append("		}" + "\n");
        mb.append("		sbody += \"</table>\"" + "\n");

        mb.append("		cPopup.document.body.style.border = \"solid black 2px\";" + "\n");
        mb.append("		cPopup.document.body.innerHTML = sbody;" + "\n");
        mb.append("		cPopup.show(0, 20, 190, 100, el);" + "\n");
        mb.append("	}" + "\n");

        mb.append("	function doSubmit() {" + "\n");
        mb.append("		var body;" + "\n");


        mb.append("		if (editTypeState == \"wysiwyg\")" + "\n");
        mb.append("			body = vTextArea.document.body.innerHTML;" + "\n");
        mb.append("		else" + "\n");
        mb.append("			body = vTextArea.document.body.innerText;" + "\n");


        mb.append("		var tagPos = body.indexOf(\"<FONT style=\\\"BACKGROUND-COLOR: \", 0);" + "\n");
        mb.append("		//var numRemoved = 0;" + "\n");

        mb.append("		while (tagPos >= 0) {" + "\n");
        mb.append("			if (body.charAt(tagPos + 39) == \">\")  {" + "\n");
        mb.append("				body = body.substring(0,tagPos) + body.substr(tagPos + 40);" + "\n");
        mb.append("				tagPos = body.indexOf(\"<FONT style=\\\"BACKGROUND-COLOR: \", tagPos+1);" + "\n");
        mb.append("				//numRemoved++;" + "\n");
        mb.append("			} else {" + "\n");
        mb.append("				tagPos = body.indexOf(\"<FONT style=\\\"BACKGROUND-COLOR: \", tagPos+39);" + "\n");
        mb.append("			}" + "\n");
        mb.append("		}" + "\n");
        mb.append("		//document.post[\"comments\"].value = body;" + "\n");
        mb.append("		document.entryform.comments.value = body;" + "\n");
        mb.append("		//document.post.numremoved.value = numRemoved;" + "\n");
        mb.append("	}" + "\n");

        mb.append("	function submitPost() {" + "\n");
        mb.append("		doSubmit();" + "\n");
        mb.append("		//document.entryform.submit();" + "\n");
        //@todo Need to test. This form was submitting two times.  First time from dHtml and second from html form. I commented out the next line.
        mb.append("		//document.forms.post.submit();" + "\n");
        mb.append("	}" + "\n");

        mb.append("	-->" + "\n");
        mb.append("	</script>" + "\n");

        return mb;
    }

}
