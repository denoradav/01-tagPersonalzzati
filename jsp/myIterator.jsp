<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>My iterator</title>
  </head>
  <body>
    <%@taglib uri="/WEB-INF/tld2.tld" prefix="it" %>
    <it:iterate>
        <jsp:useBean id="parola" class="java.lang.String" scope="page" />
        <%=parola%>
    </it:iterate>

  </body>
</html>
