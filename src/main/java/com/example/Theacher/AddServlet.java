package com.example.Theacher;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    PreparedStatement preparedStatement=null;
    Connection connection=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        Teacher teacher=new Teacher(name);
        try{
            connection = DbUtil.getConnection();
            String sql="insert into t_teacher (name)values (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,teacher.getName());
            int i = preparedStatement.executeUpdate();
            System.out.println("影响了"+i+"条");
//            req.getRequestDispatcher("/get").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/get");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
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
