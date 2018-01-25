<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Annie+Use+Your+Telescope|Trade+Winds">
    <title>ToDo</title>
    <style>
        .jumbotron {
            font-family: 'Annie Use Your Telescope', cursive;
        }
        .alert {
            font-family: 'Trade Winds', cursive;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<main>
    <div class="jumbotron text-center">
        <h2>ERROR !!!</h2>
        <h3>Ok, I know that you did it on purpose!</h3>
        <h3>Something went wrong... you managed to spoil my app. It was mean of you!</h3>
        <h4>Let's try one more time... <br><br>
            <a href="SqlServlet"><button type="button" class="btn-primary btn-lg">I won't do it again!</button></a><br><br>
            <a href="index.jsp"><button type="button" class="btn-primary btn-lg">Go back to main page!</button></a>
        </h4>
    </div>
</main>
<footer>
    <div class="alert alert-info text-center">
        <h4><span class="glyphicon glyphicon-eye-close"></span> As you can see - I didn't focus on the visual side</h4>
        <h4><span class="glyphicon glyphicon-remove-sign"></span> This app won't evolve in future...</h4>
        <h4><span class="glyphicon glyphicon-warning-sign"></span> But It doesn't mean that you have to spoil it</h4>
    </div>
</footer>
</body>
</html>