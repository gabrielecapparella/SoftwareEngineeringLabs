/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.exam_lug_server;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface WS_IFace {
    public List<String> listMovies();
    public String getMovie(int id);
    public String getDirector(int id);
}
