// HelloWorldLocal.java
package fr.univ.paris;

import javax.ejb.Local;

@Local
public interface HelloWorldLocal {
    public String printHelloWorld();
}
