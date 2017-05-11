<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<script language=javascript>
		
		function validateForm()
{
var x=document.forms["regForm"]["t1"].value
var y=document.forms["regForm"]["t2"].value
var a=document.forms["regForm"]["t3"].value
var b=document.forms["regForm"]["t4"].value
var c=document.forms["regForm"]["t5"].value

if (x==null || x=="")
  {
  alert("First name must be filled out");
  return false;
  }
  if (y==null || y=="")
  {
  alert("Last name must be filled out");
  return false;
  }
  if (a==null || a=="")
  {
  alert(" Phone no must be filled out");
  return false;
  }
  if (b==null || b=="")
  {
  alert("Login name must be filled out");
  return false;
  }
  if (c==null || c=="")
  {
  alert("Password must be filled out");
  return false;
  }
  
}
</script>
<title>MY FORM</title>
</head>
<body BGCOLOR="gray">
<form name="regForm" action="welcomeserve" onsubmit="return validateForm();" method="post">
<center><b><u>
<h1> FORM </h1></u></b></center>
<br><br>
<h3><b>CREATE AN ACCOUNT</b></h3>
Your Account gives you access to the service..................
<hr />
 <br><br>
 First Name::.....................................<input type="text" name="t1"><br><br>
 Last Name::..................................... <input type="text" name="t2"><br><br>
 Phone Number::............................... <input type="text" name="t3"><br><br>
 Desired Login Name::...................... <input type="text" name="t4"><br><br>
 Choose Password::.......................... <input type="password" name="t5"><br>
 <br><br>
 <input type="submit" value="CREATE">
 </form>
</body>
</html>