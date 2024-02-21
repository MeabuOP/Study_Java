/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author ASUS
 */
public class EmojiServlet extends HttpServlet {

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
        String requestString = request.getParameter("message");
        requestString = replaceEmojis(requestString);
        requestString = requestString.replaceAll("<3", "&128151");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmojiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("            <form action=\"EmojiServlet\" method=\"get\" name=\"input\">\n" +
"                <p>Enter your message:</p>\n" +
"                <input type=\"text\" style=\"width: 500px;background-color: lightblue\" name=\"message\" placeholder=\"" + requestString +"\">\n" +
"                <br>\n" +
"                <button style=\"color: black;background-color: buttonface;margin-top: 20px\" type=\"submit\">Click Me</button>\n" +
"            </form>"  );
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String replaceEmojis(String message) {
        message = message.replaceAll(":]", "&#128527;");
        message = message.replaceAll(":-D", "&#128516;");
        message = message.replaceAll("<3", "&#129392;");
        message = message.replaceAll(":-O", "&#128559;");
        message = message.replaceAll(":coffee:", "&#9749;");
        message = message.replaceAll("-^^-", "&#129316;");
        return message;
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
