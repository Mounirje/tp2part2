package net.ramou.hospital;

import net.ramou.hospital.entities.*;
import net.ramou.hospital.repositories.MedcinRepository;
import net.ramou.hospital.repositories.PatientRepository;
import net.ramou.hospital.repositories.RendezVousRepository;
import net.ramou.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
 @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, MedcinRepository  medcinRepository)

    {
     return args -> {
         Stream.of("Mohammed", "hassan", "Najat")
                 .forEach(name ->{
                     Patient patient = new Patient();
                     patient.setNom(name);
                     patient.setDateNaissance(new Date());
                     patient.setMalade(false);
                     patientRepository.save(patient);
                 });
         Stream.of("Aymane", "Nanane", "Najat")
                 .forEach(name ->{
                     Medecin medecin = new Medecin();
                     medecin.setNom(name);
                     medecin.setEmail(name+"@gmail.com");
                     medecin.setSpecialite(Math.random()>0.5?"cardio":"Dentiste ");
                     hospitalService.saveMedcin(medecin);
                 });
         Patient patient=patientRepository.findById(1L).orElse(null);
         Patient patient1=patientRepository.findByNom("Mohamed");
         Medecin medecin=medcinRepository.findByNom("Najat");
         RendezVous rendezVous=new RendezVous();
         rendezVous.setDate(new Date());
         rendezVous.setStatus(StatusRDv.PENDING);
         rendezVous.setMedecin(medecin);
         rendezVous.setPatient(patient);
         hospitalService.saveRDV( rendezVous);
         RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
         Consultation consultation= new Consultation();
         consultation.setDateConsultation(new Date());
         consultation.setRendezVous(rendezVous1);
         consultation.setRapport("Rapport de Consultation");
         hospitalService.saveConsultaion(consultation);




     };
 }}
