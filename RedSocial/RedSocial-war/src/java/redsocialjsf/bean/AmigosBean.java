/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import redsocialjsf.dao.PeticionFacade;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Peticion;
import redsocialjsf.entity.PeticionPK;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Alejandro Calvo
 */
@Named(value = "amigosBean")
@SessionScoped

public class AmigosBean implements Serializable{

    @Inject LoginBean loginBean;
    @EJB UsuarioFacade usuarioFacade;
    @EJB PeticionFacade peticionFacade;
    
    protected Usuario usuario;
    protected String filtroNombre;
    protected List<Usuario> listaUsuarios;
    protected List<Usuario> amigos;
    protected List<Usuario> amigos1;
    
    protected List<Peticion> listaPeticiones;
    
    public AmigosBean(){
        
    }

    public String getFiltroNombre() {
        return filtroNombre;
    }

    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Usuario> getAmigos1() {
        return amigos1;
    }

    public void setAmigos1(List<Usuario> amigos1) {
        this.amigos1 = amigos1;
    }

    

    public List<Peticion> getListaPeticiones() {
        return listaPeticiones;
    }

    public void setListaPeticiones(List<Peticion> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }
    
    
    
    @PostConstruct
    public void init(){
        this.usuario = this.loginBean.getUsuario();
        this.amigos = this.usuario.getUsuarioList();
        this.amigos1 = this.usuario.getUsuarioList1();

        this.filtroNombre = null;
        //this.listaUsuarios = this.usuarioFacade.findAll();//FILTRAR PARA K NO APAREZCAS NI TU NIS TUS AMIGOS
        this.listaPeticiones = this.peticionFacade.misPeticiones(usuario.getId());
    }

    public String doEliminar(Usuario u){
        List<Usuario>listaAmigos = usuario.getUsuarioList();
        listaAmigos.remove(u);
        usuario.setUsuarioList(listaAmigos);
        this.usuarioFacade.edit(usuario);
        
        List<Usuario>listaAmigos1 = u.getUsuarioList();
        listaAmigos1.remove(usuario);
        u.setUsuarioList(listaAmigos1);
        this.usuarioFacade.edit(u);
        return null;
    }
    
    
    public String enviarPeticion(Usuario u){
        PeticionPK peticionPK1, peticionPK2;
        Peticion p = new Peticion();
        p.setUsuario(this.getUsuario());
        p.setUsuario1(u);
        p.setConfirmada(false);
        peticionPK1 = new PeticionPK(usuario.getId(),u.getId());
        p.setPeticionPK(peticionPK1);
        peticionPK2 = new PeticionPK(u.getId(), usuario.getId());
        
        if(this.peticionFacade.find(peticionPK1) == null && this.peticionFacade.find(peticionPK2) == null){
            this.peticionFacade.create(p);
        }
        return null;
    }
    
    public String aceptarPeticion(Peticion peticion){
        //Peticion peticion = this.peticionFacade.find(p);
        
        peticion.setConfirmada(true);
        
        
        Usuario usuario0 = peticion.getUsuario();
        Usuario usuario1 = peticion.getUsuario1();
        
        List<Usuario> usuarios = usuario0.getUsuarioList();
        usuarios.add(usuario1);
        usuario0.setUsuarioList(usuarios);
        this.usuarioFacade.edit(usuario0);
        
        usuarios = usuario1.getUsuarioList();
        usuarios.add(usuario0);
        usuario1.setUsuarioList(usuarios);
        this.usuarioFacade.edit(usuario1);
        this.peticionFacade.edit(peticion);
        
        this.init();
        return null;
    }
    
    public String rechazarPeticion(Integer id,Integer id1){
        PeticionPK peticionPK = new PeticionPK(id,id1);
        Peticion peticion = this.peticionFacade.find(peticionPK);
        
        this.peticionFacade.remove(peticion);
        return null;
    }
    
    public String doFiltrar(){
        this.listaUsuarios = this.usuarioFacade.buscarUsuarioPorUsernameCoincidente(filtroNombre);
        return null;
    }
    
    public String doVolver(){
        this.filtroNombre = null;
        return "muro";
    }
}
