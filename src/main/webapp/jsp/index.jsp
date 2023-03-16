<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>Lesson-18</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${mode == 'PARCTICIPANT_VIEW'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Level</th>
                    <th>PrimarySkill</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <tbody>
                <c:forEach var="participant" items="${participants}">
                    <tr>
                        <th>${participant.id}</th>
                        <th>${participant.name}</th>
                        <th>${participant.email}</th>
                        <th>${participant.level}</th>
                        <th>${participant.primarySkill}</th>
                        <th><a href="update?id=${participant.id}">Edit</a></th>
                        <th><a href="delete?id=${participant.id}">Delete</a></th>
                    </tr>
                </c:forEach>
                </tbody>
                </thead>
            </table>
        </c:when>
        <c:when test="${mode == 'PARCTICIPANT_EDIT' || mode == 'PARCTICIPANT_CREATE'}">
            <form action="save" method="POST">
                <div class="form-group">
                    <label for="name">Name</label> <input type="text"
                                                          class="form-control" id="name" name="name"
                                                          value="${participant.name}">
                </div>

                <div class="form-group">
                    <label for="email">Email</label> <input type="text"
                                                            class="form-control" id="email" name="email"
                                                            value="${participant.email}">
                </div>

                <div class="form-group">
                    <label for="level">Level [L1,L2,L3,L4,L5]</label> <input type="text"
                                                                             class="form-control" id="level" name="level"
                                                                             value="${participant.level}">
                </div>

                <div class="form-group">
                    <label for="primarySkill">Primary Skill</label> <input type="text"
                                                                           class="form-control" id="primarySkill" name="primarySkill"
                                                                           value="${participant.primarySkill}">
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </c:when>
    </c:choose>
</div>

</body>
</html>