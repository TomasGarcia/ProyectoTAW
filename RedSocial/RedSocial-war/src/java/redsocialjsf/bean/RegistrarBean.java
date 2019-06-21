/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.text.ParseException;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Hp
 */
@Named(value = "registrarBean")
@RequestScoped
public class RegistrarBean {

    @EJB private UsuarioFacade usuarioFacade;
    
    protected Usuario usuario;
    protected String username, email, password, passwordConfirm, nombre, apellido, pais;
    protected String fecha_nacimiento;
    protected Date fecha_nac;
    protected UIComponent pass,user,mail;
    
    /**
     * Creates a new instance of RegistrarBean
     */
    public RegistrarBean() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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
        
    public String doRegister() throws ParseException{
        if(!this.usuarioFacade.buscarUsuarioPorUsername(this.username).isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username ya existente", null);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(this.user.getClientId(), message);
            return null;
        }else if(!this.usuarioFacade.buscarUsuarioPorEmail(this.email).isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email ya registrado", null);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(this.mail.getClientId(), message);
            return null;
        }else if(!this.password.equals(this.passwordConfirm)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Contraseñas no Coincidentes", null);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(this.pass.getClientId(), message);
            return null;
        }
        this.usuario = new Usuario();
        this.usuario.setId(0);
        this.usuario.setNombre(nombre);
        this.usuario.setPassword(password);
        this.usuario.setApellido(apellido);       
        this.usuario.setPais(pais);
        this.usuario.setFechaNacimiento(fecha_nac);
        
        //FALTARIA COMPROBAR QUE NO EXISTE YA UN USUARIO CON ESE EMAIL Y USERNAME
        this.usuario.setUsername(username);
        this.usuario.setEmail(email);        
      
        this.usuarioFacade.create(usuario);
      
        return "index";
    }

    

    
    
}
