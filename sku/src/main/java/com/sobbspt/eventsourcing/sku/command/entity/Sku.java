package com.sobbspt.eventsourcing.sku.command.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "sku")
@NamedEntityGraph(name = "graph.Sku", attributeNodes = {})
@Data
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "sku")
    @Column(name = "sku")
    private String sku;

    @JsonProperty(value = "created_at")
    @Column(name = "created_at")
    private Calendar createdAt;

    @JsonProperty(value = "created_by")
    @Column(name = "created_by")
    private String createdBy;
}
