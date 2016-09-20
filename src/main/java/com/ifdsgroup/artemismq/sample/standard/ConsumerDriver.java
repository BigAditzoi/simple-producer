package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.JMSException;

public class ConsumerDriver {

	public static void main(String[] args) {
		try (Consumer consumer = new ArtemisConsumer()) {
			System.out.println("Got order: " + consumer.receive());
			System.out.println("Consumer done!");
		} catch (JMSException e) {
			System.err.println("Problem receiving a message from the broker: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
