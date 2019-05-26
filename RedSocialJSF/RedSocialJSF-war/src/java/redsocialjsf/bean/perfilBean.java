/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "perfilBean")
@Dependent
public class perfilBean {
    
    @EJB private UsuarioFacade usuarioFacade;
    
    protected String username, email, password, nombre, apellido, pais;
    protected Date fecha_nacimiento;

   
    public perfilBean() {
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
