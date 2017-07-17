package com.lh.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMvcApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void MD5() {
		System.out.println(	new Md5PasswordEncoder().encodePassword("123", ""));
	}
}
