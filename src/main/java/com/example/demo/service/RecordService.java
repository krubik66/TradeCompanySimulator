package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    // Method to fetch all records from the database
    public List<Record> getAllRecords() {
        return recordRepository.findAll(); // Get all records from the database
    }

    // Method to update the 'owned' field of a specific record
    public Record updateOwned(int id, int howMuch, int balance) {
        Record record = recordRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
        record.buySome(howMuch); // Update the owned field
        recordRepository.save(record); // Save the updated record back to the database
        return record;
    }
}
