package HomeWork_2;

import HomeWork_2.Hospital.Doctors.Symptom;
import HomeWork_2.Hospital.Referral;
import org.springframework.stereotype.Component;


@Component("Patient")
public class Patient {

    private Symptom symptom;
    private Referral referral;

    public Referral getReferral () {
        return referral;
    }

    public void setReferral (Referral referral) {
        this.referral = referral;
    }

    public Symptom getSymptom () {
        return symptom;
    }

    public void setSymptom (Symptom symptom) {
        System.out.println("У пациента Symptom:" + symptom.name());
        this.symptom = symptom;
    }
}
