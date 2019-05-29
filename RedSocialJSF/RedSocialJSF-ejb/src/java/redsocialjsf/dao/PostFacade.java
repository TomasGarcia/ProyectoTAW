/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.validator.constraints.SafeHtml;
import redsocialjsf.entity.Post;

/**
 *
 * @author tmgrm
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> {

    @PersistenceContext(unitName = "RedSocialJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    
    public List<Post> buscarPorPosts(int id){
        Query q;
        q = this.em.createQuery("select p from Post p join p.usuario u join p.usuario1 u1 where u.id = :id or u1.id = :id or u1.id = 1");
        q.setParameter("id", id);
        return q.getResultList();
    }
}
