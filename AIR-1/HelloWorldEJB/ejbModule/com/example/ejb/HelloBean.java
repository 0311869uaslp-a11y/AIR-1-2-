package com.example.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloWorldRemote, HelloWorldLocal {

    @Override
    public String printHelloWorld() {
        return "Hello, World!";
    }
}
