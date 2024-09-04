
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
 *         <element name="ReceiveAckResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "receiveAckResult"
})
@XmlRootElement(name = "ReceiveAckResponse")
public class ReceiveAckResponse {

    @XmlElement(name = "ReceiveAckResult")
    protected int receiveAckResult;

    /**
     * Gets the value of the receiveAckResult property.
     * 
     */
    public int getReceiveAckResult() {
        return receiveAckResult;
    }

    /**
     * Sets the value of the receiveAckResult property.
     * 
     */
    public void setReceiveAckResult(int value) {
        this.receiveAckResult = value;
    }

}
