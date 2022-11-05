# JAVA - Messaging with RabbitMQ in Spring Boot Application


<p>In this article, we will learn about RabbitMQ and explore its common use-cases. We will also walk through a step-by-step guide to implement messaging using RabbitMQ in a Spring Boot Application.</p>
 
<p>Description </p>
<p>I'm using this example to demonstrate a microservice that takes all the files from a folder, converts it into an object and then sends it to the message and then I could create a method to get and save it in a database on another server... whatever.. .
</p>
  
<ul>  
  
<li>Message: A message is a form of data that is shared from the producer to the consumer. The data can hold requests, information, meta-data, etc.</li>
<li>Producer: A producer is a user program that is responsible to send or produce messages.</li>
<li>Exchange: Exchanges are message routing agents, it is responsible to route the messages to different queues with the help of header attributes, bindings, and routing keys. Binding is the link between a queue and the exchange. Whereas, the R outing K ey is the address that the exchange uses to determine which queue the message should be sent to.</li>
<li>Queue: A queue is a mailbox or a buffer that stores messages. It has certain limitations like disk space and memory.</li>
<li>Consumer: A consumer is a user program that is responsible to receive messages.  </li>
  
</ul>
<p>I'm working on these examples continually check back often...</p>
</br>
</br>
<p>Following images of the examples:</p>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0000.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br> 
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq000000.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0001.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0002.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0003.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0004.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0005.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>
 <img src="https://github.com/sovanderlei/rabbitMQJ/blob/main/src/main/webapp/imagens/rabbitmq0006.png" style="width:800px;height:600px;" 
alt="Minha Figura">
</br>  
