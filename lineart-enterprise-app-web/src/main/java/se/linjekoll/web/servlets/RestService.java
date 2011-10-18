/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import se.linjekoll.persistency.facades.PositionFacade;
import se.linjekoll.persistency.facades.StopFacade;

/**
 *
 * @author jesper
 */
@WebServlet(name = "RestService", urlPatterns = {"/rest/*"})
public class RestService extends HttpServlet {
    @EJB
    private StopFacade p;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper om = new ObjectMapper();
        try {
            // String action = parseRequest(request.getPathInfo())
            // out.println(processRequest(request.getPathInfo()));
            out.println(om.writeValueAsString(p.getStops(4)));
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String processRequest(String pathInfo) {
        ArrayList<String> validActions = new ArrayList<String>();
        Pattern p = Pattern.compile("/([a-z]+)/(\\d+)(/([a-z]+))?");
        Matcher m = p.matcher(pathInfo);
        Deque<String> matches = new ArrayDeque<String>();
        while (m.find()) {
            matches.push(m.group());
        }
        
        String action = matches.pop();
        
        return "";
    }
}
