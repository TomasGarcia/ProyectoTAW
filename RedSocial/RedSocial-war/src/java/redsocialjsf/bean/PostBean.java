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
import redsocialjsf.dao.PostFacade;
import redsocialjsf.dao.UsuarioFacade;
import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Post;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author tmgrm
 */
@Named(value = "postBean")
@SessionScoped
public class PostBean implements Serializable{

    @Inject LoginBean loginBean;
    @Inject GruposBean gruposBean;
    @EJB PostFacade postFacade;
    @EJB UsuarioFacade usuarioFacade;
    protected Usuario usuario;
    protected Usuario userPublic;
    protected Grupo grupoSeleccionado;
    protected List<Post> listaPosts;
    

    public PostBean() {
    }
    
    @PostConstruct
    public void init(){
        this.usuario = this.loginBean.getUsuario();
        this.userPublic = this.usuarioFacade.find(1);
        this.listaPosts = this.postFacade.buscarPorPostsUsuario(this.usuario.getId());
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
    
    public String doEditarGrupo(Grupo g){
        this.grupoSeleccionado = g;
        this.gruposBean.init();
        return "editarGrupo";
    }
    
    public String doAddMiembros(Grupo g){
        this.grupoSeleccionado = g;
        return "addParticipantes";
    }
    
    public String doVerMensajes(Grupo g){
        this.grupoSeleccionado=g;
        return "mensajes";
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

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Usuario getUserPublic() {
        return userPublic;
    }

    public void setUserPublic(Usuario userPublic) {
        this.userPublic = userPublic;
    }

    public Grupo getGrupoSeleccionado() {
        return grupoSeleccionado;
    }

    public void setGrupoSeleccionado(Grupo grupoSeleccionado) {
        this.grupoSeleccionado = grupoSeleccionado;
    }  

}
