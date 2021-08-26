package HomeWork_2;

import HomeWork_2.Hospital.Doctors.Symptom;
import HomeWork_2.Hospital.Hospital;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

//    Схема работы больницы

/* --- 1 ---
    У пациента Symptom:HEAD
    Пациент зашел в больницу
    Пациент попал в регистратуру
    В регистратуре выдано направление к терапевту
    Регистратура направила пациента к терапевту
    Пациент попал к терапевту
    Терапевт выписал рекомендации
    Терапевт направил пациента в регистратуру
    Пациент попал в регистратуру
    Пациент ушел с рекомендациями врача
 */

/* --- 2 ---
    У пациента Symptom:TOOTH
    Пациент зашел в больницу
    Пациент попал в регистратуру
    В регистратуре выдано направление к терапевту
    Регистратура направила пациента к терапевту
    Пациент попал к терапевту
    Терапевт выдал направление к стоматологу
    Терапевт направил пациента в регистратуру
    Пациент попал в регистратуру
    Регистратура направила пациента к стамотологу
    Пациент попал к стоматологу
    Стоматолог выписал рекомендации
    Стоматолог направил пациента в регистратуру
    Пациент попал в регистратуру
    Пациент ушел с рекомендациями врача
 */

/* --- 3 ---
    У пациента Symptom:JOINT
    Пациент зашел в больницу
    Пациент попал в регистратуру
    В регистратуре выдано направление к терапевту
    Регистратура направила пациента к терапевту
    Пациент попал к терапевту
    Терапевт выдал направление к хирургу
    Терапевт направил пациента в регистратуру
    Пациент попал в регистратуру
    Регистратура направила пациента к хирургу
    Пациент попал к хирургу
    Хирург выписал рекомендации
    Хирург направил пациента в регистратуру
    Пациент попал в регистратуру
    Пациент ушел с рекомендациями врача
     */


    public static void main (String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Patient patient = context.getBean("Patient", Patient.class);
        patient.setSymptom(Symptom.JOINT);

        Hospital hospital = context.getBean("Hospital", Hospital.class);
        hospital.setPatient(patient);

    }
}
