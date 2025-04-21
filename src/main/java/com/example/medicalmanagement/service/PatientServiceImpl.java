package com.example.medicalmanagement.service;

import com.example.medicalmanagement.dtos.PatientDTO;
import com.example.medicalmanagement.model.Patient;
import com.example.medicalmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(Patient::viewAsPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.map(Patient::viewAsPatientDTO).orElse(null);
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return savedPatient.viewAsPatientDTO();
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setName(patientDTO.getName());
            patient.setAddress(patientDTO.getAddress());
            patient.setTelephone(patientDTO.getTelephone());

            Patient updatedPatient = patientRepository.save(patient);
            return new PatientDTO(updatedPatient.getId(), updatedPatient.getName(), updatedPatient.getAddress(), updatedPatient.getTelephone());
        }
        return null;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}