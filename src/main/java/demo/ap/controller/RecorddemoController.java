package demo.ap.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.ap.service.RecorddemoService;

@RestController
@RequestMapping("/apii")
public class RecorddemoController {

    @Autowired
    private RecorddemoService service;

    @GetMapping("/records")
    public Map<String, Object> getRecords() {
        return service.getNestedData();
    }
}