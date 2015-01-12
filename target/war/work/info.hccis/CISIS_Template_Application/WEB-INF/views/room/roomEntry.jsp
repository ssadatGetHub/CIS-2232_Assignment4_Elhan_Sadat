<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <style>
        .datepicker{

        }
    </style>
    <script>
        $(function () {
            $(".datepicker").datepicker({minDate: 1}).val(new Date().asString()).trigger('change');
        });
        function ValidateDives() {

            if (document.getElementById("date").value !== "") {
                alert("error");
//                    document.getElementById("options").style.display = "hide";
            }
        }

    </script>
</head>
<form action="roomBook" method="post">
    <spring:nestedPath path="roomBook">
        <table>                
            <tr>
                <td>
                    <span>Choose Date: </span>
                    <form:input path="datepicker" id="datepicker" class="datepicker" />	  		
                </td>
            </tr>
            <tr><td><hr/></td></tr>
            <!--<div id="options" style="display: none;">-->
                <tr>
                    <td>
                        <select class = "selectTime" multiple = "multiple" size = "5" style="">
                            <option value="t1">9:00am - 10:30am</option>
                            <option value="t2">10:30am - 12:00pm</option>
                            <option value="t3">12:00pm - 1:00pm</option>
                            <option value="t4">1:00pm - 2:30pm</option>
                            <option value="t5">2:30pm - 4:00pm</option>
                        </select>
                        <select id = "selectRoom" multiple = "multiple" size = "5" style="">
                            <option value="r1">Room - 1</option>
                            <option value="r2">Room - 2</option>
                            <option value="r3">Room - 3</option>
                            <option value="r4">Room - 4</option>
                            <option value="r5">Room - 5</option>
                            <option value="r6">Room - 6</option>
                            <option value="r7">Room - 7</option>
                            <option value="r8">Room - 8</option>
                            <option value="r9">Room - 9</option>
                            <option value="r10">Room - 10</option>
                        </select>
                    </td>
                </tr>   
            <!--</div>-->
            <tr><td><hr/></td></tr>
           
            <tr><td><hr/></td></tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="book">
                </td>
            </tr>
        </table>
   </spring:nestedPath>
</form>
