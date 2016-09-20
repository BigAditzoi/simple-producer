package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

public class ArtemisConsumer extends Consumer {

	public ArtemisConsumer() throws JMSException {
		super();
	}
	
	@Override
	protected ConnectionFactory getConnectionFactory() {
		return ArtemisHelper.getConnectionFactory();
	}
	
	@Override
	protected Queue getQueue() {
		return ArtemisHelper.getQueue();
	}
}
