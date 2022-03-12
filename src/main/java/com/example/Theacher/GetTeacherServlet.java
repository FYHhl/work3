package com.example.Theacher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/get",loadOnStartup = 1 )
public class GetTeacherServlet extends HttpServlet {
    PreparedStatement preparedStatement=null;
    Connection connection=null;
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            connection = DbUtil.getConnection();
            //第3步：创建运行SQL的语句对象(Statement)
            String sql="select * from t_teacher";
            List<Teacher> teacherList=new ArrayList<>();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Teacher teacher=new Teacher(id,name);
                teacherList.add(teacher);
            }
            req.getServletContext().setAttribute("teacherList",teacherList);
            resp.sendRedirect(req.getContextPath()+"/teacher.jsp");
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
