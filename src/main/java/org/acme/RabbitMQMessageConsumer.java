package org.acme;

import org.eclipse.microprofile.reactive.messaging.Incoming;

public class RabbitMQMessageConsumer {

    @Incoming("my-queue")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}

