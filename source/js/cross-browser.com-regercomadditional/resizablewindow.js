// object-oriented version - see drag1.php for a procedural version
function xFenster(windowId, eleId, iniX, iniY, iniW, iniH, barId, resBtnId, contentId, isDraggable, isResizable){
  // Private Properties
  var windowId = windowId;
  var me = this;
  var ele = xGetElementById(eleId);
  var rBtn = xGetElementById(resBtnId);
  var rContent = xGetElementById(contentId);
  var x, y, w, h;
  var isDraggable = isDraggable;
  var isResizable = isResizable;
  // Public Methods
  this.onunload = function(){
    if (xIE4Up) { // clear cir refs
      xDisableDrag(barId);
      xDisableDrag(rBtn);
      me = ele = rBtn = null;
    }
  }
  this.paint = function(){
    xMoveTo(rBtn, xWidth(ele) - xWidth(rBtn), xHeight(ele) - xHeight(rBtn));
  }
  this.getCoordsAsString = function()
  {
    return windowId+","+x+","+y+","+w+","+h;
  }
  this.resizeAbsolute = function(inWidth, inHeight){
        w = inWidth;
        h = inHeight;
        if (w>50 && h>50){
            xResizeTo(ele, w, h);
            resizeContentPane();
            me.paint();
        } else {
            w = xWidth(ele);
            h = xHeight(ele);
        }
  }
  // Private Event Listeners
  function barOnDrag(e, mdx, mdy){
    if (isDraggable){
        x = xLeft(ele) + mdx;
        y = xTop(ele) + mdy;
        if ((x+xWidth(ele))>10 && y>0){
            xMoveTo(ele, x, y);
        } else {
            x = xLeft(ele);
            y = xTop(ele);
        }
    }
  }

  function resOnDrag(e, mdx, mdy){
    if (isResizable){
        w = xWidth(ele) + mdx;
        h = xHeight(ele) + mdy;
        if (w>50 && h>50){
            xResizeTo(ele, w, h);
            resizeContentPane();
            me.paint();
        } else {
            w = xWidth(ele);
            h = xHeight(ele);
        }
    }
  }

  function resEndDrag(e, mdx, mdy){
    x = snapTo(x);
    y = snapTo(y);
    w = snapTo(w);
    h = snapTo(h);
    xMoveTo(ele, x, y);
    xResizeTo(ele, w, h);
    resizeContentPane();
  }

  function resizeContentPane(){
       xCon = xPageX(rContent);
       yCon = xPageY(rContent);
       xWin = xPageX(ele);
       yWin = xPageY(ele);
       xWinLowerRightCornerX = xWin + w;
       xWinLowerRightCornerY = yWin + h;
       wCon = xWinLowerRightCornerX - xCon;
       hCon = xWinLowerRightCornerY - yCon;
       xResizeTo(rContent, wCon-30, hCon-30);
  }
  function snapTo(i){
    //alert("Snap to start. i=" + i);
    var mod = (i % 6);
    if (mod<=3){
        //alert("Snap to end. i-mod=" + (i-mod));
        return i-mod;
    } else {
        //alert("Snap to end. i+(10-mod)=" + (i+(10-mod)));
        return i+(6-mod)
    }
  }
  function fenOnMousedown(){
    xZIndex(ele, xFenster.z++);
  }
  // Constructor Code
  xFenster.z++;
  x=iniX;
  y=iniY;
  w=iniW;
  h=iniH;
  xMoveTo(ele, x, y);
  //this.paint();
  xResizeTo(ele, w, h);
  resizeContentPane();
  if (isDraggable){
      xEnableDrag(barId, null, barOnDrag, resEndDrag);
      xEnableDrag(rBtn, null, resOnDrag, resEndDrag);
  }
  this.paint();
  ele.onmousedown = fenOnMousedown;
  xShow(ele);
} // end xFenster object prototype
xFenster.z = 0; // xFenster static property

