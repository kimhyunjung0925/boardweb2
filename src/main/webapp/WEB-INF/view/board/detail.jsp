<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page import="com.koreait.board2.model.BoardParamVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo = (BoardVO) request.getAttribute("data");
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${requestScope.data.title}</title>
</head>
<body>
    <h1>글 디테일</h1>
    <div>
        <a href="javascript:history.back()">리스트로 돌아가기</a>
    </div>
    <div>
        <a href="/board/prev"> <input type="button" value="이전글"></a>
        <a href="/board/next"> <input type="button" value="다음글"></a>

    </div>

    <div>NO : ${requestScope.data.iboard}</div>
    <div>제목 : ${requestScope.data.title}</div>
    <div>--- 내용--- </div>
    <div>${requestScope.data.ctnt}</div>
    <hr>
    <div>작성자 : ${requestScope.data.writerNm}</div>
    <div>작성일시 : (${requestScope.data.rdt})</div>
    <div>
        <%if(loginUser != null && vo.getWriter() == loginUser.getIuser()) { %>
        <a href="/board/del?pk=${requestScope.data.iboard}"> <input type="button" value="삭제"></a>
        <a href="/board/mod?pk=${requestScope.data.iboard}"> <input type="button" value="수정"></a>
        <% } %>
    </div>

    <div>${requestScope.err}</div>


</body>
</html>
