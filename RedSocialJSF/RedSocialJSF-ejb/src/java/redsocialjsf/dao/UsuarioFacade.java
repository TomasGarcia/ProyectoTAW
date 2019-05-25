/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import redsocialjsf.entity.Usuario;

/**
 *
 * @author tmgrm
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "RedSocialJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario buscarPorEmailYPassword(String email) {
        Query q;
        q = this.em.createQuery("select u from Usuario u where u.email = :email");
        q.setParameter("email", email);
        
        return (Usuario)q.getResultList().get(0);
    }
    
}
