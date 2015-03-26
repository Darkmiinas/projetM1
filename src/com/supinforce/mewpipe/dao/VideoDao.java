package com.supinforce.mewpipe.dao;

import com.supinforce.mewpipe.entity.Video;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by drgdfh on 26/03/15.
 */

public class VideoDao extends Dao<Video> {

    public List<Video> getVideoByUserId(long id)
    {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Video> query = criteriaBuilder.createQuery(Video.class);
        Root<Video> r =query.from(Video.class);
        ArrayList<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(r.get("user"),getEntityById(id, Video.class)));
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        List<Video> c = manager.createQuery(query).getResultList();
        return c;
    }
}
