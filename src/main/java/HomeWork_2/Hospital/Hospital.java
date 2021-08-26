package HomeWork_2.Hospital;

import HomeWork_2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Hospital")
public class Hospital {

    private Registry registry;


    public Hospital () {
    }


    public Registry getRegistry () {
        return registry;
    }

    @Autowired
    public void setRegistry (Registry registry) {
        this.registry = registry;
    }

    public void setPatient(Patient patient){
        System.out.println("Пациент зашел в больницу");
        registry.setPatient(patient);
    }


}
