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
public class CalServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String num1String = request.getParameter("first");
        String num2String = request.getParameter("second");
        double num1 = 0, num2 = 0;
        try {
            num1 = Double.parseDouble(num1String);
            num2 = Double.parseDouble(num2String);
        } catch (NumberFormatException e) {

        }

        String operator = request.getParameter("operator");
        double result = 0;
        if (operator.equals("+")) {
            result = num1 + num2;
        }
        if (operator.equals("-")) {
            result = num1 - num2;
        }
        if (operator.equals("*")) {
            result = num1 * num2;
        }
        if (operator.equals("/")) {
                result = num1 / num2;
        }

        out.println("    <head>\n"
                + "        <title>Calculator</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <form name =\"input\" action=\"CalServlet\" method =\"get\">\n"
                + "            <table>\n"
                + "                <tr>\n"
                + "                    <td>First: </td><td><input name =\"first\"/></td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Second: </td><td><input name =\"second\"/></td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Operator:</td>\n"
                + "                    <td>\n"
                + "                        <select name=\"operator\">\n"
                + "                            <option value=\"+\">+</option>\n"
                + "                            <option value=\"-\">-</option>\n"
                + "                            <option value=\"x\">*</option>\n"
                + "                            <option value=\"/\">/</option>\n"
                + "                        </select>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td></td><td><input type =\"submit\" value =\"Compute\"/></td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Result : </td><td><input name =\"result\" placeholder=" + result +"></td>\n"
                + "                </tr>\n"
                + "\n"
                + "            </table>\n"
                + "    </body>");
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
