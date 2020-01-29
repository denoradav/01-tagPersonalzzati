<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>

  <%@taglib uri="WEB-INF/tld.tld" prefix="it" %>
  <body>
    <form action="" method="post">
      Esame:<br>
      <input type="text" name="esame"><br>
      Voto
      <input type="text" name="voto"><br>
    </form>

    <it:esami esame="italiano" votoStr="27">
      <jsp:useBean id="esame" class="com.esami.Esame" scope="application"/>
      <%=esame.getEsame()%> : <%=esame.getVoto()%> <br>
    </it:esami>
  </body>
</html>
