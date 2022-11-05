package com.ms.rabbitMQJ.service;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Connection; 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson; 
import com.rabbitmq.client.AMQP; 
import com.rabbitmq.client.Channel;    
import com.rabbitmq.client.Envelope; 
   
public class RabbitMQSendmsn {

	  private final static String QUEUE_NAME = "hello";
	  private final static String HOST = "localhost";
	  private final static String USERNAME = "guest";
	  private final static String PASSWORD = "guest";
	  private final static Integer PORT =  5672;
	  private static final String EXCHANGE_NAME = "hello";
	
	  public static void main(String[] argv) throws Exception {
		     
	  }
	
	  public static void Sendermsn(String messageSend)  {
		  
		    //System.out.println("Sendermsn bloco: 00010 ");
		    
		  	ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost(HOST); 
	        factory.setPort(PORT);
	        factory.setUsername(USERNAME);
	        factory.setPassword(PASSWORD);
	        factory.setConnectionTimeout(6000); // in milliseconds
	        //factory.setSsl(true);
	        //factory.setPemKeyCertOptions(keycert);
	        //factory.setPemTrustOptions(trust);
	        //factory.setUser("user1");  
	        //factory.setVirtualHost("vhost1"); 
	        //factory.setRequestedHeartbeat(60); // in seconds
	        //factory.setHandshakeTimeout(6000); // in milliseconds
	        //factory.setRequestedChannelMax(5);
	        //factory.setNetworkRecoveryInterval(500); // in milliseconds
	        //factory.setAutomaticRecoveryEnabled(true);
	        
	        try (
	        	
	        	Connection connection = factory.newConnection();
	            Channel channel = connection.createChannel()) {
	        	channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
	            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	            String message = messageSend;
	            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
	            //System.out.println(" [x] Sent '" + message + "'");
  
			} catch (IOException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
	        
	  }
	
	  public static ArrayList<String> GetMessage()  {
		  
		    //System.out.println("GetMessage bloco: 00010 ");
		  	ArrayList<String> listRetorn = new ArrayList<String>();
		  
		    ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost(HOST); 
	        factory.setPort(PORT);
	        factory.setUsername(USERNAME);
	        factory.setPassword(PASSWORD); 
	        factory.setConnectionTimeout(6000); 
	        //factory.setAutomaticRecoveryEnabled(true); 
    	     
    	    Connection connection = null;
			try {
					connection = factory.newConnection();
				    Channel channel = null;
					channel = connection.createChannel();
					channel.queueDeclare(QUEUE_NAME, false, false, false, null); 
					//if (channel.isOpen())
				  
	        	    Consumer consumer = new DefaultConsumer(channel) {
		        	    @Override
		        	    public void handleDelivery(String consumerTag, Envelope envelope,
		        	                             AMQP.BasicProperties properties, byte[] body)
		        	      throws IOException {
		        	    		String message = new String(body, "UTF-8");
		        	    		listRetorn.add(message);
		        	    		//System.out.println(" [x] Received '" + message + "'");
		        	    }
	        	    };
	        
					channel.basicConsume(QUEUE_NAME, true, consumer);
				} catch (IOException | TimeoutException e) {
					 
					e.printStackTrace();
				}
	    
	        return listRetorn;
	        
	  }
	  
	  
	  public static void sendJsonObject(Object obj) {
		  
		  //System.out.println("sendJsonObject bloco: 00010 ");
		  
		  Gson gson = new Gson();
		  String msnJson = gson.toJson(obj); 
		  Sendermsn(msnJson);
		    
	  }
	  
	  
	  
	

}
