package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardParamVO;
import com.koreait.board2.model.BoardVO;

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
        int recordCnt = 5;
        BoardParamVO param = new BoardParamVO();
        param.setRecordCnt(recordCnt);
        req.setAttribute("maxPage", BoardDAO.selMaxPage(param));

        int page = MyUtils.getParameterInt(req, "page", 1);
        param.setPage(page);

        req.setAttribute("list", BoardDAO.selBoardList(param));
        //disForward는 항상 가장 아래
        MyUtils.disForward(req, res, "board/list");
    }
}

/*
내장객체 (set get) Attribute
                               jsp
pageContext(가장짧게 살아있음) 쏠 때 살아있고/ 응답완료시 죽음
**request                     요청시 살아있고/ 응답완료시 죽음
**session                     요청시 살아있고/
application(가장오래 살아있음,범용)
 */