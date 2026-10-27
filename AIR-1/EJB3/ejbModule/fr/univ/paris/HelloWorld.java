// HelloWorld.java
package fr.univ.paris;

import javax.ejb.Stateless;

@Stateless
public class HelloWorld implements HelloWorldRemote, HelloWorldLocal {

    @Override
    public String printHelloWorld() {
        return "Hello World depuis EJB !"; // mensaje que devuelve el bean
    }
}
