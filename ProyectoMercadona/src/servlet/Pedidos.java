package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer.Form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xpath.internal.operations.And;

import db.MysqlConnect;

/**
 * Servlet implementation class Pedidos
 */
@WebServlet("/Pedidos")
public class Pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pedidos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		   MysqlConnect c = MysqlConnect.getDbCon();
			ResultSet rs = null;
		   
		  
	            
	             
	              String id=(String) request.getSession().getAttribute("id");
	            	 rs = c.query("Select * from pedido Where cliente_id="+ id +"and confirmado=0" );
	             
	              if(rs.next()){
	            	 
			    	  String fp= request.getParameter("fecha_pedido");
		                String conf= request.getParameter("confirmado");
		                String cid= request.getParameter("cliente_id");
		             
	              }
	          
	              else{
						response.sendRedirect("index.jsp");
					}
			   
	        try {
	        	
	            request.setAttribute("resultados", rs);
	           
	  		  
	           	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }       
		   
	    	
	          
	        // TODO Auto-generated catch block
            request.setAttribute("error", "Retrieving rows failed.");

	        
	        
	        request.getRequestDispatcher("jsp/listadopedidos.jsp").forward(request, response);
	    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
