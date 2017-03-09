package com.sobbspt.eventsourcing.sku.command.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Calendar;

@Data
public class SkuCreateRequest {

    @JsonProperty(value = "sku")
    private String sku;

    @JsonProperty(value = "created_at")
    @JsonFormat(shape=JsonFormat.Shape.NUMBER, pattern="s")
    private Calendar createdAt = Calendar.getInstance();

    @JsonProperty(value = "created_by")
    private String createdBy;
}
