/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import redsocialjsf.entity.Publicaciones;

/**
 *
 * @author tmgrm
 */
@Stateless
public class PublicacionesFacade extends AbstractFacade<Publicaciones> {

    @PersistenceContext(unitName = "RedSocialJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicacionesFacade() {
        super(Publicaciones.class);
    }
}
