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
import java.util.List;
import model.Student;

/**
 *
 * @author xuant
 */
@WebServlet(name = "ChangeInformation", urlPatterns = {"/change"})
public class ChangeInformation extends HttpServlet {

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
            out.println("<title>Servlet ChangeInformation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeInformation at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if (action != null) {
            StudentDao std = new StudentDao();
            ArrayList<Student> listOfStudent = std.list;
            if (action.equals("update")) {
                // Handle update operation

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                //get values from the row form update
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String gender_raw = (String) request.getParameter("gender");
//                System.out.println(gender_raw);
                String dob_raw = request.getParameter("dob");
                
                //set gender for student object
//                boolean gender = (gender_raw != null && gender_raw.equals("male"));

                // Perform the update operation using the retrieved values

                for (Student student : listOfStudent) {
                    if (student.getId() == id) {
                        student.setName(name);
                        if ((student.isGender() && gender_raw == null)) {
                            student.setGender(false);
                        }else if((!student.isGender() && gender_raw != null)){
                            student.setGender(true);
                        }
                        student.setDob(dob_raw);
                        // Update other properties as needed
                        break;
                    }
                }
            } else if (action.equals("delete")) {
                // Handle delete operation
                int id = Integer.parseInt(request.getParameter("id"));
                // Perform the delete operation using the retrieved ID
                for (Student student : listOfStudent) {
                    if (student.getId() == id) {
                        listOfStudent.remove(student);
                        break;
                    }
                }
            }
        }
        response.sendRedirect("page");
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
