package org.cloud.user.server;

import org.cloud.user.server.dao.UserDao;
import org.cloud.user.server.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test(){
		User user=userDao.getById("1");
		System.out.println(user);
		/*user=new User();
		user.setName("userName0");
		user.setPassword("123456");
		userDao.save(user);*/
	}
}
