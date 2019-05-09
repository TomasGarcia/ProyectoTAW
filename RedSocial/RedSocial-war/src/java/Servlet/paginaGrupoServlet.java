/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Grupo;
import Entities.Post;
import ejb.GrupoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "paginaGrupoServlet", urlPatterns = {"/paginaGrupoServlet"})
public class paginaGrupoServlet extends HttpServlet {

    @EJB private GrupoFacade grupoFacade;
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
     
        HttpSession session = request.getSession();
        String strID = request.getParameter("id");
        Integer id;
        if(strID != null){
           id = new Integer(strID);
        }else{
            id = (Integer)session.getAttribute("idGrupo");
        }
        
        Grupo grupo = this.grupoFacade.find(id);
//        System.out.println(grupo.getNombre());
        
        session.setAttribute("idGrupo", id);
        session.setAttribute("grupo", grupo);
        List<Grupo> grupos = this.grupoFacade.findAll();
        request.setAttribute("GrupoList", grupos);
        
        List<Post> posts=grupo.getPostList();
        request.setAttribute("PostListGrupo", posts);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/paginagrupo.jsp");
        rd.forward(request, response); 
        //response.sendRedirect("paginagrupo.jsp");
        
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
