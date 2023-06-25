/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SvUsuarios;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author lenin
 */
@WebServlet(name = "Usuarios", urlPatterns = {"/Usuarios"})
public class Usuarios extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre = request.getParameter("Nombre");
        String apellidoPaterno = request.getParameter("Apat");
        String apellidoMaterno = request.getParameter("Apmat");
        String correo = request.getParameter("Correo");
        String contraseña = request.getParameter("Password");
        
        int resultado = 0;
        
        String mensajeerror = "";
        
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
