<!DOCTYPE html>
<html lang="en">
    <head>
    <link rel="stylesheet" type="text/css" href="" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css" />
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Employee Creation</title>
    </head>
    <body>
        <header>
            <h1>Employee Creation</h1>
        </header>
        <main>
            <form action="saveEmployee" method="post">
                <div>
                    <label for="firstname">Employee Firstname : </label>
                    <input type="text" id="firstname" name="firstname">
                </div>
                <div>
                    <label for="lastname">Employee Lastname : </label>
                    <input type="text" id="lastname" name="lastname">
                </div>
                <div>
                    <label for="address">Address : </label>
                    <input type="text" id="address" name="address">
                </div>
                <div>
                    <label for="email">Email : </label>
                    <input type="text" id="email" name="email">
                </div>
                <div>
                    <label for="phone">Phone : </label>
                    <input type="text" id="phone" name="phone">
                </div>
                <div>
                    <label for="salary">Salary : </label>
                    <input type="number" id="salary" name="salary">
                </div>
                <div>
                    <label for="recruitmentDate">Recruitment Date : </label>
                    <input type="date" id="recruitmentDate" name="dateJsp" value="{now}">
                </div>
                <div>
                    <input type="submit" value="Save">
                </div>
            </form>
            ${messageJsp}
        </main>
        <footer>
            <a href="employeesList">Employees List</a>
        </footer>
    </body>
</html>
