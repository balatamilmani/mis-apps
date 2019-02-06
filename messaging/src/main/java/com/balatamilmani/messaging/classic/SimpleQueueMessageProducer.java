package com.balatamilmani.messaging.classic;


import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SimpleQueueMessageProducer {

	public static void main(String[] args) {
		String messageBrokerUrl = "tcp://localhost:61616";
		String messageQueueName = "client.messages";
		ActiveMQConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		MessageProducer producer = null;
		TextMessage message = null;
		Destination adminQueue = null;
		try {
	            	connectionFactory = new ActiveMQConnectionFactory(messageBrokerUrl);
					connection = connectionFactory.createConnection();
					connection.start();
					//AUTO_ACKNOWLEDGE has no effect on a transacted session.
					//The send/receive operations on a Session are either acknowledged or transacted
		            //session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		            //The following Session is transacted
		            session = connection.createSession(true, Session.SESSION_TRANSACTED);
		            adminQueue = session.createQueue(messageQueueName);
		 
		            //Set up a producer
		            producer = session.createProducer(adminQueue);
		            //default delivery mode is persistent
		            //persistence flag is set on the MessageProducer for all messages
		            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		            producer.setPriority(9);
		            //producer.setTimeToLive(4000);
		            message = session.createTextMessage();
		            message.setText("Hello World");
		            //persistence can also be specified on a per message basis using the long form of the send method
		            producer.send(message);
		            //DEFAULT_DELIVERY_MODE->DeliveryMode.PERSISTENT
		            //producer.send(message, DeliveryMode.NON_PERSISTENT, Message.DEFAULT_DELIVERY_MODE, Message.DEFAULT_TIME_TO_LIVE);
		            System.out.println("sent");
		            //Could not be called if Session is not transacted
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
