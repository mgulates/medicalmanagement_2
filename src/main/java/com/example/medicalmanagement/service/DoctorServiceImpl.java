package com.example.medicalmanagement.service;

import com.example.medicalmanagement.dtos.DoctorDTO;
import com.example.medicalmanagement.model.Doctor;
import com.example.medicalmanagement.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(Doctor::viewAsDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.map(Doctor::viewAsDoctorDTO).orElse(null);
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return savedDoctor.viewAsDoctorDTO();
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setName(doctorDTO.getName());
            doctor.setClinique(doctorDTO.getClinique());

            Doctor updatedDoctor = doctorRepository.save(doctor);
            return updatedDoctor.viewAsDoctorDTO();
        }
        return null;
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}