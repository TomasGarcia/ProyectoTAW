/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.GrupoFacade;
import redsocialjsf.dao.PostFacade;
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Post;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author Jose
 */
@Named(value = "mensajesBean")
@RequestScoped
public class MensajesBean {
    
    @Inject GruposBean gruposBean;
    @Inject PostBean postBean;
    @EJB PostFacade postFacade;
    @EJB GrupoFacade grupoFacade;
    private Grupo grupo;
    private List<Post> listaMensajes;
    private Post nuevoPost;
    private Usuario usuario;
    /**
     * Creates a new instance of MensajesBean
     */
    public MensajesBean() {
    }
    
    @PostConstruct
    public void init(){
        this.grupo=this.postBean.getGrupoSeleccionado();
        this.listaMensajes=this.grupo.getPostList();
        this.usuario = this.gruposBean.getUsuario();
        this.nuevoPost = new Post();
    }
    
    public String addMensaje(){
        return "crearMensaje";
    }

    public String doGuardarMensaje(){
        this.nuevoPost.setId(0);
        this.nuevoPost.setDestinatario(0);
        this.nuevoPost.setUsuarioId(usuario);
        this.nuevoPost.setUsuarioId1(usuario);
        this.nuevoPost.setFecha(new Date());
        
        List<Post> postsGrupo = this.grupo.getPostList();
        if(postsGrupo == null){
            postsGrupo = new ArrayList();
        }
        postsGrupo.add(nuevoPost);
        this.grupo.setPostList(postsGrupo);
        listaMensajes = postsGrupo;
        this.postFacade.create(nuevoPost);
        this.grupoFacade.edit(grupo);
        
        return "mensajes";
    }
    
    public String doEliminar(Post p){
        this.listaMensajes.remove(p);
        this.grupo.setPostList(listaMensajes);
        this.grupoFacade.edit(grupo);
        this.postFacade.remove(p);
        return null;
    }
    
    public Boolean puedeEliminar(Post p){
       Boolean postSuyo = p.getUsuarioId().getId().equals(this.usuario.getId());
       Boolean creadorGrupo = this.grupo.getUsuarioId().getId().equals(this.usuario.getId()) ;
       return postSuyo || creadorGrupo;
              
    }
    
    public GruposBean getGruposBean() {
        return gruposBean;
    }

    public void setGruposBean(GruposBean gruposBean) {
        this.gruposBean = gruposBean;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Post> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Post> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public Post getNuevoPost() {
        return nuevoPost;
    }

    public void setNuevoPost(Post nuevoPost) {
        this.nuevoPost = nuevoPost;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
