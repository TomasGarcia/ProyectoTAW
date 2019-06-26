/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author tmgrm
 */
@Named(value = "perfilBean")
@RequestScoped
public class PerfilBean{

    @EJB private UsuarioFacade usuarioFacade;
    @Inject PostBean postBean;
    @Inject LoginBean loginBean;
    
    protected Usuario usuario;
    protected UIComponent pass,user,mail;
    protected String passwordConfirm, usernameAnterior, emailAnterior, usernameActual,emailActual, passwordActual, passwordAnterior;


    public PerfilBean(UsuarioFacade usuarioFacade, PostBean postBean) {
        this.usuarioFacade = usuarioFacade;
        this.postBean = postBean;
    }
    
    public PerfilBean() {
    }
    
    @PostConstruct
    public void init(){
        this.usuario = this.loginBean.getUsuario();
        this.usernameAnterior = this.usuario.getUsername();
        this.emailAnterior = this.usuario.getEmail();
        this.passwordConfirm = "";
        this.emailActual = this.usuario.getEmail();
        this.usernameActual = this.usuario.getUsername();
    }
    
    public String doGuardar(){
            if(!this.usernameAnterior.equals(this.usernameActual) && !this.usuarioFacade.buscarUsuarioPorUsername(this.usernameActual).isEmpty()){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username ya existente", null);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(this.user.getClientId(), message);
                this.init();
                return null;
            }else if(!this.emailAnterior.equals(this.emailActual) && !this.usuarioFacade.buscarUsuarioPorEmail(this.emailActual).isEmpty()){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email ya registrado", null);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(this.mail.getClientId(), message);
                this.init();
                return null;
            }else if(!this.passwordActual.equals(this.passwordConfirm)){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Contraseñas no Coincidentes", null);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(this.pass.getClientId(), message);
                this.init();
                return null;
            }
        this.usuario.setUsername(usernameActual);
        this.usuario.setEmail(emailActual);
        this.usuario.setPassword(passwordActual);
        this.usuarioFacade.edit(this.usuario);
        this.postBean.setUsuario(usuario);
        this.loginBean.setUsuario(usuario);
        return null;
    }
    
    public String doVolver(){
        return "muro";
    }

    public PostBean getPostBean() {
        return postBean;
    }

    public void setPostBean(PostBean postBean) {
        this.postBean = postBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UIComponent getPass() {
        return pass;
    }

    public void setPass(UIComponent pass) {
        this.pass = pass;
    }

    public UIComponent getUser() {
        return user;
    }

    public void setUser(UIComponent user) {
        this.user = user;
    }

    public UIComponent getMail() {
        return mail;
    }

    public void setMail(UIComponent mail) {
        this.mail = mail;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getUsernameAnterior() {
        return usernameAnterior;
    }

    public void setUsernameAnterior(String usernameAnterior) {
        this.usernameAnterior = usernameAnterior;
    }

    public String getEmailAnterior() {
        return emailAnterior;
    }

    public void setEmailAnterior(String emailAnterior) {
        this.emailAnterior = emailAnterior;
    }

    public String getUsernameActual() {
        return usernameActual;
    }

    public void setUsernameActual(String usernameActual) {
        this.usernameActual = usernameActual;
    }

    public String getEmailActual() {
        return emailActual;
    }

    public void setEmailActual(String emailActual) {
        this.emailActual = emailActual;
    }    

    public String getPasswordActual() {
        return passwordActual;
    }

    public void setPasswordActual(String passwordActual) {
        this.passwordActual = passwordActual;
    }

    public String getPasswordAnterior() {
        return passwordAnterior;
    }

    public void setPasswordAnterior(String passwordAnterior) {
        this.passwordAnterior = passwordAnterior;
    }
}
