package ma.enset.tpjpa;

import ma.enset.tpjpa.entities.Patient;
import ma.enset.tpjpa.repositories.PatientRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
   private PatientRepositorie patientRepositorie;

    public TpJpaApplication(PatientRepositorie patientRepositorie) {
        this.patientRepositorie = patientRepositorie;
    }

//    public TpJpaApplication() {
//    }

    public static void main(String[] args) {

        SpringApplication.run(TpJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepositorie.save(new Patient(null,"Romeo",new Date(),2000,false));
        patientRepositorie.save(new Patient(null,"Peter",new Date(),5000,false));
        patientRepositorie.save(new Patient(null,"Charles",new Date(),500,true));
        patientRepositorie.save(new Patient(null,"TOTO",new Date(),100,true));

       System.out.println("----------------------------------------");
        patientRepositorie.findAll().forEach(pt->{
            System.out.println(pt.toString());
        });
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("Patient selon son Id");
        Patient patient=patientRepositorie.findById(3L).get();
        System.out.println(patient.getName()+" "+patient.isSick());


        System.out.println();
        System.out.println("******************************");
        List<Patient> patients=patientRepositorie.findBySick(false);
        patients.forEach(ptt->{
            System.out.println(ptt.getId()+" "+ptt.getName()+" "+ptt.isSick()+" "+ptt.getScore());

        });


    }
}
