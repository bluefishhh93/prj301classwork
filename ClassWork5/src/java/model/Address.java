/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuant
 */
public class Address {
    private String streetAddress;
    private String zipCode;

    public Address() {
    }

    public Address(String streetAddress, String zipCode) {
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" + "streetAddress=" + streetAddress + ", zipCode=" + zipCode + '}';
    }
    
    
}
