package com.keyin.service;

import com.keyin.model.TreeRecord;
import com.keyin.repository.TreeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeService {
    @Autowired
    private TreeRecordRepository repository;

    public TreeRecord saveTree(String inputNumbers, String treeJson) {
        TreeRecord record = new TreeRecord();
        record.setInputNumbers(inputNumbers);
        record.setTreeStructure(treeJson);
        return repository.save(record);
    }

    public Iterable<TreeRecord> getAllTrees() {
        return repository.findAll();
    }
}