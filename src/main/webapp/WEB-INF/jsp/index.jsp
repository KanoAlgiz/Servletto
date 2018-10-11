<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Super Duper Servlet App</title>
        <meta chartset = "utf-8">
        <script>
            function sendstate(element){
              var request = new XMLHttpRequest();
              request.open(element.value, "/servletto-1.0/request", true);
              request.onreadystatechange = function(){
                if(this.readyState == 4 && this.status == 200){
                     document.getElementById("texter").innerHTML="Server State - " + this.responseText;
                }
              }
              request.send();
            }
        </script>
    </head>
    <body>
            <input type="button" value="GET" onclick="sendstate(this)">
            <input type="button" value="PUT" onclick="sendstate(this)">
            <input type="button" value="POST" onclick="sendstate(this)">
            <input type="button" value="DELETE" onclick="sendstate(this)">
            </br>
        <span id="texter">Server State - GET!</span>

        <h3>Hello for the <c:if test="${attr=='1'}">first</c:if><c:if test="${attr!='1'}">${attr}th</c:if> time!</h3>
    </body>
</html>
