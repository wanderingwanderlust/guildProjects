package com.thesoftwareguild.interestcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InterestCalculatorServlet", urlPatterns = {"/InterestCalculatorServlet"})
public class InterestCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("entry.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));
        int compoundsPerYear;
        try {
            compoundsPerYear = Integer.parseInt(request.getParameter("compoundsPerYear"));
        } catch (Exception e) {
            compoundsPerYear = 1;
        }
        double principal = Double.parseDouble(request.getParameter("principal"));
        int years = Integer.parseInt(request.getParameter("years"));
        double pInterest = interestRate / compoundsPerYear;

        List<YearResult> listYearResults = runCalculations(interestRate, compoundsPerYear, principal, years, pInterest);
        request.setAttribute("listYearResults", listYearResults);

        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);
    }

    private List<YearResult> runCalculations(double interestRate, int compoundsPerYear, double principal, int years, double pInterest) {
        YearResult year;
        List<YearResult> listYears = new ArrayList<>();
        for (int i = 0; i < years; i++) {
            year = new YearResult(i, principal, pInterest, compoundsPerYear);
            listYears.add(year);
            principal = year.getEndOfYearBalance();
        }
        return listYears;
    }

    public class YearResult {

        private int currentYear;
        private double currentBalance;
        private double interestEarned;
        private double endOfYearBalance;

        public YearResult(int currentYear, double currentBalance, double pInterest, int compoundsPerYear) {
            this.currentYear = currentYear;
            this.currentBalance = currentBalance;
            this.interestEarned = currentBalance * Math.pow((1 + (pInterest / 100)), compoundsPerYear) - currentBalance;
            this.endOfYearBalance = currentBalance + interestEarned;
        }

        public int getCurrentYear() {
            return currentYear;
        }

        public void setCurrentYear(int currentYear) {
            this.currentYear = currentYear;
        }

        public double getCurrentBalance() {
            return currentBalance;
        }

        public void setCurrentBalance(double currentBalance) {
            this.currentBalance = currentBalance;
        }

        public double getInterestEarned() {
            return interestEarned;
        }

        public void setInterestEarned(double interestEarned) {
            this.interestEarned = interestEarned;
        }

        public double getEndOfYearBalance() {
            return endOfYearBalance;
        }

        public void setEndOfYearBalance(double endOfYearBalance) {
            this.endOfYearBalance = endOfYearBalance;
        }

        
    }

}
