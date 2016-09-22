package com.ifdsgroup.artemismq.sample.standard;

import org.apache.activemq.artemis.api.core.ActiveMQException;
import org.apache.activemq.artemis.api.core.client.ClientConsumer;
import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.api.core.client.ClientSession;
import org.apache.activemq.artemis.api.core.client.ClientSessionFactory;
import org.apache.activemq.artemis.api.core.client.ServerLocator;

public class CoreConsumerDriver {

	private static final String ADDRESS_NAME = "jms.queue.queues/OrderQueue";
	private static final String QUEUE_NAME = "jms.queue.queues/OrderQueue";

	public static void main(String[] args) {
		
		ServerLocator locator = ArtemisHelper.getServerLocator();
		
		try (ClientSessionFactory factory = locator.createSessionFactory(); 
			 ClientSession session = factory.createSession()) {
			
			session.createQueue(ADDRESS_NAME, QUEUE_NAME, true);
			
			ClientConsumer consumer = session.createConsumer(QUEUE_NAME);
			
			session.start();
			
			ClientMessage message = consumer.receive();
			System.out.println("message = " + message.getBodyBuffer().readString());

			locator.close();
			System.out.println("Consumer done!");
		} catch (ActiveMQException e) {
			System.err.println("Problem with the session: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Problem creating the session factory: " + e.getMessage());
			e.printStackTrace();
		}	
	}
}
