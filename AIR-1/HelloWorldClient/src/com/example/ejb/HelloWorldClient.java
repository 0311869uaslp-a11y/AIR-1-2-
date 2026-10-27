package com.example.ejb;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloWorldClient {

    public static void main(String[] args) {
        try {
            HelloBeanRemote bean = lookupRemoteHello();
            System.out.println(bean.printHelloWorld());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HelloBeanRemote lookupRemoteHello() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        InitialContext ctx = new InitialContext(jndiProps);
        return (HelloBeanRemote) ctx.lookup("ejb:/tuProyectoEJB/HelloBean!com.example.ejb.HelloBeanRemote");
    }
}
