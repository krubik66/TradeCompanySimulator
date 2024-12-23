package com.example.demo.controller;

import com.example.demo.entity.Record;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private int displayNumber = 0;

    // Method to get all records and display them on the homepage
    @GetMapping("/")
    public String getAllRecords(Model model) {
        List<Record> records = recordService.getAllRecords();
        model.addAttribute("records", records);
        return "index"; // This will return the index.html
    }

    // Method to update the 'owned' field of a record
    @PostMapping("/updateOwned/{id}/{owned}")
    public ResponseEntity<Record> updateOwned(@PathVariable("id") int id, @PathVariable("owned") int owned) {
        Record record = recordService.updateOwned(id, owned);

        return new ResponseEntity<>(record, HttpStatus.OK); // Redirect back to the homepage to refresh the data
    }

    @PostMapping("/setDisplayNumber")
    public ResponseEntity<Integer> setDisplayNumber(int number, Model model) {
        this.displayNumber = number; // Update the number
        model.addAttribute("displayNumber", displayNumber);
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
