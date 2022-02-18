/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.handlers;

import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author khushpreetkaurgulati
 */
public class MessageHandler2 implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
              try {
            SOAPMessage msg = messageContext.getMessage();
            Boolean outbound = (Boolean)messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

            
            if(!outbound)
            {
            SOAPBody body = msg.getSOAPBody();
            Node child = (Node) body.getFirstChild().getFirstChild();
            child.setTextContent(child.getTextContent() + " Inbound from Bye! ");
            msg.saveChanges();
            }  
        } catch (SOAPException ex) {
            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
          return true;
    }

  public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}

