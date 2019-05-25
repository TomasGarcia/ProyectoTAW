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
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Hp
 */
@Named(value = "loginBean")
@Dependent
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
        Usuario user = this.usuarioFacade.buscarPorEmailYPassword(email);
        if(usuario != null && usuario.getEmail().equals(email) && usuario.getPassword().equals(password)){
            login = true;
            user = usuario;
            return "muro";
        }else{
            login= false;
            return "index";
        }
    }
    
    public String doRegister(){
        return "registrar";
    }
    
}
