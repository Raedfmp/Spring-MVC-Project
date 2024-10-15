<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
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
        .welcome-container {
            background-color: #ffffff;
            padding: 30px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 300px;
            text-align: center;
        }
        .welcome-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }
        .welcome-container p {
            font-size: 18px;
            margin-bottom: 20px;
        }
        .logout-button {
            padding: 10px 20px;
            background-color: #89ba17;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .logout-button:hover {
            background-color: #2d4b00;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h2>Welcome</h2>
        <p>You are logged in successfully!</p>
        <form action="logout" method="get">
            <input type="submit" class="logout-button" value="Logout">
        </form>
    </div>
</body>
</html>
