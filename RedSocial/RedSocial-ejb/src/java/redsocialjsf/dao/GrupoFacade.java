/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.dao;

import redsocialjsf.entity.Grupo;
import redsocialjsf.entity.Post;
import redsocialjsf.entity.Usuario;
import java.util.Collection;
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
public class GrupoFacade extends AbstractFacade<Grupo> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }
    
    public List<Grupo> getGruposList(){
        List<Grupo> list;
        Query q;
        q = this.em.createQuery("SELECT g FROM Grupo g");
        
        list = q.getResultList();
        return list;
    }
    
    public Grupo buscarGrupoPorID(int id){
        Query q;
        q = this.em.createQuery("select g from Grupo g where g.id = :id");
        q.setParameter("id", id);
        
        return (Grupo)q.getResultList().get(0);
    }
    
    public List<Grupo> buscarPorCreadorYMiembro(int id){
        Query q;
        q=this.em.createQuery("select g from Grupo g where g.usuarioId.id = :id");
        q.setParameter("id", id);
        return q.getResultList();
        
    }
    
    public List<Grupo> buscarPorNombre(String n){
        Query q;
        q=this.em.createQuery("select g from Grupo g where g.nombre like :n");
        q.setParameter("n",n + "%");
        return q.getResultList();
        
    }
    
    public List<Grupo> doFiltrarPorCreador(List<Integer> list){
        
        Query q;
        
        q=this.em.createQuery("select g from Grupo g where g.usuarioId.id in :list");
        q.setParameter("list",list);
        
        return q.getResultList();
        
    }
       
    
    

    
}
