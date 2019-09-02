/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.lab3_client;

import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class Client {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            Context ctx = new InitialContext(props);

            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
            TopicConnection connection = (TopicConnection)connectionFactory.createConnection();
            
            TopicSession session = (TopicSession)connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination)ctx.lookup("dynamicTopics/professors");
            TopicSubscriber subscriber = session.createSubscriber((Topic)destination);
            
            subscriber.setMessageListener(new ProfessorListener());
            connection.start();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
