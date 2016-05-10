package wscli;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.14.redhat-1
 * 2016-05-05T12:12:43.523+02:00
 * Generated source version: 2.7.14.redhat-1
 * 
 */
@WebService(targetNamespace = "http://ws/", name = "FindUser")
@XmlSeeAlso({ObjectFactory.class})
public interface FindUser {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findUserByName", targetNamespace = "http://ws/", className = "ws.FindUserByName")
    @WebMethod
    @ResponseWrapper(localName = "findUserByNameResponse", targetNamespace = "http://ws/", className = "ws.FindUserByNameResponse")
    public java.lang.String findUserByName(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username
    );
}