import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Registration() {
        // Default constructor
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String attendeesno = request.getParameter("attendeesno");
        Connection con = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/realdb", "1", "1");

            if (con != null && !con.isClosed()) {
                s = con.createStatement();
                int result = s.executeUpdate("INSERT INTO event VALUES('" + name + "','" + phone + "','" + email + "','" + attendeesno + "')");
                out.println("<html><head><title>REGISTRATION SUCCESS</title></head><body bgcolor='wheat'><center><h1>");
                if (result != 0) {
                    out.println(name + " you are successfully registered.");
                } else {
                    out.println(name + " you are unable to register, please fill the form correctly.");
                }
                out.println("</h1></center></body></html>");
            } else {
                out.println("<html><body><h1>Database connection failed!</h1></body></html>");
            }
        } catch (SQLException e) {
            out.println("<html><body><h1>SQL Error: " + e.getMessage() + "</h1></body></html>");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            out.println("<html><body><h1>Driver not found!</h1></body></html>");
            
            e.printStackTrace();
        } catch (Exception e) {
            out.println("<html><body><h1>Error: " + e.getMessage() + "</h1></body></html>");
            e.printStackTrace();
        } finally {
            try {
                if (s != null) s.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
