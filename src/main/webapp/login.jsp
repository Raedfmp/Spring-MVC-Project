<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
            background-color: #89ba17;
            color: white;
            cursor: pointer;
        }
        .login-container input[type="submit"]:hover {
            background-color: #2d4b00;
        }
        .create-account {
            margin-top: 0px;
        }
        .error-message {
            color: red;
            margin-top: 10px;
            font-weight: bold; /* Macht die Schrift fett */
        }
        
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="role" placeholder="Role" required>
            <input type="submit" value="Login">
        </form>
        <div class="create-account">
        <form action="createAccount" method="post">
            <p>Don't have an account? <a href="createAccount">Create Account</a></p>
        </form>
        </div>
        <div class="error-message">
            ${error}  <!-- Zeigt Fehlernachrichten bei falschen Anmeldedaten an -->
        </div>
    </div>
</body>
</html>
