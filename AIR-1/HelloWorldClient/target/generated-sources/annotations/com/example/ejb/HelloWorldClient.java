package com.example.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class HelloWorldClient {
    public static void main(String[] args) {
        Context ctx = null;
        try {
            // Configurar propiedades JNDI para WildFly 24
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

            // Crear InitialContext
            ctx = new InitialContext(props);

            // Búsqueda JNDI para el EJB
            String jndiName = "ejb:/HelloWorldEJB/HelloBean!com.example.ejb.HelloWorldRemote";
            HelloWorldRemote helloWorldRemote = (HelloWorldRemote) ctx.lookup(jndiName);
            System.out.println(helloWorldRemote.printHelloWorld());
        } catch (NamingException e) {
            System.err.println("NamingException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el contexto manualmente
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    System.err.println("Error al cerrar el contexto: " + e.getMessage());
                }
            }
        }
    }
}