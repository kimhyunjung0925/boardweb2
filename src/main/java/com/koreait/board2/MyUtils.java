package com.koreait.board2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defVal;
    }

    public static int getParameterInt(HttpServletRequest req, String key){
        String strVal = req.getParameter(key);
        int intVal = parseStringToInt(strVal);
        return intVal;
        //한줄로 return parseStringToInt(req.getParameter(key));
    }
}
