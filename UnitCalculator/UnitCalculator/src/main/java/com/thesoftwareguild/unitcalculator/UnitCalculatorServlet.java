/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.unitcalculator;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UnitCalculatorServlet", urlPatterns = {"/UnitCalculatorServlet"})
public class UnitCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("entry.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String choice = request.getParameter("firstChoice");
        Double userValue = Double.parseDouble(request.getParameter("userValue"));

        Double result = userValue;

        if (choice.equals("temp")) {

            String temp1 = request.getParameter("temp1");
            String temp2 = request.getParameter("temp2");
            
            
            
            if (temp1.equals(temp2)) {
                result = userValue;
            } else if (temp1.equals("faren") && temp2.equals("cel")) {
                result = (userValue - 32) * (5.0 / 9.0);

            } else if (temp1.equals("cel") && temp2.equals("faren")) {
                result = (userValue * 9.0 / 5.0) + 32;
            }

        } else if (choice.equals("weight")) {
            String weight1 = request.getParameter("weight1");
            String weight2 = request.getParameter("weight2");

            if (weight1.equals(weight2)) {
                result = userValue;
            } else if (weight1.equals("lbs") && weight2.equals("kg")) {
                result = (userValue * 0.45359237);

            } else if (weight1.equals("kg") && weight2.equals("lbs")) {
                result = (userValue / 0.45359237);
            }

        } else if (choice.equals("currency")) {
            String currency1 = request.getParameter("currency1");
            String currency2 = request.getParameter("currency2");

            if (currency1.equals(currency2)) {
                result = userValue;
            } else if (currency1.equals("usd") && currency2.equals("cny")) {
                result = (userValue * 6.36);

            } else if (currency1.equals("cny") && currency2.equals("usd")) {
                result = (userValue / 6.36);
            }

        } else if (choice.equals("length")) {
            String length1 = request.getParameter("length1");
            String length2 = request.getParameter("length2");

            if (length1.equals(length2)) {
                result = userValue;
            } else if (length1.equals("feet") && length2.equals("meter")) {
                result = (userValue / 3.2808);

            } else if (length1.equals("meter") && length2.equals("feet")) {
                result = (userValue * 3.20808);
            }

        }

        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);
    }

}
