package com.supinforce.mewpipe.controller;
import com.supinforce.mewpipe.service.VideoService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class VideoController {

    @EJB
    private VideoService videoService;

    public void uploadVideo()
    {

    }
}