package com.example.demo.controller;

import com.example.demo.entity.Record;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    // Method to get all records and display them on the homepage
    @GetMapping("/")
    public String getAllRecords(Model model) {
        List<Record> records = recordService.getAllRecords();
        model.addAttribute("records", records);
        return "index"; // This will return the index.html
    }

    // Method to update the 'owned' field of a record
    @PostMapping("/updateOwned/{id}/{owned}")
    public String updateOwned(@PathVariable("id") int id, @PathVariable("owned") int owned) {
        recordService.updateOwned(id, owned);
        return "redirect:/"; // Redirect back to the homepage to refresh the data
    }
}
