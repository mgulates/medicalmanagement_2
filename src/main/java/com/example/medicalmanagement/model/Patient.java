package com.example.medicalmanagement.model;

import com.example.medicalmanagement.dtos.PatientDTO;
import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String telephone;

    public Patient() {}

    public Patient(Long id, String name, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public Patient(PatientDTO patientDTO) {
        this.id = patientDTO.getId();
        this.name = patientDTO.getName();
        this.address = patientDTO.getAddress();
        this.telephone = patientDTO.getTelephone();
    }

    public PatientDTO viewAsPatientDTO() {
        return new PatientDTO(id, name, address, telephone);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
}