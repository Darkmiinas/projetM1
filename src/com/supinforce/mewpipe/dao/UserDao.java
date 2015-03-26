package com.supinforce.mewpipe.dao;

import com.supinforce.mewpipe.entity.User;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benoit on 12/02/2015.
 */

@Stateless
public class UserDao extends Dao<User> {

    public User getUserByCredentials(String pseudo, String password)
    {
        if (pseudo == null || password == null) {
            return null;
        }
        else {
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> user = query.from(User.class);
            List<Predicate> predicates = new ArrayList<Predicate>();

            predicates.add(
                    criteriaBuilder.equal(user.get("userName"), pseudo)
            );
            predicates.add(
                    criteriaBuilder.equal(user.get("password"), password)
            );

            query.where(
                    predicates.toArray(new Predicate[predicates.size()])
            );

            User result = manager.createQuery(query).getSingleResult();


            return result;
        }
    }

    public void refreshUser(User user)
    {
        manager.refresh(user);
    }



}
