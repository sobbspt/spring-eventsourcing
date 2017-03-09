package com.sobbspt.eventsourcing.sku.query.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkuQueryController {
    @RequestMapping(value = "/sku", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello";
    }
}
