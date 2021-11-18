<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form action="/board/mod" method="post" id="frm">
        <div>NO : ${requestScope.data.iboard}</div>
        <div> 제목 : <input type="text" name="title" value="${requestScope.data.title}" placeholder="제목"></div>
        <div>--- 내용--- </div>
        <div><textarea name="ctnt" placeholder="내용">${requestScope.data.ctnt}</textarea> </div>
        <div>작성자 : ${requestScope.data.writer}</div>
        <div>작성일시 : ${requestScope.data.rdt}</div>
        <div>수정일시 :${requestScope.data.mdt}</div>
        <div>
            <input type="submit" value="저장">
        </div>
    </form>
</body>
</html>
