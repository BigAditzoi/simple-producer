package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

public class JNDIConsumer extends Consumer {

	public JNDIConsumer() throws JMSException {
		super();
	}
	
	@Override
	protected ConnectionFactory getConnectionFactory() {
		return JNDIHelper.getConnectionFactory();
	}

	@Override
	protected Queue getQueue() {
		return JNDIHelper.getQueue();
	}
}
