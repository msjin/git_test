package com.activeMQtest;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.border.Border;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class Broker1 {

	public static void main(String[] args){
		Broker1 b=new Broker1();
		b.getBroker();
	}
	
	public void getBroker(){
		try {
			BrokerService borker=BrokerFactory.createBroker(new URI("xbean:src/activemq.xml"));
			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
