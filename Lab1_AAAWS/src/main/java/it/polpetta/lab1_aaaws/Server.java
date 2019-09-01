/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.lab1_aaaws;

import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) throws InterruptedException{
        AaawsImpl server= new AaawsImpl();
        String address="http://localhost:8081/AAAWSServer";
        Endpoint.publish(address,server);
        Thread.sleep(60*1000);
        System.exit(0);
    }
}
