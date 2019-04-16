/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entities.Post;
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
    
    //Get all the posts
    public List<Post> getPostList(){
        List<Post> list;
        Query q;
        q = this.em.createQuery("SELECT p FROM Post p");
        
        list = q.getResultList();
        return list;
    }
}
