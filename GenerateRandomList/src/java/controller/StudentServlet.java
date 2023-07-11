/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import model.Student;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author xuant
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/studentservlet"})
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
        try ( PrintWriter out = response.getWriter()) {
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
        String numRaw = request.getParameter("num");
        int num;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int id;
            String name;
            boolean gender;
            Date yob;
            num = Integer.parseInt(numRaw);
            int minLength = 4; // Minimum length of the random string
            int maxLength = 6; // Maximum length of the random string
            List<Student> listOfStudent = new ArrayList<>(); //list of student
            Random r = new Random(); // to randomly create gender

            //add new student to the list
            for (int i = 0; i < num; i++) {
                id = i + 1;
                gender = r.nextBoolean();
                name = RandomStringUtils.randomAlphabetic(5 + new Random().nextInt(6));
                yob = format.parse(generateRandomDate());
                listOfStudent.add(new Student(id, name, gender, yob));
            }
            StudentDao std = new StudentDao();
            std.list = (ArrayList<Student>) listOfStudent;
            
//            Send the listOfStudent to the JSP page
//            request.setAttribute("data", listOfStudent);
              response.sendRedirect("page");
              
//              request.setAttribute("myList", list);
//              RequestDispatcher rd = request.getRequestDispatcher("/paging");
//              rd.forward(request, response);  ben kia thi ArrayList<String> list = (ArrayList<String>) request.getAttribute("myList");
        } catch (Exception e) {
        }

    }

    private String generateRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1934, 2014);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return  gc.get(gc.YEAR) + "-" + gc.get(gc.DAY_OF_MONTH) + "-" + (gc.get(gc.MONTH) + 1) ;

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
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
