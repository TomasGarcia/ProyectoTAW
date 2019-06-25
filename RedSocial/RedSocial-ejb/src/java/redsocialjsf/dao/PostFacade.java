/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.dao;

import redsocialjsf.entity.Post;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hp
 */
import java.util.List;
import javax.persistence.Query;
@Stateless
public class PostFacade extends AbstractFacade<Post> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    public List<Post> buscarPorPostsUsuario(int id){
        Query q;
        q = this.em.createQuery("select p from Post p where (p.usuarioId.id != p.usuarioId1.id) and "
                + "(p.usuarioId.id = :id or p.usuarioId1.id = :id or p.usuarioId1.id = 1) "
                + "order by p.fecha desc, p.id desc");
        q.setParameter("id", id);
        return q.getResultList();
    }
}
