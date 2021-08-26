package HomeWork_2.Hospital.Doctors;

import HomeWork_2.Hospital.Referral;
import HomeWork_2.Hospital.Registry;
import HomeWork_2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Surgeon")
public class Surgeon implements Doctor{

    @Autowired
    private Registry registry;

    @Override
    public void setPatient (Patient patient) {

        System.out.println("Пациент попал к хирургу");

        System.out.println("Хирург выписал рекомендации");
        patient.setReferral(Referral.RECOMMENDATION);

        System.out.println("Хирург направил пациента в регистратуру");
        registry.setPatient(patient);

    }
}
