<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Activity" %>
<%! private Activity activity; %>
<% activity = (Activity) request.getAttribute("activity"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Annie+Use+Your+Telescope|Trade+Winds" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>ToDo - edit</title>
    <style>
        body {
            background-color: #e6e6e6;
        }
        .headers {
            font-family: 'Trade Winds', cursive;
            color: #0047b3;
        }
        #main_table {
            width: 90%;
            text-align: center;
            font-family: 'Annie Use Your Telescope', cursive;
            border-collapse: collapse;
        }
        #main_table th {
            background-color: #0047b3;
            color: white;
            font-weight: bold;
        }
        #main_table th, td {
            border: 1px solid #cccccc;
            padding: 10px;
        }

        #edit_activ {
            font-family: 'Annie Use Your Telescope', cursive;
        }
        #edit_activ input {
            background-color: #d9d9d9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="headers">Let's see what is too hard for you today...</h1>
    <br><br>
    <div class="row">
        <div class="col-md-8 col-sm-12">
            <h3 class="headers">Your activity <small> which was too difficult for you... </small></h3>
            <div class="table-responsive">
                <table class="table table-hover" id="main_table">
                    <tr>
                        <th width="8%"><h3>Id</h3></th>
                        <th width="47%"><h3>Activity</h3></th>
                        <th width="30%" colspan="2"><h3>Deadline</h3></th>
                        <th width="15%"><h3>Options</h3></th>
                    </tr>
                    <tr>
                        <td><h4><%= activity.getId() %></h4></td>
                        <td><h4><%= activity.getaName() %></h4></td>
                        <td><h4><%= activity.getaDate() %></h4></td>
                        <td><h4><%= activity.getaTime() %></h4></td>
                        <td><a href="DelActivity?id=<%= activity.getId() %>"><button type="button" class="btn btn-primary">I did it!</button></a>
                        </td>
                    </tr>
                </table>
                <br><br>
            </div>
        </div>
        <div class="col-md-4 col-sm-8" id="edit_activ">
            <h3 class="headers">Edit activity <small>it was too hard?</small></h3><br>
            <form method="post" action="EditActivity">
                <div class="form-group">
                    <label for="id">Which activity?</label>
                    <input class="form-control" type="number" name="id" id="id" value="<%= activity.getId() %>" readonly><br>
                </div>
                <div class="form-group">
                    <label for="name">What are you going to do this time? </label>
                    <input class="form-control" type="text" name="name" placeholder="something useless" id="name" required><br>
                </div>
                <div class="form-group">
                    <label for="date">Set the new realizable deadline... </label>
                    <input class="form-control" type="date" name="date" id="date" required><br>
                    <input class="form-control" type="text" placeholder="e.g. 12:00" pattern="([0-1][0-9]|[2][0-3]):[0-5][0-9]" name="time" id="time"><br>
                </div>
                <button class="btn btn-info" type="submit">I'm a lame duck!</button>
            </form>
        </div>
    </div>
    <footer>
        <br>

        <a href="SqlServlet"><button type="button" class="btn btn-default">Back to main list</button></a><br>
    </footer>
</div>
</body>
</html>