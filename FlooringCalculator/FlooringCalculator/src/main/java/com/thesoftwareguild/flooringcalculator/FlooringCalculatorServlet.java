/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringcalculator;

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
@WebServlet(name = "FlooringCalculatorServlet", urlPatterns = {"/FlooringCalculatorServlet"})
public class FlooringCalculatorServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("entry.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       double length = Double.parseDouble(request.getParameter("length"));
       double width = Double.parseDouble(request.getParameter("width"));
       double cost = Double.parseDouble(request.getParameter("cost"));
       
       double materialCost =length *width* cost;
       double sqFeet = length * width;
       
       
       double billableChunks = (int)((sqFeet / 20)*4);
       double chunkPayRate = 86.0 / 4;
       double laborCost = billableChunks * chunkPayRate;
 
      
               
       double totalCost = materialCost + laborCost;    
       
       request.setAttribute("length", length);
       request.setAttribute("width", width);
       request.setAttribute("materialCost", materialCost);
       request.setAttribute("laborCost", laborCost);
       request.setAttribute("totalCost", totalCost);
       
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
