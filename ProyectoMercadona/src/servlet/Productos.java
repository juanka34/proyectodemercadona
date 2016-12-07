package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MysqlConnect;

/**
* Servlet implementation class Productos
*/
@WebServlet("/Productos")
public class Productos extends HttpServlet {
    private static final long serialVersionUID = 1L;
      
   /**
    * @see HttpServlet#HttpServlet()
    */
   public Productos() {
       super();
       // TODO Auto-generated constructor stub
   }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        MysqlConnect c = MysqlConnect.getDbCon();
 
        
        try {
            ResultSet rs = c.query("Select * from producto");
            request.setAttribute("resultados", rs);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            request.setAttribute("error", "Retrieving rows failed.");
            e.printStackTrace();
        }
        
        
        
        
        request.getRequestDispatcher("jsp/listadoproductos.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}