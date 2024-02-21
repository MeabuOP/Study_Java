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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import myPack.Student;

/**
 *
 * @author ASUS
 */
public class StudentServlet extends HttpServlet {

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
            out.println("<title>Servlet StudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ArrayList<Student> studentList = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String student_number_raw = (String) request.getParameter("student_number");
        int student_number = Integer.parseInt(student_number_raw);
        
        String[] button = request.getParameter("buttonAction").split("_");
        

        
        if (button[0].equals("generate")){
            studentList = new ArrayList<>();
            for (int i = 0;i<student_number;i++){
               Student s = new Student(i+1, generateRandomAlphabets(7), generateRandomBoolean(), generateRandomDate());
               studentList.add(s);
            }
        }
        else if (button[0].equals("add")){
            if (studentList == null) studentList = new ArrayList<>();
            int last_student_ID = 0;
            if (studentList.size() != 0){
                last_student_ID = studentList.get(studentList.size()-1).getID();
            }
            for (int i = 0; i< student_number ;i++){
               Student s = new Student(last_student_ID++ + 1, generateRandomAlphabets(7), generateRandomBoolean(), generateRandomDate());
               studentList.add(s);
            }
        }
                
        else {
            int button_value = Integer.parseInt(button[1]);
            if (button[0].equals("update")){
                Student s = studentList.get(button_value);
                s.setName(generateRandomAlphabets(7));
                s.setGender(generateRandomBoolean());
                s.setDob(generateRandomDate());
            }
            else if (button[0].equals("delete")){
                studentList.remove(button_value);
            }
        }
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("student.jsp").forward(request, response);
        
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
    
    private String generateRandomAlphabets(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // Generate a random number to choose between uppercase and lowercase
            int caseSelector = random.nextInt(2);

            // If caseSelector is 0, choose an uppercase letter (ASCII: 'A' to 'Z')
            // If caseSelector is 1, choose a lowercase letter (ASCII: 'a' to 'z')
            char randomAlphabet = (char) (caseSelector == 0 ?
                    random.nextInt(26) + 'A' :
                    random.nextInt(26) + 'a');

            stringBuilder.append(randomAlphabet);
        }

        return stringBuilder.toString();
    }
    
    private boolean generateRandomBoolean() {
        Random random = new Random();
        
        // Use nextBoolean() method to directly generate a random boolean value
        return random.nextBoolean();
    }
    
    public Date generateRandomDate() {
        Random random = new Random();

        // Generating a random year between 1900 and 2100
        int year = random.nextInt(201) + 1900;

        // Generating a random month between 1 and 12
        int month = random.nextInt(12) + 1;

        // Generating a random day between 1 and the maximum days of the month
        int day = random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;

        LocalDate localDate = LocalDate.of(year, month, day);

        // Converting LocalDate to Date
        return java.sql.Date.valueOf(localDate);
    }
}
