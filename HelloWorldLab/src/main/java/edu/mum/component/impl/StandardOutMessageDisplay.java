package edu.mum.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.component.MessageDisplay;
import edu.mum.component.MessageOrigin;

@Component(value = StandardOutMessageDisplay.BEAN_NAME)
public class StandardOutMessageDisplay implements MessageDisplay {

    public static final String BEAN_NAME = "StandardOutMessage";

	@Autowired
	private MessageOrigin messageSource;

    
    public void display() {
        if (messageSource == null) {
            throw new RuntimeException(
                "You must set the property messageSource of class:"
                + StandardOutMessageDisplay.class.getName());
        }

        System.out.println(messageSource.getMessage());
    }

     public MessageOrigin getMessageSource() {
        return this.messageSource;
    }
}
