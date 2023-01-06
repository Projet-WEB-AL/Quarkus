package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class RabbitMQPriceConsumer {

    @Incoming("email")
    public void consume(String price) {
        System.out.println(price);
    }

}