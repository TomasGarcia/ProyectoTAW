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
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Hp
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @EJB private UsuarioFacade usuarioFacade;
    
    protected List<Usuario> listaUsuarios;
    protected Usuario usuario;
    protected String email;
    protected String password;
    protected boolean login;
    
    public LoginBean() {
        login = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacade getUserFacade() {
        return usuarioFacade;
    }

    public void setUserFacade(UsuarioFacade userFacade) {
        this.usuarioFacade = userFacade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @PostConstruct
    public void init(){
        listaUsuarios = this.usuarioFacade.findAll();
    }
    
    public String doLogin(){
        Usuario user = this.usuarioFacade.buscarPorEmailYPassword(email,password);
        if(user != null && user.getEmail().equals(email) && user.getPassword().equals(password)){
            login = true;
            usuario = user;
            return "muro";
        }else{
            login= false;
            return "index";
        }
    }
    
    public String doRegister(){
        return "registrar";
    }
    
    public String doDesconectar(){
        return "index";
    }
    
}
