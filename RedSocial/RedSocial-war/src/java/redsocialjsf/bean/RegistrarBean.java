/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Named(value = "registrarBean")
@RequestScoped
public class RegistrarBean {

    @EJB private UsuarioFacade usuarioFacade;
    
    protected Usuario usuario;
    protected String username, email, password, nombre, apellido, pais;
    protected String fecha_nacimiento;
    protected Date fecha_nac;
    
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
    
    public String doRegister() throws ParseException{
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
