package com.supinforce.mewpipe.controller;

import com.supinforce.mewpipe.entity.User;
import com.supinforce.mewpipe.entity.Video;
import com.supinforce.mewpipe.service.UserService;
import com.supinforce.mewpipe.service.VideoService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Pierre on 28/01/2015.
 */

@ManagedBean
@RequestScoped
public class UserController {

    @EJB
    private UserService userService;

    @EJB
    private VideoService videoService;

    private String name;
    private String firstName;
    private String email;
    private String password;
    private String pseudo;
    private Date birthDate;
    private List<Video> videos;

    public UserController() {
    }

    public String createAccountPage()
    {
        return "createAccount";
    }

    public String createAccount()
    {
        User user = new User();
        user.setName(name);
        //user.setBirthDate(birthDate);
        user.setEmail(email);
        user.setFirsrName(firstName);
        user.setPassword(password);
        user.setUserName(pseudo);
        userService.addUser(user);
        return "index";
    }

    public String goToLoginPage()
    {
        return "login";
    }

    public String login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        User user = userService.getUser(pseudo,password);
        if(user!=null) {
            session.setAttribute("user", user);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/index.xhtml");
        }
        else
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/login.xhtml");
        }
        return "index";
    }

    public void logout() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.removeAttribute("user");
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/index.xhtml");
    }

    public void myChannelPage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        videos = videoService.getUserVideos(((User)session.getAttribute("user")).getId());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/mewpipe/user.xhtml");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMyChannelPage() {
        return null;
    }

    public String getLogout() {
        return null;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
