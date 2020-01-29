<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>My iterator</title>
  </head>
  <body>
    <%@taglib prefix="myIt" uri="/WEB-INF/tld2.tld" /%>
    <myIt:iterate>
        <jsp:useBean id="parola" class="java.lang.String" scope="pagina" />
        <%=parola%>
    </myIt:iterate>

  </body>
</html>
