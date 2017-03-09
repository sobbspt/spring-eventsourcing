package com.sobbspt.eventsourcing.sku.command.event;

import lombok.Data;

import java.util.Calendar;

@Data
public class SkuCreatedEvent extends Event {
    private String sku;
    private Calendar createdAt;
    private String createdBy;
}
