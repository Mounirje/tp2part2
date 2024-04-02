package net.ramou.hospital.repositories;

import net.ramou.hospital.entities.Patient;
import net.ramou.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
