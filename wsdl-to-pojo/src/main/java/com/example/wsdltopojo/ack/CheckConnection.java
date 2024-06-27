
package com.example.wsdltopojo.ack;

import jakarta.xml.bind.annotation.*;


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
    "memberCode"
})
@XmlRootElement(name = "CheckConnection", namespace = "http://service.ws.wsdltopojo.example.com/")
public class CheckConnection {

    @XmlElement(namespace = "http://service.ws.wsdltopojo.example.com/")
    protected String memberCode;

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

}
