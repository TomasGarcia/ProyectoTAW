/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

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
 * @author Hp
 */
@Named(value = "registrarBean")
@Dependent
public class RegistrarBean {

    @EJB private UsuarioFacade usuarioFacade;
    
    protected String username, email, password, nombre, apellido, pais;
    protected Date fecha_nacimiento;
    
    /**
     * Creates a new instance of RegistrarBean
     */
    public RegistrarBean() {
        
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
    
    
    
    public String doRegister() throws ParseException{
        Usuario usuario = new Usuario();
        usuario.setId(0);
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPais(pais);
        usuario.setFechaNacimiento(fecha_nacimiento);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        
//        Date date = format.parse(fecha_nacimiento);
//        usuario.setFechaNacimiento( new Date(date.getTime()+24*60*60*1000));
        
        //FALTARIA COMPROBAR QUE NO EXISTE YA UN USUARIO CON ESE EMAIL Y USERNAME
        usuario.setUsername(username);
        usuario.setEmail(email);
        
        this.usuarioFacade.create(usuario);
        
        return "login";
        
    }

    

    
    
}
