package com.sobbspt.eventsourcing.sku.command.event;

import lombok.Data;

@Data
public abstract class Event {
    Integer eventId;
}