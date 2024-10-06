<%@page language="java" %>
<html>
    <body>
        <h1>The sum of <%= session.getAttribute("num1") %> and <%= session.getAttribute("num2") %> is: <%= session.getAttribute("result") %> </h1>
        <h2>The output using JSTL is: ${result}</h2>
    </body>
</html>