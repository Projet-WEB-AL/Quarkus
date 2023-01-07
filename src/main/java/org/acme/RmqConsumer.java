package org.acme;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.reactive.messaging.Incoming;

public class RmqConsumer {

    @Incoming("my-queue")
    public void consume(String data) {
        Log.info("Received data: " + data);
    }
}
