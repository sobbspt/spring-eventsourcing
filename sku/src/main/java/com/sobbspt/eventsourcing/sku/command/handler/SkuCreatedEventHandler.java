package com.sobbspt.eventsourcing.sku.command.handler;

import com.github.msemys.esjc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkuCreatedEventHandler implements VolatileSubscriptionListener {
    @Autowired
    EventStore eventStore;

    @Override
    public void onEvent(Subscription subscription, ResolvedEvent event) {
        System.out.println(event.originalEvent().eventNumber);
        System.out.println(new String(event.originalEvent().data));
        System.out.println(event.originalEvent().eventType);
        System.out.println("========================");

        // TODO :: save to persistence DB
    }

    @Override
    public void onClose(Subscription subscription, SubscriptionDropReason reason, Exception exception) {

    }
}
