/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.bean;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.PostFacade;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Post;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author tmgrm
 */
@Named(value = "crearPostBean")
@RequestScoped
public class CrearPostBean {

    @Inject PostBean postBean;
    @EJB protected UsuarioFacade usuarioFacade;
    @EJB protected PostFacade postFacade;
    protected List<Post> posts;
    protected Usuario usuario;
    protected Usuario uPublico;
    protected List<Usuario> amigos;
    protected Post nuevoPost;
    
    public CrearPostBean() {
    }

    
    @PostConstruct
    public void init(){
        this.usuario = this.postBean.getUsuario();
        this.posts = this.postBean.getListaPosts();
        this.uPublico = this.postBean.getUserPublic();
        this.amigos = (this.usuario.getUsuarioList());
        this.amigos.add(0, uPublico);
        this.nuevoPost = new Post();
    }
    
    public String doPost(){
        this.nuevoPost.setId(1);
        this.nuevoPost.setUsuarioId(usuario);
        this.nuevoPost.setFecha(new Date());
        this.nuevoPost.setUsuarioId1(this.usuarioFacade.find(this.nuevoPost.getDestinatario()));
        this.postFacade.create(nuevoPost);
        List<Post> listaPost = this.postBean.getListaPosts();
        listaPost.add(0, nuevoPost);
        this.postBean.setListaPosts(listaPost);
        return "muro";
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

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public PostFacade getPostFacade() {
        return postFacade;
    }

    public void setPostFacade(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getuPublico() {
        return uPublico;
    }

    public void setuPublico(Usuario uPublico) {
        this.uPublico = uPublico;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public Post getNuevoPost() {
        return nuevoPost;
    }

    public void setNuevoPost(Post nuevoPost) {
        this.nuevoPost = nuevoPost;
    }
    
    
}
