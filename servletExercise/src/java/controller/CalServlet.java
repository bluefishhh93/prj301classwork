/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author xuant
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/cal"})
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
        try ( PrintWriter out = response.getWriter()) {
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
        String firstNumRaw = request.getParameter("firstNum");
        String secondNumRaw = request.getParameter("secondNum");
        String op = request.getParameter("operator");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        double firstNum, secondNum;
        try {
            firstNum = Double.parseDouble(firstNumRaw);
            secondNum = Double.parseDouble(secondNumRaw);
            String ms = calculateTwoNumber(firstNum, secondNum, op);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalServlet</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/calculator.css\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"cal\" method=\"get\">\n" +
"                <label>First:</label> <input type=\"text\" name=\"firstNum\" value="+firstNumRaw+"><br>\n" +
"                <label>Second:</label> <input type=\"text\" name=\"secondNum\" value="+secondNumRaw+"><br>\n" +
"                <label>Operator:</label> <select name=\"operator\" id=\"operator\">\n" +
"                    <option value=\"+\">+</option>\n" +
"                    <option value=\"-\">-</option>\n" +
"                    <option value=\"*\">*</option>\n" +
"                    <option value=\"/\">/</option>\n" +
"                </select><br>\n" +
"                <input type=\"submit\" value=\"compute\"><br>\n" +
"                <label>Result:</label> <input type=\"text\" name=\"result\" value="+ms+"><br>\n" +
"            </form>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
        }

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


    }

    private String calculateTwoNumber(double firstNum, double secondNum, String op) {
        String ms = "";
        switch (op) {
            case "+":
                ms = "" + (firstNum + secondNum);
                break;
            case "-":
                ms = "" + (firstNum - secondNum);
                break;
            case "*":
                ms = "" + (firstNum * secondNum);
                break;
            case "/":
                if(secondNum == 0) break;
                ms = "" + (firstNum / secondNum);
                break;
        }
        return ms;
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
