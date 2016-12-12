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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs = null;
		
		if (request.getParameter("registro") != null) {
			String user= request.getParameter("user");
			String pwd= request.getParameter("password");
			String nombre= request.getParameter("nombre");
			String apellido1= request.getParameter("apellido1");
			String apellido2= request.getParameter("apellido2");
			String telefono= request.getParameter("telefono");
			String direccion= request.getParameter("direccion");
			String email= request.getParameter("email");
			
			try {
				c.insert("INSERT INTO cliente (usuario,password,nombre,apellido1,apellido2,telefono,direccion,email) VALUES "
						+ "('"+user+"','"+pwd +"','"+nombre+"','"+apellido1+"','"+apellido2+"',"+telefono+",'"+direccion+"','"+email+"')");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			request.setAttribute("nombre_user", user);
			
			request.getRequestDispatcher("jsp/menu.jsp").forward(request, response);
					
		} else if (request.getParameter("login") != null) {
			System.out.print("hey");
			
			String user= request.getParameter("user");
			String pwd= request.getParameter("password");
			
			try {
				rs = c.query("select id,usuario,password from cliente where usuario='"+user+"' and password='"+pwd+"';");
				if(rs.next()){
					request.getSession().setAttribute("usuario",user);
                    request.getSession().setAttribute("id", rs.getString(1));
					request.setAttribute("nombre_user", user);
					request.getRequestDispatcher("jsp/menu.jsp").forward(request,response);
				}else{
					response.sendRedirect("index.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}