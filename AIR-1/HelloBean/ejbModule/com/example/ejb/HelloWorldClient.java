package com.example.ejb;

import javax.naming.InitialContext;

public class HelloWorldClient {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            HelloBeanRemote hello = (HelloBeanRemote) ctx.lookup("java:module/HelloBean");
            System.out.println(hello.printHelloWorld());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
