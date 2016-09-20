package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;

public abstract class Client implements AutoCloseable {

	protected JMSContext context;
	protected Queue queue;

	public Client() throws JMSException {
		context = getConnectionFactory().createContext(JMSContext.AUTO_ACKNOWLEDGE);
		queue = getQueue();
	}
	
	protected abstract ConnectionFactory getConnectionFactory();
	
	protected abstract Queue getQueue();
	
	public void close() throws JMSException {
		if (context != null) {
			context.close();
		}
	}
	
	protected void finalize() throws JMSException {
		close();
	}
}
