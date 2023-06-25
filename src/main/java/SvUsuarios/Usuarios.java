/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SvUsuarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;
import java.sql.DriverManager;

/**
 *
 * @author lenin
 */
@WebServlet(name = "Usuarios", urlPatterns = {"/Usuarios"})
public class Usuarios extends HttpServlet {

    //variables globales
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor
    public void init(ServletConfig cfg) throws ServletException{
    
        //como se va a conectar a la bd
        String url = "jdbc:mysql:3306//localhost/taquitos";
                      //tipodedriver:gestorbd:puerto//IP/nombrebd
                      
        String userName = "root";
        String password = "L3usM4fi3r-";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            /*
            Aveces el tipo de driver ya tiene incluido el puerto de comunicación, es por ello
            que manda un error de conexción, para resolver este error simplemente hacemos lo siguiente:
            url = jdbc:mysql://localhost/taquitos
            */
            
            con = DriverManager.getConnection(url, url, password);
            set = con.createStatement();
            
            System.out.println("Conexión exitosa");
                    
        }catch(Exception e){
        
            System.out.println("Conexión no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
        }
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ip, ipr;
        int edad,puerto,puertor;
        
        String nombre = request.getParameter("Nombre");
        String apellidoPaterno = request.getParameter("Apat");
        String apellidoMaterno = request.getParameter("Apmat");
        String correo = request.getParameter("Correo");
        String contraseña = request.getParameter("Password");
        
        ip = request.getLocalAddr();
        puerto = request.getLocalPort();

        ipr = request.getRemoteAddr();
        puertor = request.getRemotePort();
        
        
        
        
        try ( PrintWriter out = response.getWriter()) {
        
            System.out.println(nombre);
            System.out.println(apellidoPaterno);
            System.out.println(apellidoMaterno);
            System.out.println(correo);
            System.out.println(contraseña);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Usuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Usuarios at " + request.getContextPath() + "</h1>");
            out.println("<h2>Nombre: "+nombre+"</h2>");
            out.println("<h2>Apellido Paterno: "+apellidoPaterno+"</h2>");
            out.println("<h2>Apellido Materno: "+apellidoMaterno+"</h2>");
            out.println("<h2>Correo: "+correo+"</h2>");
            out.println("<h2>Contraseña: "+contraseña+"</h2>");
            out.println("<button onclick=\"window.location='./index.html'\">Inicio</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </edtor-fold>

}
