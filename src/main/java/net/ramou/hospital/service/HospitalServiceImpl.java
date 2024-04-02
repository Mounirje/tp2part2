package net.ramou.hospital.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.ramou.hospital.entities.Consultation;
import net.ramou.hospital.entities.Medecin;
import net.ramou.hospital.entities.Patient;
import net.ramou.hospital.entities.RendezVous;
import net.ramou.hospital.repositories.ConsultationRepository;
import net.ramou.hospital.repositories.MedcinRepository;
import net.ramou.hospital.repositories.PatientRepository;
import net.ramou.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional

public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedcinRepository medcinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedcinRepository medcinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medcinRepository = medcinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePAtient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedcin(Medecin medecin) {
        return medcinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
         rendezVous.setId(UUID.randomUUID().toString());
    return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultaion(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
