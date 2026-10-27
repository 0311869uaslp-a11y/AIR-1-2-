package com.example.ejb;

import javax.ejb.Local;

@Local
public interface HelloWorldLocal {
    String printHelloWorld();
}
