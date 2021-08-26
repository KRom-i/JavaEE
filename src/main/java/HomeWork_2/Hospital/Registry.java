package HomeWork_2.Hospital;

import HomeWork_2.Hospital.Doctors.Dentist;
import HomeWork_2.Hospital.Doctors.Surgeon;
import HomeWork_2.Hospital.Doctors.Therapist;
import HomeWork_2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Registry")
public class Registry {

    @Autowired
    private Therapist therapist;
    @Autowired
    private Surgeon surgeon;
    @Autowired
    private Dentist dentist;


    public void setPatient(Patient patient){

        System.out.println("Пациент попал в регистратуру");

        if (patient.getReferral() == null){
            System.out.println("В регистратуре выдано направление к терапевту");
            patient.setReferral(Referral.THERAPIST);
        }

        toTheDoctor(patient);
    }

    private void toTheDoctor (Patient patient) {

        switch (patient.getReferral()){
            case THERAPIST:
                System.out.println("Регистратура направила пациента к терапевту");
                therapist.setPatient(patient);
                break;
            case DENTIST:
                System.out.println("Регистратура направила пациента к стамотологу");
                dentist.setPatient(patient);
                break;
            case SURGEON:
                System.out.println("Регистратура направила пациента к хирургу");
                surgeon.setPatient(patient);
                break;
            case RECOMMENDATION:
                System.out.println("Пациент ушел с рекомендациями врача");
                break;

        }
    }


}
