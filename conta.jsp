<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>conta</title>
</head>
<body>
<%@taglib uri="WEB-INF/tld.tld" prefix="it"%>    
</body>
<it:sci max="8">
    <jsp:useBean id="stringa" class="java.lang.String" />
    <%= stringa%><br>
</it:sci>
</html>