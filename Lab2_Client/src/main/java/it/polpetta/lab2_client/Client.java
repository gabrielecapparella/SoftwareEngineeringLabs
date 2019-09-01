/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.lab2_client;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.bind.JAXB;
import java.util.Scanner;

/**
 *
 * @author biar
 */
public class Client {
    private static String BASE_URL = "http://localhost:8080/repo/";
    private static CloseableHttpClient client;
    
    public static void main(String args[]) throws Exception {
        client = HttpClients.createDefault();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the courseId: ");
        int c_id = scanner.nextInt();
        Course test = getCourse(c_id);
        System.out.println("The course name is:"+test.getName());
        
        client.close();
    }
    
    static public Course getCourse(int courseId) throws Exception {;
        URL url = new URL(BASE_URL + "courses/" + courseId);
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Course.class);
    }
    
}
