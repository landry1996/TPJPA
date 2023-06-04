package ma.enset.tpjpa.repositories;

import ma.enset.tpjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepositorie extends JpaRepository<Patient, Long> {
    public List<Patient> findBySick(boolean p);

}
