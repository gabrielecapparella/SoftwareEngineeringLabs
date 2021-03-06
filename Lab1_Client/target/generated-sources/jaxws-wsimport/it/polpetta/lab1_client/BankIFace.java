
package it.polpetta.lab1_client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BankIFace", targetNamespace = "http://lab1_bank.polpetta.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BankIFace {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOperationsByClientID", targetNamespace = "http://lab1_bank.polpetta.it/", className = "it.polpetta.lab1_client.GetOperationsByClientID")
    @ResponseWrapper(localName = "getOperationsByClientIDResponse", targetNamespace = "http://lab1_bank.polpetta.it/", className = "it.polpetta.lab1_client.GetOperationsByClientIDResponse")
    @Action(input = "http://lab1_bank.polpetta.it/BankIFace/getOperationsByClientIDRequest", output = "http://lab1_bank.polpetta.it/BankIFace/getOperationsByClientIDResponse")
    public List<String> getOperationsByClientID(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOperationDetailsByID", targetNamespace = "http://lab1_bank.polpetta.it/", className = "it.polpetta.lab1_client.GetOperationDetailsByID")
    @ResponseWrapper(localName = "getOperationDetailsByIDResponse", targetNamespace = "http://lab1_bank.polpetta.it/", className = "it.polpetta.lab1_client.GetOperationDetailsByIDResponse")
    @Action(input = "http://lab1_bank.polpetta.it/BankIFace/getOperationDetailsByIDRequest", output = "http://lab1_bank.polpetta.it/BankIFace/getOperationDetailsByIDResponse")
    public String getOperationDetailsByID(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
