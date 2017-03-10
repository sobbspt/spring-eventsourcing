package com.sobbspt.eventsourcing.sku.command.repository;

import com.sobbspt.eventsourcing.sku.command.entity.Sku;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SkuRepository extends PagingAndSortingRepository<Sku, String> {

}
