package com.sobbspt.eventsourcing.sku.command.config;

import com.github.msemys.esjc.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventStoreConfig {

    @Bean
    public EventStore eventStore() {
        EventStore eventStore = EventStoreBuilder.newBuilder()
                .singleNodeAddress("127.0.0.1", 1113)
                .userCredentials("admin", "changeit")
                .build();
        eventStore.connect();
        return eventStore;
    }
}
