/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.AmistadFacade;
import redsocialjsf.entity.Amistad;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Alejandro Calvo
 */
@Named(value = "amigosBean")
@RequestScoped

public class AmigosBean {

     @Inject LoginBean loginBean;
     @EJB private AmistadFacade amistadFacade;
    
     protected List<Amistad> listaAmigos;
     protected Usuario usuario;
     protected Amistad amistad;
    
    public AmigosBean() {
    }
    
    @PostConstruct
    public void init(){
        this.usuario = this.loginBean.getUsuario();
        this.amistad = this.usuario.getAmistad();
    }
    
}
