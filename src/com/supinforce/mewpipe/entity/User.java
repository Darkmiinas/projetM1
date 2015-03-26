package com.supinforce.mewpipe.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pierre on 28/01/2015.
 */
@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    protected String userName;
    protected String password;
    protected String name;
    protected String firstName;
    protected String email;
    @OneToMany
    private List<Video> videos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirsrName() {
        return firstName;
    }

    public void setFirsrName(String firsrName) {
        this.firstName = firsrName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
