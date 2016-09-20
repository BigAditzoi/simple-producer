package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.JMSException;

public class ProducerDriver {

	public static void main(String[] args) {
		try (Producer producer = new JNDIProducer()) {
			producer.send("This is an Artemis new order");
			System.out.println("Producer done!");
		} catch (JMSException e) {
			System.err.println("Problem sending a message to the broker: " + e.getMessage());
			e.printStackTrace();
		}	
	}
}
