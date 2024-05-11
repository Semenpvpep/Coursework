package com.tsaplev.backend.controllers;

import com.tsaplev.backend.repositories.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tsaplev.backend.entities.Barber;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/barbers")
public class BarberController {

    @Autowired
    private BarberRepository barberRepository;

    // CREATE operation
    @PostMapping
    public ResponseEntity<Barber> createBarber(@RequestBody Barber barber) {
        Barber savedBarber = barberRepository.save(barber);
        return new ResponseEntity<>(savedBarber, HttpStatus.CREATED);
    }

    // READ operation
    @GetMapping
    public ResponseEntity<List<Barber>> getAllBarbers(@RequestParam Map<String, String> queryParameters) {
        List<Barber> barbers;
        if (!queryParameters.containsKey("depId")) {
            barbers = barberRepository.findAll();
        } else {
            Long depId = Long.parseLong(queryParameters.get("depId"));
            barbers = barberRepository.findAllByDepartmentId(depId);
        }
        return new ResponseEntity<>(barbers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getBarberById(@PathVariable Long id) {
        Optional<Barber> barber = barberRepository.findById(id);
        if (barber.isPresent()) {
            return new ResponseEntity<>(barber.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable Long id) {
        Optional<Barber> barber = barberRepository.findById(id);
        if (barber.isPresent()) {
            barberRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

