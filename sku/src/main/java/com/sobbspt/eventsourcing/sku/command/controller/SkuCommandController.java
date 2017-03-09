package com.sobbspt.eventsourcing.sku.command.controller;

import com.github.msemys.esjc.EventData;
import com.github.msemys.esjc.EventStore;
import com.github.msemys.esjc.ExpectedVersion;
import com.google.gson.Gson;
import com.sobbspt.eventsourcing.sku.command.Model.ResponseModel;
import com.sobbspt.eventsourcing.sku.command.Model.SkuCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class SkuCommandController {

    @Autowired
    EventStore eventStore;

    @RequestMapping(value = "/sku", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<ResponseModel> createSku(
            @Valid @RequestBody SkuCreateRequest skuCreateRequest
            ) {

        eventStore.appendToStream("Create-SKU", ExpectedVersion.ANY, Arrays.asList(
                EventData.newBuilder()
                        .type("create-sku")
                        .jsonData(new Gson().toJson(skuCreateRequest))
                        .build())
        );
        return new ResponseModel("success", skuCreateRequest).build(HttpStatus.CREATED);
    }
}
