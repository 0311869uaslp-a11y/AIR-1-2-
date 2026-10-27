package com.example.ejb;

public class HelloWorldClient {
    public static void main(String[] args) {
        // Crear directamente la instancia del EJB
        HelloWorldLocal hello = new HelloBean();
        System.out.println(hello.printHelloWorld());
    }
}
