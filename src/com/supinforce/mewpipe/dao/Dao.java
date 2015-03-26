package com.supinforce.mewpipe.dao;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Pierre on 28/01/2015.
 */
@Stateless
public class Dao<T> {

    //@PersistenceContext(unitName = "NewPersistenceUnit")
    protected EntityManager manager = PersistenceManager.getEntityManagerFactory().createEntityManager();

    public void addEntity(T entity)
    {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    public T getEntityById(long id, Class<T> c)
    {
        return manager.find(c,id);
    }

    public List getEntities(Class<T> c)
    {
        return manager.createQuery("Select entity From "+ c.getName()+" entity").getResultList();
    }

    public void deleteUser(long id)
    {
        manager.remove(id);
    }
}
