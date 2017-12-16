<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Activity, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ToDo</title>
    <style>
        #main_table {
            width: 70%;
            text-align: center;
        }
        .no_col {
            width: 10%;
        }
        .fst_col {
            width: 55%;
        }
        .snd_col {
            width: 20%;
        }
        .trd_col {
            width: 15%;
        }
    </style>
</head>
<body>

<main>
    <h1>Let's do it!</h1>
    <br><br>
    <section id="main_list">
            <table id="main_table">
                <tr>
                    <th class="no_col"><h3>No.</h3></th>
                    <th class="fst_col"><h3>Activity</h3></th>
                    <th class="snd_col"><h3>Deadline</h3></th>
                    <th class="trd_col"><h3>Done?</h3></th>
                </tr>
                <%
                    List<Activity> activities = (List<Activity>) request.getAttribute("activities");
                    if(activities != null) {
                        int count = 1;
                        for(Activity activity : activities) {
                %>
                <tr >
                    <td class="no_col" ><h5 ><%= count %></h5 ></td >
                    <td class="fst_col" ><h5><%= activity.getaName() %></h5></td >
                    <td class="snd_col" ><h5><%= activity.getaDate() %></h5></td >
                    <td class="trd_col" ><a href="DelActivity?id=<%= activity.getId() %>"><button>Done!</button></a></td >
                </tr >
                <%   count++;
                        }
                     }
                %>
            </table>
        <br><br>
    </section>
    <section id="new_activ">
        <form method="post" action="AddActivity">
            <h2>New Activity:</h2><br>
            What are you going to do: <input type="text" name="name"><br>
            Set the deadline: <input type="date" name="date"><br>
            <input type="submit" value="Add!">
        </form>
    </section>
</main>
<footer>
    <a href="index.jsp"><button type="button">Back</button></a>
</footer>
</body>
</html>
