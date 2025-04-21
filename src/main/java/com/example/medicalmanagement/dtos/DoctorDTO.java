package com.example.medicalmanagement.dtos;

public class DoctorDTO {
    private long id;
    private String name;
    private String clinique;

    public DoctorDTO(long id, String name, String clinique) {
        this.id = id;
        this.name = name;
        this.clinique = clinique;
    }

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
}