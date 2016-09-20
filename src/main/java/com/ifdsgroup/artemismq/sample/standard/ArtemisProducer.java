package com.ifdsgroup.artemismq.sample.standard;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

public class ArtemisProducer extends Producer {

	public ArtemisProducer() throws JMSException {
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
