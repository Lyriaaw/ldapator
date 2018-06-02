package com.isep.ldapator;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class LdapatorApplication {

	public static void main(String[] args) {
//		for (byte current_byte : DigestUtils.md5("yes")) {
//			System.out.printf(String.valueOf((char) current_byte));
//		}

		SpringApplication.run(LdapatorApplication.class, args);
	}
}
