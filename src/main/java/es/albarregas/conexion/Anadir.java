/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.conexion;

import es.albarregas.beans.Ave;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author portatil
 */
@WebServlet(name = "Anadir", urlPatterns = {"/Anadir"})
public class Anadir extends HttpServlet {
    
    DataSource dataSource;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection conexion = null;
        Statement query = null;
        ResultSet resultado = null;
        PreparedStatement pstmt = null;
        
        try {
            conexion = dataSource.getConnection();
            HttpSession sesion = request.getSession();
            query = conexion.createStatement();
            resultado = null;

            pstmt = conexion.prepareStatement("INSERT INTO aves(anilla, especie, lugar, fecha) VALUES(?, ?, ?, ?)");
            pstmt.setString(1, request.getParameter("Anilla"));
            pstmt.setString(2, request.getParameter("Especie"));
            pstmt.setString(3, request.getParameter("Lugar"));
            pstmt.setString(4, request.getParameter("Fecha"));
            resultado = pstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conexion != null) {
                try {
                    resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException e) {
                    
                }
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        request.getRequestDispatcher("JSP/Ejecutado.jsp").forward(request, response);

    }

    @Override
    public void init(ServletConfig config) {
        try {
            Context contextoInicial = new InitialContext();
            dataSource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/APool");
        } catch (NamingException ex) {
            Logger.getLogger(Anadir.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Se ha producido un error en la conexion con la base de datos");
            ex.printStackTrace();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
