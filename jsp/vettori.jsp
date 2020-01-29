<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>prova</title>
  </head>
  <%@taglib uri="WEB-INF/tld.tld" prefix="it" %>
  <body>
    <%@ page import="java.util.*" %>
    <%@ page import="com.esami.Esame" %>

    <form action="" method="get">
      Esame:<br>
      <input type="text" name="esame"><br>
      Voto<br>
      <input type="text" name="voto"><br>
      &nbsp;<br>
      <input type="submit" value="invia">
    </form>
    <%
    Vector vettore;
    Esame es;
    String esame,votoStr;
    int voto;
    Iterator it;
    vettore = (Vector)application.getAttribute("vettore");
    if (vettore == null) vettore = new Vector();

    esame = request.getParameter("esame");
    votoStr = request.getParameter("voto");

    if (esame != null && votoStr !=null){
      voto = Integer.parseInt(votoStr);
      es = new Esame(esame,voto);
      vettore.add(es);
      application.setAttribute("vettore",vettore);
    }
    %>
    <%=vettore%>
    <%
    it = vettore.iterator();
    while(it.hasNext()){
      es=(Esame)it.next();
      out.println(es.getEsame()+" ");
      out.println(es.getVoto()+"<br> ");
    }
    %>
    <it:esami max="<%=5%>">
      ciao
    </it:esami>

  </body>
</html>
