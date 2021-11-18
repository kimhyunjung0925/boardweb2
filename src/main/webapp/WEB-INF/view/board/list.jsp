<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.koreait.board2.board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>
    <style>
        table,td,th {
            border-collapse: collapse;
            border: 1px solid #000;
            text-align: center;
        }
    </style>
</head>
<body>
    <% if(loginUser != null) {%>
    <div>
        <a href="/board/write"><input type="button" value="글쓰기"></a>
        <%=loginUser.getNm()%>님 환영합니다. <a href="/user/logout">로그아웃</a>
    </div>
    <% } else { %>
    <a href="/user/login">로그인</a>
    <% } %>
    <h1>글 목록</h1>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일시</th>
            <th>글쓴이</th>
        </tr>

        <% for(BoardVO vo : list) {%>
            <tr>
                <td><%=vo.getIboard()%></td>
                <td>
                    <a href="/board/detail?pk=<%=vo.getIboard()%>"><%=vo.getTitle()%></a>
                </td>
                <td><%=vo.getRdt()%></td>
                <td><%=vo.getWriterNm()%></td>
            </tr>
        <%}%>

    </table>
</body>
</html>
