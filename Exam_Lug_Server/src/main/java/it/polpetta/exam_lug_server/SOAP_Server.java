/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.exam_lug_server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class SOAP_Server {
    public static void main(String[] args) throws InterruptedException{
        WS_Impl server= new WS_Impl();
        String address="http://localhost:8080/Movie_Server";
        Endpoint.publish(address,server);
        Thread.sleep(60*1000*5);
        System.exit(0);
    }
}
