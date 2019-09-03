/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.exam_lug_client;

/**
 *
 * @author biar
 */
public class Client {
    public static void main(String[] args) {
        WSImplService service = new WSImplService();
        WSIFace port = service.getWSImplPort();
        
        String m = port.getMovie(1);
        System.out.println("Movie = "+m);
        
        java.util.List<java.lang.String> result = port.listMovies();
        System.out.println("Result = "+result);


    }
}
