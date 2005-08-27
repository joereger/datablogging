<%
if (request.getMethod().equals("GET") && !reger.cache.HtmlCache.isStale(cachekey, refreshintervalinseconds)){
    mb.append(reger.cache.HtmlCache.getFromCache(cachekey));
} else {
%>