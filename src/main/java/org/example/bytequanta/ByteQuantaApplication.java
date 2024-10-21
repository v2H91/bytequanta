package org.example.bytequanta;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ByteQuantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByteQuantaApplication.class, args);
		log.info("this is a log");
	}

}
