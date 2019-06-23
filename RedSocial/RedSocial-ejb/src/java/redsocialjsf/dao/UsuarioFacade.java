/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.dao;

import redsocialjsf.entity.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> buscarUsuarioPorUsername(String nombre){
        Query q;
//        q = this.em.createQuery("select u from Usuario u where u.username like '"+ nombre + "';");
        q = this.em.createQuery("select u from Usuario u where u.username like :username");
        q.setParameter("username", nombre);
        
        return q.getResultList();
    }
    
    public List<Usuario> buscarUsuarioPorUsernameCoincidente(String nombre){
        Query q;
        
        q = this.em.createQuery("select u from Usuario u where u.username like :username");
        q.setParameter("username", nombre+"%");
        
        return q.getResultList();
    }
    
        public List<Usuario> findAllMenosYo(String cod) {
        Query q;
        q = this.em.createQuery("select e from Usuario e where e.username != :codigo");
        q.setParameter("codigo", cod+"%");
        return q.getResultList();
    }
   
    
    public List<Usuario> buscarUsuarioPorEmail(String email){
        Query q;
//        q = this.em.createQuery("select u from Usuario u where u.username like '"+ nombre + "';");
        q = this.em.createQuery("select u from Usuario u where u.email = :email");
        q.setParameter("email", email);
        
        return q.getResultList();
    }
    
    public Usuario buscarPorID(int id){
        Query q;
        q = this.em.createQuery("select u from Usuario u where u.id = :id");
        q.setParameter("id", id);
        
        return (Usuario)q.getResultList().get(0);
    }
    
        public Usuario buscarPorEmailYPassword(String email,String password) {
        Query q;
        q = this.em.createQuery("select u from Usuario u where u.email =:email and u.password =:password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        if(q.getResultList().isEmpty()){
            return null;
        }else{
            return (Usuario)q.getResultList().get(0);
        }
    }

}
