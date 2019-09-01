/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.lab1_aaaws;

import javax.jws.WebService;

@WebService(endpointInterface = "it.polpetta.lab1_aaaws.AaawsIFace")
public class AaawsImpl implements AaawsIFace{
    public String[] getClients(){
        String[] clients=new String[2];
        clients[0]="1,Mattia Nicolella";
        clients[1]="2,Nicolella Mattia";
        return clients;
    }
}
