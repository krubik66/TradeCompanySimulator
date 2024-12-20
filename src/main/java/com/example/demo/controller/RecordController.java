package com.example.demo.controller;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Record> records = recordRepository.findAll();
        model.addAttribute("records", records);
        return "index";
    }
}
