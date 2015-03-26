package com.supinforce.mewpipe.service;

/**
 * Created by drgdfh on 26/03/15.
 */
import com.supinforce.mewpipe.dao.VideoDao;
import com.supinforce.mewpipe.entity.Video;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Pierre on 26/03/2015.
 */

@Stateless
public class VideoService {
    public static String VIDEOPATH = "D:\\projet m1\\the ultimate m1 project\\web\\Video\\";

    @EJB
    private VideoDao videoDao;

    public List<Video> getUserVideos(long id)
    {
       return videoDao.getVideoByUserId(id);
    }
}