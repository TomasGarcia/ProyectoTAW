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
import redsocialjsf.entity.Grupo;

/**
 *
 * @author tmgrm
 */
@Stateless
public class GrupoFacade extends AbstractFacade<Grupo> {

    @PersistenceContext(unitName = "RedSocialJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }
    
    public List<Grupo> buscarPorCreador(int id){
        Query q;
        q=this.em.createQuery("select g from Grupo g where g.usuario.id = :id  ");
        q.setParameter("id", id);
        return q.getResultList();
        
    }
    
    public List<Grupo> buscarPorNombre(String n){
        Query q;
        q=this.em.createQuery("select g from Grupo g where g.nombre like :n");
        q.setParameter("n",n + "%");
        return q.getResultList();
        
    }
    
}
