package com.koreait.board2.board;

import com.koreait.board2.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BoardVO> list = BoardDAO.selBoardList();
        req.setAttribute("data",list);
        //disForward는 항상 가장 아래에 두세요.
        MyUtils.disForward(req, res,"board/list");
    }

}

/*
내장객체 (set get) Attribuet
                               jsp
pageContext(가장짧게 살아있음) 쏠 때 살아있고/ 응답완료시 죽음
**request                     요청시 살아있고/ 응답완료시 죽음
**session                     요청시 살아있고/
application(가장오래 살아있음,범용)
 */