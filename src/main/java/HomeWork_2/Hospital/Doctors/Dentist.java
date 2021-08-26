package HomeWork_2.Hospital.Doctors;

import HomeWork_2.Hospital.Referral;
import HomeWork_2.Hospital.Registry;
import HomeWork_2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Dentist")
public class Dentist implements Doctor{

    @Autowired
    private Registry registry;

    @Override
    public void setPatient (Patient patient) {

        System.out.println("Пациент попал к стоматологу");

        System.out.println("Стоматолог выписал рекомендации");
        patient.setReferral(Referral.RECOMMENDATION);

        System.out.println("Стоматолог направил пациента в регистратуру");
        registry.setPatient(patient);

    }
}
