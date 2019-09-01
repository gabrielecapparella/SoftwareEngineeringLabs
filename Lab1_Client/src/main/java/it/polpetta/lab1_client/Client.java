/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polpetta.lab1_client;

import java.util.*;
/**
 *
 * @author biar
 */
public class Client {
    public static void main(String[] args) throws Exception{
        List<String> clients = getLastOPsByDescription("benzina autostrada");
        System.out.println(clients);
        
    }
    
    static public List<String> getClients(){
        AaawsImplService service = new AaawsImplService();
        AaawsIFace port = service.getAaawsImplPort();
        java.util.List<java.lang.String> result = port.getClients();
        System.out.println("Result1 = "+result);
        return result;
    }
    
    static public java.util.List<java.lang.String> getOperationsByClientID (int ClientID){
        BankImplService service = new BankImplService();
        BankIFace port = service.getBankImplPort();
        java.util.List<java.lang.String> result = port.getOperationsByClientID(ClientID);
        System.out.println("Result2 = "+result);
        return result;
    }
    
    static public String getOperationDetailsByID(int ID){
        BankImplService service = new BankImplService();
        BankIFace port = service.getBankImplPort();
        String result = port.getOperationDetailsByID(ID);
        System.out.println("Result3 = "+result);
        return result;
    }
    
    static public List<String> getLastOPsByDescription(String Description){
        List<String> clients = getClients();
        Iterator<String> it = clients.listIterator();
        int c_id;
        String c_name;
        List<String> result =new ArrayList<>();
        while(it.hasNext()){
            String[] client = it.next().split(",");
            c_id = Integer.parseInt(client[0]);
            c_name = client[1];
            System.out.println("name = "+c_name+", id="+c_id);
            java.util.List<java.lang.String> ops = getOperationsByClientID(c_id);
            for (String op : ops) {
                String[] details = op.split(",");
                System.out.println("d4 = '"+details[4]+"', d='"+Description+"'");
                if(details[4].replace("]", "").equals(Description)) {
                    result.add(c_name);
                } 
            }
        }
        return result;
    }
}
