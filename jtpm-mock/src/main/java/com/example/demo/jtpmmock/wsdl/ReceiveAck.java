
package com.example.demo.jtpmmock.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="memberCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element ref="{http://tempuri.org/Services.asmx/getResponseFile}getFileResponse"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "memberCode",
    "getFileResponse"
})
@XmlRootElement(name = "ReceiveAck")
public class ReceiveAck {

    protected String memberCode;
    @XmlElement(namespace = "http://tempuri.org/Services.asmx/getResponseFile", required = true, nillable = true)
    protected CFileContent getFileResponse;

    /**
     * Gets the value of the memberCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * Sets the value of the memberCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberCode(String value) {
        this.memberCode = value;
    }

    /**
     * Gets the value of the getFileResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CFileContent }
     *     
     */
    public CFileContent getGetFileResponse() {
        return getFileResponse;
    }

    /**
     * Sets the value of the getFileResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFileContent }
     *     
     */
    public void setGetFileResponse(CFileContent value) {
        this.getFileResponse = value;
    }

}
