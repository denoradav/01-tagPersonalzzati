<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Iterator2</title>
    <%@ page import="java.util.Vector" %>
  </head>
  <body>
    <%
    Vector vettore = new Vector();
    vettore.addElement("ciao1");
    vettore.addElement("ciao2");
    vettore.addElement("ciao3");
    vettore.addElement("ciao3");

    %>
    <%@taglib uri="/WEB-INF/tld2.tld" prefix="myIt" %>
    <myIt:iterate2 vettore="<%=vettore%>">
        <jsp:useBean id="valore" class="java.lang.String" scope="page" />
        <%=valore%><br>
    </myIt:iterate2>
  </body>
</html>
