<%@ page import="com.example.Info" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Output</title>
</head>

<style>
    table {
        border-collapse: collapse;
        border-color: green;
    }

    td {
        padding: 12px 24px;
    }

</style>
<body>
<%
    Info inf = (Info) request.getAttribute("info");
    System.out.println(inf);

%>
<table border="1">
    <tbody>
    <tr>
        <td>Name</td>
        <td><%= inf.getName() %></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><%= inf.getEmail() %></td>
    </tr>
    <tr>
        <td>Birthday</td>
        <td><%= inf.getBirthday() %></td>
    </tr>
    <tr>
        <td>Birthtime</td>
        <td><%= inf.getBirthTime() %></td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><%= inf.getGender() %></td>
    </tr>
    <tr>
        <td>Country</td>
        <td><%= inf.getCountry() %></td>
    </tr>
    <tr>
        <td>IDE</td>
        <td><%= Arrays.toString(inf.getIdes()) %></td>
    </tr>
    <tr>
        <td>Message</td>
        <td><%= inf.getMessage() %></td>
    </tr>
    </tbody>
</table>

</body>
</html>