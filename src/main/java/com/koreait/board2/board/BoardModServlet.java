package com.koreait.board2.board;

import com.koreait.board2.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req,"pk");

        BoardVO param = new BoardVO();
        param.setIboard(iboard);

        BoardVO vo = BoardDAO.selBoard(param);
        req.setAttribute("data", vo);

        MyUtils.disForward(req,res,"board/mod");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        int iboard = MyUtils.getParameterInt(req,"pk");

        BoardVO param = new BoardVO();
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setIboard(iboard);

        int result = BoardDAO.modBoard(param);
        switch (result) {
            case 1:
                res.sendRedirect("/board/detail?pk=" + iboard);
                break;
        }


    }
}
