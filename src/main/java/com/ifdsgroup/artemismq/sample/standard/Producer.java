package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;

public abstract class Producer extends Client {

	private JMSProducer producer;
	
	public Producer() throws JMSException {
		super();
		this.producer = context.createProducer();
	}
	
	public void send(String message) throws JMSException {
		TextMessage textMessage = context.createTextMessage(message);
		producer.send(queue, textMessage);
	}
}
