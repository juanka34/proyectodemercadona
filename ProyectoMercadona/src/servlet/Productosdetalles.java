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
 * Servlet implementation class Productosdetalles
 */
@WebServlet("/Productosdetalles")
public class Productosdetalles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productosdetalles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
        MysqlConnect c = MysqlConnect.getDbCon();
        ResultSet rs=null;
       
        try {
        	String quer="Select * from producto  Where producto.id="+ request.getParameter("id")+"";
        	
            rs = c.query(quer);
            request.setAttribute("resultados", rs);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            request.setAttribute("error", "Retrieving rows failed.");
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("jsp/detalles.jsp").forward(request, response);
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
