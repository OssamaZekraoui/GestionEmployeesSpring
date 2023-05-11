<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Employee Creation</title>
    </head>
    <body>
        <header>
            <h1>Employee Edition</h1>
        </header>
        <main>
            <form action="updateEmployee" method="post">
                <div>
                    <label for="id">Employee Id : </label>
                    <input type="text" id="id" name="id" value="${employeeJsp.id}">
                </div>

                <div>
                    <label for="firstname">Employee Firstname : </label>
                    <input type="text" id="firstname" name="firstname" value="${employeeJsp.firstname}">
                </div>
                <div>
                    <label for="lastname">Employee Lastname : </label>
                    <input type="text" id="lastname" name="lastname" value="${employeeJsp.lastname}">
                </div>
                <div>
                    <label for="address">Address : </label>
                    <input type="text" id="address" name="address" value="${employeeJsp.address}">
                </div>
                <div>
                    <label for="email">Email : </label>
                    <input type="text" id="email" name="email" value="${employeeJsp.email}">
                </div>
                <div>
                    <label for="phone">Phone : </label>
                    <input type="text" id="phone" name="phone" value="${employeeJsp.phone}">
                </div>
                <div>
                    <label for="salary">Salary : </label>
                    <input type="number" id="salary" name="salary" value="${employeeJsp.salary}">
                </div>
                <div>
                    <label for="recruitmentDate">Recruitment Date : </label>
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeJsp.recruitmentDate}" var="formatDate" />
                    <input type="date" id="recruitmentDate" name="dateJsp" value="${formatDate}">
                </div>
                <div>
                    <input type="submit" value="Update">
                </div>
            </form>
            ${messageJsp}
        </main>
        <footer>
            <a href="employeesList">Employees List</a>
        </footer>
    </body>
</html>
