<!DOCTYPE html>
<html>
  <head>
    <title>
      Un iteratope
    </title>
  </head>
  <%@taglib uri="WEB-INF/tld.tld" prefix="it" %>
  <%@page import="com.esami.Esame,java.util.Vector" %>
  <body>
    <form>
      Esame: <input type="text" name="esame"> 
      Voto: <input type="number" name="voto">
      <input type="submit" value="INVIA">
    </form>
    <%=(application.getAttribute("vettore")!=null)%>
    <%
    Vector vettore;
    if (application.getAttribute("vettore")!=null){
      vettore = (Vector)application.getAttribute("vettore");
    } else {
      vettore = new Vector();
    }

    String esame = request.getParameter("esame");
    String votoStr = request.getParameter("voto");

    if (esame!=null && votoStr != null){
      int voto = Integer.parseInt(votoStr);
      vettore.addElement(new Esame(esame,voto));
    }

    application.setAttribute("vettore",vettore);
    %>



    Iterating over <%= vettore %> ...
    <p>

      <it:iterate collection="<%= vettore %>">
      <jsp:useBean id="item" scope="page" class="com.esami.Esame"/>
        <%=item.getEsame()%> -  <%=item.getVoto()%><br>
        <%=pageContext.getAttribute("media")%>
      </it:iterate>
    </p>

  </body>
</html>
