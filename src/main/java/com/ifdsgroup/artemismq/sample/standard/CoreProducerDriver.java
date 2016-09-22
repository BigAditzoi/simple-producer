package com.ifdsgroup.artemismq.sample.standard;

import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.api.core.client.ClientProducer;
import org.apache.activemq.artemis.api.core.client.ClientSession;
import org.apache.activemq.artemis.api.core.client.ClientSessionFactory;
import org.apache.activemq.artemis.api.core.client.ServerLocator;

public class CoreProducerDriver {

	private static final String ADDRESS_NAME = "jms.queue.queues/OrderQueue";

	public static void main(String[] args) {
		
		try (ServerLocator locator = ArtemisHelper.getServerLocator();
			 ClientSessionFactory factory = locator.createSessionFactory();
			 ClientSession session = factory.createSession()) {
			
			ClientProducer producer = session.createProducer(ADDRESS_NAME);
			ClientMessage message = session.createMessage(true);
			
			message.getBodyBuffer().writeString("Fifth core messsage");
			producer.send(message);

			System.out.println("Producer done!");
		} catch (Exception e) {
			System.err.println("Problem creating the session factory: " + e.getMessage());
			e.printStackTrace();
		}	
	}
}
