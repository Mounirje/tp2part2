package net.ramou.hospital.service;

import net.ramou.hospital.entities.Consultation;
import net.ramou.hospital.entities.Medecin;
import net.ramou.hospital.entities.Patient;
import net.ramou.hospital.entities.RendezVous;


public interface IHospitalService  {
    Patient savePAtient(Patient patient);
    Medecin saveMedcin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultaion(Consultation consultation);


}
