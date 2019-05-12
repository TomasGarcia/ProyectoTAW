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
 * @author tmgrm
 */
@WebServlet(name = "addIntegrante", urlPatterns = {"/addIntegrante"})
public class AddIntegranteServlet extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    @EJB
    private GrupoFacade grupoFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("user");
        Grupo grupo = this.grupoFacade.find((Integer)session.getAttribute("idGrupo"));

        List<Usuario> usuariosGrupo = grupo.getUsuarioList();
        Usuario usuario = this.usuarioFacade.buscarPorID(new Integer(username));
        String redirect = "/integrantesServlet?id=" + grupo.getId();
        if(usuariosGrupo.contains(usuario)){
             redirect = "integrantesServlet?id=" + grupo.getId();
             request.setAttribute("mensaje", "El usuario ya esta en el grupo o no existe");
             request.setAttribute("url", redirect);
             redirect = "/errorManteniendoSession.jsp";
        }else{
            usuariosGrupo.add(usuario);
            grupo.setUsuarioList(usuariosGrupo);
            this.grupoFacade.edit(grupo);
        }
        Usuario loggedUser = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario", loggedUser);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(redirect);
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
