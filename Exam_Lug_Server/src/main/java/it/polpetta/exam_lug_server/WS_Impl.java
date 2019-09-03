/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.exam_lug_server;

import javax.jws.WebService;

@WebService(endpointInterface = "it.polpetta.exam_lug_server.WS_IFace")
public class WS_Impl implements WS_IFace{
    public String getMovie(int id){
        String movie = "yay";
        return movie;
    }
    
    public String[] listMovies() {
        String[] movies = {"yay", "nay"};
        return movies;
    }
}
