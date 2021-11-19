<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("err");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <%if(err != null) {%>
    <div><%=err%></div>
    <% } %>
    <div>
        <form action="/board/mod?pk=${requestScope.data.iboard}" method="post">
            <div>NO : ${requestScope.data.iboard} </div>
            <div> 제목 : <input type="text" name="title" value="${requestScope.data.title}" placeholder="제목"></div>
            <div>--- 내용--- </div>
            <div><textarea name="ctnt" placeholder="내용">${requestScope.data.ctnt}</textarea> </div>
            <div>작성자 : ${requestScope.data.writer}</div>
            <div>작성일시 : ${requestScope.data.rdt}</div>
            <div>
                <input type="submit" value="수정">
                <input type="reset" value="초기화">
            </div>
        </form>
    </div>
</body>
</html>
