package net.ramou.hospital.repositories;

import net.ramou.hospital.entities.Consultation;
import net.ramou.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
