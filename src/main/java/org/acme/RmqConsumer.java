package org.acme;

import com.oracle.svm.core.annotate.Inject;
import io.quarkus.logging.Log;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.eclipse.microprofile.reactive.messaging.Incoming;

public class RmqConsumer {

    @Inject
    Mailer mailer;

    @Incoming("msg")
    public void consume(String data) {
        Log.info("Received data: " + data);
        mailer.send(Mail.withText("maildevt3", "A simple email from quarkus", data));
    }
}
