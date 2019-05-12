/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.servlet;

import Entities.Grupo;
import Entities.Usuario;
import ejb.GrupoFacade;
import ejb.UsuarioFacade;
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
 * @author Jose
 */
@WebServlet(name = "integrantesServlet", urlPatterns = {"/integrantesServlet"})
public class IntegrantesServlet extends HttpServlet {
    
    @EJB private GrupoFacade grupoFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       String strId;
       HttpSession session = request.getSession();
       strId = request.getParameter("id");
       Integer id;
       if(strId != null){
           id = new Integer(strId);
       }else{
           id = (Integer) session.getAttribute("idGrupo");
       }
       System.out.println(id);
       Grupo grupo = this.grupoFacade.find(id);

       session.setAttribute("idGrupo", id);
       request.setAttribute("grupo", grupo);
       List<Grupo> grupos = this.grupoFacade.findAll();
       request.setAttribute("GrupoList", grupos);
       

       List<Usuario> participantes=grupo.getUsuarioList();
       request.setAttribute("Participantes",participantes);

//       Collection<Usuario> participantes=grupo.getUsuarioCollection();
//       request.setAttribute("Participantes",participantes);

       
       RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/integrantes.jsp");
       rd.forward(request, response);  
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