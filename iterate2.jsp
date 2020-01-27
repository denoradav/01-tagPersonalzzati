<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Iteazion2</title>
  </head>
    <%@taglib uri="WEB-INF/tld.tld" prefix="it" %>
  <body>
    <it:iterate2>
      <jsp:useBean id="count" scope="page" class="java.lang.String"/>
      Ciao  <%=  count%> - <br>
    </it:iterate2>
  </body>
</html>
