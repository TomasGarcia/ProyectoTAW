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
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import redsocialjsf.dao.PostFacade;
import redsocialjsf.entity.Post;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author tmgrm
 */
@Named(value = "postBean")
@RequestScoped
public class PostBean {

    @Inject LoginBean loginBean;
    @EJB PostFacade postFacade;
    protected Usuario usuario;
    protected List<Post> listaPosts;
    protected List<Usuario> amigos;
    protected List<Usuario> amigos1;

    public PostBean() {
    }
    
    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public PostFacade getPostFacade() {
        return postFacade;
    }

    public void setPostFacade(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Post> getListaPosts() {
        return listaPosts;
    }

    public void setListaPosts(List<Post> listaPosts) {
        this.listaPosts = listaPosts;
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
    
    
    
    public String doPerfil(){
        return "perfil";
    }
    
    public String doBorrar(Post post){
        this.listaPosts.remove(post);
        this.postFacade.remove(post);
        return null;
    }
    
    public Boolean puedeBorrar(int id){
        return this.getUsuario().getId().equals(id);
    }
    
    @PostConstruct
    public void init(){
        this.usuario = this.loginBean.getUsuario();
        this.listaPosts = this.postFacade.buscarPorPostsUsuario(this.usuario.getId());
        this.amigos = this.usuario.getUsuarioList();
        this.amigos1 = this.usuario.getUsuarioList1();
    }
    
    
}
