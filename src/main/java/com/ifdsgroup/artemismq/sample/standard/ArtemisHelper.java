package com.ifdsgroup.artemismq.sample.standard;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.apache.activemq.artemis.core.remoting.impl.netty.TransportConstants;

public class ArtemisHelper {

	private static final String HOST_NAME = "ifds4150";
	private static final String QUEUE_NAME = "OrderQueue";

	public static ConnectionFactory getConnectionFactory() {
		Map<String, Object> connectionParams = new HashMap<>();
		connectionParams.put(TransportConstants.HOST_PROP_NAME, HOST_NAME);
		TransportConfiguration transport = new TransportConfiguration(NettyConnectorFactory.class.getName(), connectionParams);
		return ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF, transport);
	}
	
	public static Queue getQueue() {
		return ActiveMQJMSClient.createQueue(QUEUE_NAME);
	}
}
