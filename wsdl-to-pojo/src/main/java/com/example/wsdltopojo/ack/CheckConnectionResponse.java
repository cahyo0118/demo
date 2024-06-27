
package com.example.wsdltopojo.ack;

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
 *         <element name="CheckConnectionResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "checkConnectionResult"
})
@XmlRootElement(name = "CheckConnectionResponse")
public class CheckConnectionResponse {

    @XmlElement(name = "CheckConnectionResult")
    protected int checkConnectionResult;

    /**
     * Gets the value of the checkConnectionResult property.
     * 
     */
    public int getCheckConnectionResult() {
        return checkConnectionResult;
    }

    /**
     * Sets the value of the checkConnectionResult property.
     * 
     */
    public void setCheckConnectionResult(int value) {
        this.checkConnectionResult = value;
    }

}
