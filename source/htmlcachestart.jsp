<%
if (request.getMethod().equals("GET") && !reger.cache.html.HtmlCache.isStale(cachekey, refreshintervalinseconds)){
    mb.append(reger.cache.html.HtmlCache.getFromCache(cachekey));
} else {
%>