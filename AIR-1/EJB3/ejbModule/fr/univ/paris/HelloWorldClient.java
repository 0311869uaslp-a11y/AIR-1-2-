package fr.univ.paris;


import java.util.Properties;
 import javax.naming.Context;
 import javax.naming.InitialContext;
 public class HelloWorldClient {
 public static void main(String[] args) {
 try {
 Properties p = new Properties();
 p.put(Context.INITIAL_CONTEXT_FACTORY,
 "org.jnp.interfaces.NamingContextFactory");
 p.put(Context.PROVIDER_URL, "localhost:1099");
 p.put(Context.URL_PKG_PREFIXES,
 "org.jboss.naming:org.jnp.interfaces");
 InitialContext ctx = new InitialContext(p);
 HelloWorldRemote helloWorldRemote = (HelloWorldRemote)
 ctx.lookup("HelloWorld/remote");
 System.out.println(helloWorldRemote.printHelloWorld());
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 }
}