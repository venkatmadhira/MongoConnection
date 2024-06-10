<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurant App</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
            border-radius: 8px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }
        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
        }
        .message {
            text-align: center;
            font-size: 16px;
            color: #ff0000;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Restaurant App</h1>

        <h2>Add User</h2>
        <form action="addUser" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" required>
            <input type="submit" value="Add User and Send OTP">
        </form>

        <h2>Validate OTP</h2>
        <form action="validateOtp" method="post">
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" required>
            <label for="otp">OTP:</label>
            <input type="text" id="otp" name="otp" required>
            <input type="submit" value="Validate OTP">
        </form>

        <div class="message">
            <%
                String message = (String) request.getAttribute("message");
                if (message != null) {
                    out.print("<p>" + message + "</p>");
                }
            %>
        </div>
    </div>
</body>
</html>
