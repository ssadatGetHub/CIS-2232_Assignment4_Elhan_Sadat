<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td colspan="5">
                    <b>${message}</b>
                </td>
            </tr>
            <tr>
                <td>Booking ID</td>
                <td>User Name</td>
                <td>Selected Date</td>
                <td>Selected Room</td>
                <td>Selected Time</td>
                <td>Description</td>
            </tr>
            <c:forEach var="thisEntry" items="${room}"
                       varStatus="loopCounter">

                <tr>
                    <td><c:out value="${thisEntry.bookingId}" /></td>
                    <td><c:out value="${thisEntry.userId}" /></td>
                    <td><c:out value="${thisEntry.datepicker}" /></td>
                    <td><c:out value="${thisEntry.selectRoom}" /></td>
                    <td><c:out value="${thisEntry.selectTime}" /></td>
                    <td><c:out value="${thisEntry.description}" /></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</spring:nestedPath>
