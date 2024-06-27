
package com.example.wsdltopojo.ack;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFileContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="CFileContent">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fileContents" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         <element name="sizeInBytes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="crc32" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFileContent", namespace = "http://tempuri.org/Services.asmx/getResponseFile", propOrder = {
    "fileContents",
    "sizeInBytes",
    "crc32"
})
public class CFileContent {

    protected byte[] fileContents;
    protected int sizeInBytes;
    protected int crc32;

    /**
     * Gets the value of the fileContents property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileContents() {
        return fileContents;
    }

    /**
     * Sets the value of the fileContents property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileContents(byte[] value) {
        this.fileContents = value;
    }

    /**
     * Gets the value of the sizeInBytes property.
     * 
     */
    public int getSizeInBytes() {
        return sizeInBytes;
    }

    /**
     * Sets the value of the sizeInBytes property.
     * 
     */
    public void setSizeInBytes(int value) {
        this.sizeInBytes = value;
    }

    /**
     * Gets the value of the crc32 property.
     * 
     */
    public int getCrc32() {
        return crc32;
    }

    /**
     * Sets the value of the crc32 property.
     * 
     */
    public void setCrc32(int value) {
        this.crc32 = value;
    }

}
