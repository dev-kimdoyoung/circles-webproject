<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JSP 캐시 사용 안함 !-->
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",0);
    if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>SPLUG</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="../../webapp/assets/css/manage-member.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


</head>

<br>

    <nav>
        <button type="button" class="btn btn-light" id="manageMember">회원 관리</button>
    </nav>

<br><br>
<h3 class="text-center text-info" id="notice">회원 관리</h3>
<br>

<div class="container">
    <table class="table table-hover table-condensed">
        <thead>
        <tr id="tableHead">
            <th>No</th>
            <th>이름</th>
            <th>학과</th>
            <th>학년</th>
            <th>학번</th>
            <th>주소</th>
            <th>가입 날짜</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="row" items="${list}">
            <tr>
                <td><c:out value="${ row.user_id }"/></td>
                <td><c:out value="${ row.username }"/></td>
                <td><c:out value="${ row.major }"/></td>
                <td><c:out value="${ row.degree }"/></td>
                <td><c:out value="${ row.student_id }"/></td>
                <td><c:out value="${ row.address }"/></td>
                <td><c:out value="${ row.created_Date }"/></td>
                <td><input type="checkbox" class="checkBox" name="isChecked" data-checked="${row.user_id}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr/>

    <a class="btn btn-light float-right selectDelete_btn" style="margin: 20px 3px">삭제</a>

    <script>
        $(".selectDelete_btn").click(function(){
            var confirm_val = confirm("정말 삭제하시겠습니까?");

            if(confirm_val) {
                var checkArr = new Array();

                $("input[class='checkBox']:checked").each(function(){
                    checkArr.push($(this).attr("data-checked"));
                });

                $.ajax({
                    url : "/delete",
                    type : "post",
                    data : { checkBox : checkArr },
                    success : function () {
                        location.reload();
                    }
                });
            }
        });
    </script>

    <a class="btn btn-light float-right" style="margin: 20px 3px" data-toggle="modal" data-target="#myModal">추가</a>

    <ul class="pagination justify-content-center" style="margin:20px 0">
        <li class="page-item"><a class="page-link" href="#"><</a></li>
        <li class="page-item"><a href="#" class="page-link">1</a></li>
        <li class="page-item"><a href="#" class="page-link">2</a></li>
        <li class="page-item"><a href="#" class="page-link">3</a></li>
        <li class="page-item"><a href="#" class="page-link">4</a></li>
        <li class="page-item"><a href="#" class="page-link">5</a></li>
        <li class="page-item"><a href="#" class="page-link">></a></li>
    </ul>

</div>

</body>

<!-- The Modal -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h3 class="modal-title">추가할 학생 정보</h3>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/add">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <p class="web-field">이름 <input class="text-input-dialog" type="text" name="username"></p>
                <p class="text-area">학과 <input class="text-input" type="text" name="dept"></p>
                <p class="text-field">학년 <input type="text" name="degree"></p>
                <p class="text-area">핸드폰번호 <input class="text-input" type="text" name="phone"></p>
                <p>학번 <input type="text" name="student_id"></p>
                <p>주소 <input type="text" name="address"></p>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">추가</button>
                </form>
                <button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
            </div>

        </div>
    </div>
</div>
</html>
