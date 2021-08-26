package HomeWork_2.Hospital;

import HomeWork_2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Hospital")
public class Hospital {

    @Autowired
    private Registry registry;

    public Hospital () {
    }

    public void setPatient(Patient patient){
        System.out.println("Пациент зашел в больницу");
        registry.setPatient(patient);
    }


}
