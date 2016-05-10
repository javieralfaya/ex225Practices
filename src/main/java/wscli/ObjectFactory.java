
package wscli;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindUserByName_QNAME = new QName("http://ws/", "findUserByName");
    private final static QName _FindUserByNameResponse_QNAME = new QName("http://ws/", "findUserByNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindUserByNameResponse }
     * 
     */
    public FindUserByNameResponse createFindUserByNameResponse() {
        return new FindUserByNameResponse();
    }

    /**
     * Create an instance of {@link FindUserByName }
     * 
     */
    public FindUserByName createFindUserByName() {
        return new FindUserByName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findUserByName")
    public JAXBElement<FindUserByName> createFindUserByName(FindUserByName value) {
        return new JAXBElement<FindUserByName>(_FindUserByName_QNAME, FindUserByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findUserByNameResponse")
    public JAXBElement<FindUserByNameResponse> createFindUserByNameResponse(FindUserByNameResponse value) {
        return new JAXBElement<FindUserByNameResponse>(_FindUserByNameResponse_QNAME, FindUserByNameResponse.class, null, value);
    }

}
