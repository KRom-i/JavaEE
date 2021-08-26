package HomeWork_2.Hospital.Doctors;

import HomeWork_2.Hospital.Referral;
import HomeWork_2.Hospital.Registry;
import HomeWork_2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Therapist")
public class Therapist implements Doctor {

    @Autowired
    private Registry registry;

    @Override
    public void setPatient (Patient patient) {

        System.out.println("Пациент попал к терапевту");

        switch (patient.getSymptom()){

            case HEAD:
                System.out.println("Терапевт выписал рекомендации");
                patient.setReferral(Referral.RECOMMENDATION);
                break;
            case TOOTH:
                System.out.println("Терапевт выдал направление к стоматологу");
                patient.setReferral(Referral.DENTIST);
                break;
            case JOINT:
                System.out.println("Терапевт выдал направление к хирургу");
                patient.setReferral(Referral.SURGEON);
                break;
        }

        System.out.println("Терапевт направил пациента в регистратуру");
        registry.setPatient(patient);

    }



}
