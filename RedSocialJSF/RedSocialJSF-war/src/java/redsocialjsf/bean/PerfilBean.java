/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
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
    
    protected Usuario usuario;
    protected String username, email, password, nombre, apellido, pais;
    protected Date fecha_nac;


    public PerfilBean(UsuarioFacade usuarioFacade, PostBean postBean) {
        this.usuarioFacade = usuarioFacade;
        this.postBean = postBean;
    }
    
    public PerfilBean() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    @PostConstruct
    public void init(){
        this.usuario = this.postBean.getUsuario();
    }
    
    public String doGuardar(){
        this.usuarioFacade.edit(this.usuario);
        return "perfil";
    }
}
