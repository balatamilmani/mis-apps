package com.balatamilmani.messaging.classic;


import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SimpleQueueMessageConsumer {

	public static void main(String[] args) {
		String messageBrokerUrl = "tcp://localhost:61616";
		String messageQueueName = "client.messages";
		ActiveMQConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination adminQueue = null;
		MessageConsumer consumer = null;
	            try {
	            	connectionFactory = new ActiveMQConnectionFactory(messageBrokerUrl);
					connection = connectionFactory.createConnection();
					connection.start();
		            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		            adminQueue = session.createQueue(messageQueueName);
		 
		            //Set up a consumer to consume messages off of the admin queue
		            consumer = session.createConsumer(adminQueue);
		            Message message = consumer.receive();
		            
		            System.out.println(message.toString());
		            session.commit();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						connection.close();
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	            
}
}
