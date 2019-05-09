/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entities.Peticion;
import Entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hp
 */
@Stateless
public class PeticionFacade extends AbstractFacade<Peticion> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeticionFacade() {
        super(Peticion.class);
    }
    
    public List<Peticion> misPeticiones(Integer id){
        Query q;
        q = this.em.createQuery("select p from Peticion p where p.usuario1.id = :id");
        
        return q.getResultList();
    }
    
}
