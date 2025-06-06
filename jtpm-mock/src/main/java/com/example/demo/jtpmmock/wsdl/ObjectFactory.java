
package com.example.demo.jtpmmock.wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.demo.jtpmmock.wsdl package. 
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

    private static final QName _GetFileResponse_QNAME = new QName("http://tempuri.org/Services.asmx/getResponseFile", "getFileResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.demo.jtpmmock.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckConnection }
     * 
     * @return
     *     the new instance of {@link CheckConnection }
     */
    public CheckConnection createCheckConnection() {
        return new CheckConnection();
    }

    /**
     * Create an instance of {@link CheckConnectionResponse }
     * 
     * @return
     *     the new instance of {@link CheckConnectionResponse }
     */
    public CheckConnectionResponse createCheckConnectionResponse() {
        return new CheckConnectionResponse();
    }

    /**
     * Create an instance of {@link ReceiveAck }
     * 
     * @return
     *     the new instance of {@link ReceiveAck }
     */
    public ReceiveAck createReceiveAck() {
        return new ReceiveAck();
    }

    /**
     * Create an instance of {@link CFileContent }
     * 
     * @return
     *     the new instance of {@link CFileContent }
     */
    public CFileContent createCFileContent() {
        return new CFileContent();
    }

    /**
     * Create an instance of {@link ReceiveAckResponse }
     * 
     * @return
     *     the new instance of {@link ReceiveAckResponse }
     */
    public ReceiveAckResponse createReceiveAckResponse() {
        return new ReceiveAckResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CFileContent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CFileContent }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/Services.asmx/getResponseFile", name = "getFileResponse")
    public JAXBElement<CFileContent> createGetFileResponse(CFileContent value) {
        return new JAXBElement<>(_GetFileResponse_QNAME, CFileContent.class, null, value);
    }

}
