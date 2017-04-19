package org.cloud.amqp.rabbit.server;

import org.cloud.amqp.rabbit.server.provider.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes =Application.class)
public class ApplicationTest{
	
	@Autowired
	private Provider provider;
	
	@Test
	public void test(){
		provider.send();
	}
}
