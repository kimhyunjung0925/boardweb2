package com.koreait.board2;

import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils extends HttpServlet {
    public static void disForward (HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path = "/WEB-INF/view/" + jsp + ".jsp";
        req.getRequestDispatcher(path).forward(req,res);
    }

    //에러터지면 0을 받겠다
    public static int parseStringToInt(String str){
        return parseStringToInt(str,0);
    }

    public static int parseStringToInt(String str, int defVal){
        try{
            return Integer.parseInt(str);
        } catch (Exception e) {}
        return defVal;
    }

    public static int getParameterInt(HttpServletRequest req, String key, int defVal) {
        return parseStringToInt(req.getParameter(key), defVal);
    }

    public static int getParameterInt(HttpServletRequest req, String key) {
        /*
        String strVal = req.getParameter(key);
        int intVal = parseStringToInt(strVal);
        return intVal;
        */
        return parseStringToInt(req.getParameter(key));
    }

    //로그인 했으면 return pk값, 로그아웃 상태면 return 0
    public static int getLoginUserPk(HttpServletRequest req){
        UserVO loginUser = getLoginUser(req);
        return  loginUser == null ? 0 : loginUser.getIuser();
    }

    //로그인 했으면 true 로그아웃했으면 false리턴
    public static boolean isLogin(HttpServletRequest req){
        return getLoginUser(req) != null;
    }

    public static boolean isLogout(HttpServletRequest req){
        return getLoginUser(req) == null;
    }

    //로그인이 안 되어 있으면 return null; 되어 있으면 UserVO객체 주소값
    public static UserVO getLoginUser(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (UserVO) session.getAttribute("loginUser");
    }
}
