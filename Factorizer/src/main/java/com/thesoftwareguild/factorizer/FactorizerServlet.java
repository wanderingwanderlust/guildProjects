package com.thesoftwareguild.factorizer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

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
            out.println("<title>Results</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lucky Sevens Results</h1>");
            out.println("<h1>Servlet FactorizerServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher rd = request.getRequestDispatcher("entry.jsp");
        rd.forward(request, response);
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
        int numToFactor = Integer.parseInt(request.getParameter("numToFactor"));
        FactorizerResult factorizerResult = runFactorizer(numToFactor);

        request.setAttribute("numToFactor", numToFactor);
        request.setAttribute("factors", factorizerResult.factors);
        request.setAttribute("counter", factorizerResult.counter);
        request.setAttribute("perfectNum", factorizerResult.perfectNum);
        request.setAttribute("primeNum", factorizerResult.primeNum);

        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);
    }

    private FactorizerResult runFactorizer(int numToFactor) {
        List<Integer> factors = new ArrayList<>();

        for (int i=1; i<numToFactor; i++) {
           if (numToFactor % i == 0) {
               factors.add(i);
           } 
        }

        FactorizerResult factorizerResult = new FactorizerResult(numToFactor, factors);
        return factorizerResult;
    }

    class FactorizerResult {
        
        int                  numToFactor;
        List<Integer>        factors;
        int                  counter;
        int                  sumFactors;
        boolean              perfectNum;
        boolean              primeNum;

        public FactorizerResult(int numToFactor, List<Integer> factors) { 
            this.numToFactor = numToFactor;
            this.factors     = factors;
            this.counter     = factors.size();
            this.sumFactors  = factors.stream().mapToInt(Integer::intValue).sum();
            this.perfectNum  = (sumFactors == numToFactor) ? true : false;
            this.primeNum    = (sumFactors == 1)           ? true : false;
        }

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
