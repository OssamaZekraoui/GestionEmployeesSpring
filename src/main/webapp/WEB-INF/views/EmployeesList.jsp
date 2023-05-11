<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Employees List</title>
    </head>
    <body>
        <header>
           <h1>Employees List</h1>
        </header>
        <main>
           <table>
             <tr>
                 <th>Employee Id</th>
                 <th>FirstName</th>
                 <th>LastName</th>
                 <th>Address</th>
                 <th>Email</th>
                 <th>Phone</th>
                 <th>Salary</th>
                 <th>Recruitment Date </th>
             </tr>
            <c:forEach items="${employeesJsp}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstname}</td>
                <td>${employee.lastname}</td>
                <td>${employee.address}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>${employee.salary} $</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.recruitmentDate}"/></td>


                <td> <a onClick="return confirm('Are you sure to delete this item ?')"
                href="deleteEmployee?id=${employee.id}">
                 Delete</a> <td>

                <td> <a href="showEmployee?id=${employee.id}"> Edit</a> <td>

            </tr>
            </c:forEach>
           </table>
        </main>
        <footer>
          <a href="createEmployee">Employee Creation</a>
        </footer>
    </body>
</html>

