package com.example.demo.controller;

import com.example.demo.model.SavingsGoal;
import com.example.demo.service.SavingsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/savings-goals")
public class SavingsGoalController {

    @Autowired
    private SavingsGoalService savingsGoalService;

    @PostMapping
    public ResponseEntity<SavingsGoal> createSavingsGoal(@RequestBody SavingsGoal savingsGoal) {
        SavingsGoal createdSavingsGoal = savingsGoalService.createSavingsGoal(savingsGoal);
        return new ResponseEntity<>(createdSavingsGoal, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsGoal> getSavingsGoalById(@PathVariable Long id) {
        Optional<SavingsGoal> savingsGoal = savingsGoalService.getSavingsGoalById(id);
        return savingsGoal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavingsGoal>> getSavingsGoalsByUserId(@PathVariable Long userId) {
        List<SavingsGoal> savingsGoals = savingsGoalService.getSavingsGoalsByUserId(userId);
        return new ResponseEntity<>(savingsGoals, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsGoal> updateSavingsGoal(@PathVariable Long id, @RequestBody SavingsGoal savingsGoal) {
        Optional<SavingsGoal> updatedSavingsGoal = Optional.ofNullable(savingsGoalService.updateSavingsGoal(id, savingsGoal));
        return updatedSavingsGoal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable Long id) {
        savingsGoalService.deleteSavingsGoal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}