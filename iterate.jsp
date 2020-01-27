<!DOCTYPE html>
<html>
  <head>
    <title>
      Un iteratope
    </title>
  </head>
  <%@taglib uri="WEB-INF/tld.tld" prefix="it" %>
  <body>

    <%
    java.util.Vector vettore = new java.util.Vector();
    vettore.addElement("1");
    vettore.addElement("2");
    vettore.addElement("3");
    vettore.addElement("4");
    int x= 0;
    %>



    Iterating over <%= vettore %> ...
    <p>

      <it:iterate collection="<%= vettore %>">
      <jsp:useBean id="item" scope="page" class="java.lang.String"/>
        Item<%=++x%>: <%= item %><br>
      </it:iterate>
    </p>

  </body>
</html>
