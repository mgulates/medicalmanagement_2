package com.example.medicalmanagement.model;

import com.example.medicalmanagement.dtos.DoctorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String clinique;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public DoctorDTO viewAsDoctorDTO() {
        return new DoctorDTO(id, name, clinique);
    }

    public Doctor() {}

    public Doctor(long id, String name, String clinique) {
        this.id = id;
        this.name = name;
        this.clinique = clinique;
    }

    public Doctor(DoctorDTO doctorDTO) {
        this.id = doctorDTO.getId();
        this.name = doctorDTO.getName();
        this.clinique = doctorDTO.getClinique();
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClinique() {
        return clinique;
    }

    public void setClinique(String clinique) {
        this.clinique = clinique;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clinique='" + clinique + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}