<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Activity, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Annie+Use+Your+Telescope|Trade+Winds" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>ToDo</title>
    <style>
        .headers {
            font-family: 'Trade Winds', cursive;
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
            border: 1px solid #e6e6e6;
            padding: 10px;
        }
        #main_table tr:nth-child(even){
            background-color: #d9d9d9;
        }
        #new_activ {
            font-family: 'Annie Use Your Telescope', cursive;
        }
    </style>
</head>
<body>
<div class="container">
<main>
        <h1 class="headers">Let's see what you have to do today...</h1>
        <br><br>
        <div class="row">
            <div class="col-sm-8">
                <h3 class="headers">List of you activities</h3>
                <table class="table-hover" id="main_table">
                    <tr>
                        <th width="10%"><h3>No.</h3></th>
                        <th width="55%"><h3>Activity</h3></th>
                        <th width="20%"><h3>Deadline</h3></th>
                        <th width="15%"><h3>Options</h3></th>
                    </tr>
                    <%
                        List<Activity> activities = (List<Activity>) request.getAttribute("activities");
                        if(activities != null) {
                            int count = 1;
                            for(Activity activity : activities) {
                    %>
                    <tr>
                        <td><h4 ><%= count %></h4></td>
                        <td><h4><%= activity.getaName() %></h4></td>
                        <td><h4><%= activity.getaDate() %></h4></td>
                        <td><a href="DelActivity?id=<%= activity.getId() %>"><button type="button" class="btn btn-primary">Done!</button></a>
                            <a href="#"><button type="button" class="btn btn-primary">Edit!</button></a>
                        </td>
                    </tr>
                    <%   count++;
                            }
                        }
                    %>
                </table>
                <br><br>
            </div>
            <div class="col-sm-4" id="new_activ">
                <h3 class="headers">New Activity</h3><br>
                <form method="post" action="AddActivity">
                    <div class="form-group">
                        <label for="name">What are you going to do? </label>
                        <input class="form-control" type="text" name="name" id="name"><br>
                    </div>
                    <div class="form-group">
                        <label for="date">Set the deadline... </label>
                        <input class="form-control" type="date" name="date" id="date"><br>
                    </div>
                    <button class="btn btn-info" type="submit">Add!</button>
                </form>
            </div>
        </div>
</main>
<footer>
    <a href="index.jsp"><button type="button" class="btn btn-default">Back</button></a><br>
</footer>
</div>
</body>
</html>