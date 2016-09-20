package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.TextMessage;

public abstract class Consumer extends Client {

	private JMSConsumer consumer;

	public Consumer() throws JMSException {
		super();
		this.consumer = context.createConsumer(queue);
	}
	
	public String receive() throws JMSException {
		TextMessage textMessage = (TextMessage) consumer.receive();
		return textMessage.getText();
	}
}
