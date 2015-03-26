package com.supinforce.mewpipe.controller;

import javax.inject.Named;

/**
 * Created by Pierre on 24/01/2015.
 */

@Named
public class HelloBean {

    private String hello = "yeeeeah";

    public String getHello()
    {
        return hello;
    }
}
