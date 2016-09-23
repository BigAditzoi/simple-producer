package com.ifdsgroup.artemismq.sample.standard;

import org.apache.activemq.artemis.api.core.ActiveMQException;
import org.apache.activemq.artemis.api.core.SimpleString;
import org.apache.activemq.artemis.api.core.client.ClientConsumer;
import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.api.core.client.ClientSession;
import org.apache.activemq.artemis.api.core.client.ClientSession.QueueQuery;
import org.apache.activemq.artemis.api.core.client.ClientSessionFactory;
import org.apache.activemq.artemis.api.core.client.ServerLocator;

public class CoreConsumerDriver {

	private static final String ADDRESS_NAME = "jms.queue.OrderQueue";
	private static final String QUEUE_NAME = "jms.queue.OrderQueue";

	public static void main(String[] args) {
		
		try (ServerLocator locator = ArtemisHelper.getServerLocator();
			 ClientSessionFactory factory = locator.createSessionFactory(); 
			 ClientSession session = factory.createSession()) {
			
			QueueQuery query = session.queueQuery(new SimpleString(QUEUE_NAME));
			if (!query.isExists()) { 
				session.createQueue(ADDRESS_NAME, QUEUE_NAME, true);
			}
			
			ClientConsumer consumer = session.createConsumer(QUEUE_NAME);
			
			session.start();
			
			System.out.println("Core consumer waiting for message ...");
			ClientMessage message = consumer.receive();
			message.acknowledge();
			System.out.println("message = " + message.getBodyBuffer().readString());

			System.out.println("Core consumer done!");
		} catch (ActiveMQException e) {
			System.err.println("Problem with the session: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Problem creating the session factory: " + e.getMessage());
			e.printStackTrace();
		}	
	}
}
