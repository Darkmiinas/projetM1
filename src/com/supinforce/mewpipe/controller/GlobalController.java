package com.supinforce.mewpipe.controller;


import com.supinforce.mewpipe.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by The Boys Bandent on 13/02/2015.
 */

/**
 * Contrôleur gérant les pages accessibles à tous
 */
@ManagedBean
@SessionScoped
public class GlobalController {

    @EJB
    private UserService userService;

    public void indexPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/index.xhtml");
    }

    public void contactPage() throws IOException {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/contact.xhtml");
    }

    public void connectPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/login.xhtml");
    }
}
