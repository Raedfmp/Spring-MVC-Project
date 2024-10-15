<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        .login-container {
            background-color: #ffffff;
            padding: 30px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 300px;
            text-align: center;
        }
        .login-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }
        .login-container form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .login-container input[type="text"],
        .login-container input[type="password"],
        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
            font-size: 14px;
        }
        .login-container input[type="submit"] {
            background-color: #007bff;
            background-color: #5FB404;
            background-color: #89ba17;
            color: white;
            cursor: pointer;
        }
        .login-container input[type="submit"]:hover {
            background-color: #0056b3;
            background-color: #2d4b00 ;
        }
        .create-account {
            margin-top: 15px;
        }
        .error-message {
            color: red;
            margin-top: 10px;
        }
        .success-message {
            color: green;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Create Account</h2>
        <form action="createNewAccount" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="role" placeholder="Role" required>
            <input type="submit" value="Create Account">
        </form>
        
        	<div class="create-account">
            	<!--  <p>Already have an account? <a href="/to_login">Login</a></p>    -->
            	  <p>Already have an account? <a href="${pageContext.request.contextPath}/to_login">Login</a>
        	</div>
        
        <div class="error-message"> ${error} <!-- Zeigt Fehlermeldungen an -->
        </div>
        <div class="success-message"> ${message} <!-- Zeigt Erfolgsmeldungen an -->
        </div>
    </div>
</body>
</html>
