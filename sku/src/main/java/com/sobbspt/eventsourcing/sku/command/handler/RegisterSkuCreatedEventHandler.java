package com.sobbspt.eventsourcing.sku.command.handler;

import com.github.msemys.esjc.*;
import com.google.gson.Gson;
import com.sobbspt.eventsourcing.sku.command.entity.Sku;
import com.sobbspt.eventsourcing.sku.command.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RegisterSkuCreatedEventHandler {

    @Autowired
    EventStore eventStore;

    @Autowired
    SkuRepository skuRepository;

    @PostConstruct
    public void register() {
        eventStore.subscribeToStream("Create-SKU", false, new VolatileSubscriptionListener() {
            @Override
            public void onEvent(Subscription subscription, ResolvedEvent event) {
                Sku sku = new Gson().fromJson(new String(event.originalEvent().data), Sku.class);
                skuRepository.save(sku);
            }

            @Override
            public void onClose(Subscription subscription, SubscriptionDropReason reason, Exception exception) {
                System.out.println("Subscription closed: " + reason);
            }
        });
    }
}
