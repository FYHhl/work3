package com.example.Theacher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = "/reo",loadOnStartup = 1)
public class RemoveServlet extends HttpServlet {
    PreparedStatement preparedStatement=null;
    Connection connection=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader=req.getReader();
        StringBuilder sb=new StringBuilder();
        String s = reader.readLine();
        System.out.println(s);
        JSONObject jsonObject= JSON.parseObject(s);
        int id= Integer.parseInt(jsonObject.getString("id"));
        try{
            connection = DbUtil.getConnection();
            //第3步：创建运行SQL的语句对象(Statement)
            System.out.println(id);
            String sql="delete from t_teacher where id=id";
            preparedStatement = connection.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            System.out.println("影响了"+i+"条");

            resp.sendRedirect(req.getContextPath()+"/get");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭结果集
            try {
                //第6步：释放资源
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
