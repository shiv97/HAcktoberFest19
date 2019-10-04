package com.ftdc.controller;

import com.ftdc.model.PatientModel;
import com.ftdc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate postgresJdbcTemplate;

    @PostMapping("/insert_patient")
    public ResponseEntity<PatientModel> postPatient(@RequestBody PatientModel patientDetails){
        PatientModel res = patientRepository.save(patientDetails);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get_regions")
    public List<Map<String, Object>> getRegions(){
        String query = "Select * from region";
        List<Map<String,Object>> regions = postgresJdbcTemplate.queryForList(query);
        return regions;
    }
}
