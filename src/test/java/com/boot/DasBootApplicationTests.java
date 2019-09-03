package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DasBootApplicationTests {

	@Test
	public void contextLoads() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Das boot, application pluralsight");
	}

}
