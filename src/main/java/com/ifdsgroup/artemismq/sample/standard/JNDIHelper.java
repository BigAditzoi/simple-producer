package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIHelper {

	private static final String CONNECTION_FACTORY_NAME = "ConnectionFactory";
	private static final String QUEUE_NAME = "queues/OrderQueue";

	private static Context context = null;
	
	private static synchronized Context getContext() throws NamingException {
		if (JNDIHelper.context == null) {
			JNDIHelper.context = new InitialContext();
		}
		return JNDIHelper.context;
	}
	
	public static ConnectionFactory getConnectionFactory() {
		ConnectionFactory factory = null;
		try {
			factory = (ConnectionFactory) getContext().lookup(CONNECTION_FACTORY_NAME);
		} catch (NamingException e) {
			System.err.println("Problem initializing the context or looking up the connection factory: " + e.getMessage());
			e.printStackTrace();
		}
		return factory;
	}
	
	public static Queue getQueue() {
		Queue queue = null;
		try {
			queue = (Queue) getContext().lookup(QUEUE_NAME);
		} catch (NamingException e) {
			System.err.println("Problem initializing the context or looking up the queue: " + e.getMessage());
			e.printStackTrace();
		}
		return queue;
	}
}
