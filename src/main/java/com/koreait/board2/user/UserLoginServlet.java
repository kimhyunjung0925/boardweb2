package com.koreait.board2.user;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.UserVO;
import org.apache.catalina.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    //로그인창 띄우는 담당
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/login");
    }

    //로그인 처리 담당
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserVO param = new UserVO();
        param.setUid(uid);
        param.setUpw(upw);

        // 0:로그인실패, 1:로그인성공, 2:아이디없음, 3:비번틀림
        int result = UserDAO.login(param);

        if(result==1){
            //세션 로그인 처리
            param.setUpw(null);
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", param);
            //Upw null로 바뀌고 param에 iuser nm uid 담겨있음

            res.sendRedirect("/board/list");
            return; // 중요!!!! 빠지면 에러터짐 doGet도 같이 실행됨, return 안쓰려면 아래내용 else로 다 넣어야함
        }

        String err = null;
        switch (result) {
            case 0:
                err = "로그인에 실패하였습니다";
                break;
            case 2:
                err = "아이디를 확인해주세요";
                break;
            case 3:
                err = "비밀번호를 확인해주세요";
                break;
        }
        req.setAttribute("err", err);
        doGet(req, res); //로그인 페이지로 이동
    }
}
