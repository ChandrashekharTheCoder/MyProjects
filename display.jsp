<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISPLAY</title>
</head>
<body bgcolor="gray">
<form action="success" method="post">
<center>

<% String s=(String)session.getAttribute("value");
out.print("YOUR AMOUNT::"+s);
%><br>
Enter your Credit Card No::
<input type="text" name="t1"><br>
Enter your Ammount::
<input type="text" name="t2"><br>
<input type="submit" value="OK">
</center>

</body>
</html>