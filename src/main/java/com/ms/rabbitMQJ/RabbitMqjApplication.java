package com.ms.rabbitMQJ;
 
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ms.rabbitMQJ.controller.RabbitmqController;


@EnableRabbit 
@SpringBootApplication
public class RabbitMqjApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqjApplication.class, args);
		
		RabbitmqController controller = new RabbitmqController();
		controller.MonitoringSendMessageRabbitMQ();
		// controller.MonitoringGetMessageRabbitMQ();
		
	}

}
