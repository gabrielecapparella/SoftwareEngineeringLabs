/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.lab3_client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author biar
 */
public class ProfessorListener implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        try {
            String id = msg.getStringProperty("id");
            float rank = msg.getFloatProperty("rank");
            System.out.println("Professor's id is " + id +" and has rank " + rank);
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }
}
