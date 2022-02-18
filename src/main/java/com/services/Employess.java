/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author khushpreetkaurgulati
 */
@WebService
@HandlerChain(file = "EmployessService_handler.xml")
public class Employess {
    @WebMethod
    public String getWelcome(String name)
    {
        return "Welcome to Week 5 , " + name;
    }
    
}
