package net.ramou.hospital.repositories;

import net.ramou.hospital.entities.Medecin;
import net.ramou.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);

}
