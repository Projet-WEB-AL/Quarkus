package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.inject.Inject;
import java.util.Collections;

public class RmqConsumer {

    @Inject
    ReactiveMailer reactiveMailer;

    @Incoming("msg")
    public Uni<Void> consume(byte[] data) {
        String msg = new String(data);
        Log.info("Received data: " + msg);
        Mail mail = new Mail();
        mail.setFrom("test@gmail.com");
        mail.setSubject("Test");
        mail.setTo(Collections.singletonList("test@gmail.com"));
        mail.setText("je suis un test");
        return reactiveMailer.send(mail);
    }


}
