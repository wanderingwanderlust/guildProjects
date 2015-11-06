/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.tipcalculator;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "TipCalculatorServlet", urlPatterns = {"/TipCalculatorServlet"})
public class TipCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("entry.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Double totalBill = Double.parseDouble(request.getParameter("totalBill"));
        Double tipPercent = Double.parseDouble(request.getParameter("tipPercent"));
        Double tipCalc = tipPercent /100;
        Double doTip = tipCalc * totalBill;
        Double total = doTip + totalBill;
        
        request.setAttribute("totalBill", totalBill);
        request.setAttribute("tipPercent", tipPercent);
        request.setAttribute("tipCalc", doTip);
        request.setAttribute("total", total);
        
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);
        
    
    
    
    
    
    
    
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
