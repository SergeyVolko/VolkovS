package ru.job4j.ext;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */

import org.junit.Test;
import ru.job4j.inheritance.*;
import static org.junit.Assert.assertArrayEquals;
public class ProfessionTest {
    @Test
    public void whenRunGetAgeThenArrayAge() {
       PeopleAndCar[] peopleAndCars = new PeopleAndCar[6];
       int[] getArrayAgeResult = new int[6];
       int[] getArrayAgeExcept = {20, 34, 10, 25, 35, 45};
       peopleAndCars[0] = new Student(20, "Иван", "ничего не знает");
       peopleAndCars[1] = new Patient(34, "Игорь", "болен");
       peopleAndCars[2] = new Car(10, "Toyota", "неисправна");
       peopleAndCars[3] = new Teacher(25, "Анатолий", "Педагогический ВУЗ");
       peopleAndCars[4] = new Doctor(35, "Денис", "Медицинский ВУЗ");
        peopleAndCars[5] = new Engineer(45, "Евгений", "Политехнический ВУЗ");
        for (int i = 0; i < peopleAndCars.length && i < getArrayAgeResult.length; i++) {
            getArrayAgeResult[i] = peopleAndCars[i].getAge();
        }
        assertArrayEquals(getArrayAgeExcept, getArrayAgeResult);
    }
    @Test
    public void whenRunGetNameThenArrayName() {
        PeopleAndCar[] peopleAndCars = new PeopleAndCar[6];
        String[] getArrayNameResult = new String[6];
        String[] getArrayNameExcept = {"Иван", "Игорь", "Toyota", "Анатолий", "Денис", "Евгений"};
        peopleAndCars[0] = new Student(20, "Иван", "ничего не знает");
        peopleAndCars[1] = new Patient(34, "Игорь", "болен");
        peopleAndCars[2] = new Car(10, "Toyota", "неисправна");
        peopleAndCars[3] = new Teacher(25, "Анатолий", "Педагогический ВУЗ");
        peopleAndCars[4] = new Doctor(35, "Денис", "Медицинский ВУЗ");
        peopleAndCars[5] = new Engineer(45, "Евгений", "Политехнический ВУЗ");
        for (int i = 0; i < peopleAndCars.length && i < getArrayNameResult.length; i++) {
            getArrayNameResult[i] = peopleAndCars[i].getName();
        }
        assertArrayEquals(getArrayNameExcept, getArrayNameResult);
    }
    @Test
    public void whenRunGetDiplomaThenArrayDiploma() {
        Profession[] professions = new Profession[3];
        String[] getArrayDiplomaResult = new String[3];
        String[] getArrayDiplomaExcept = {"Педагогический ВУЗ", "Медицинский ВУЗ", "Политехнический ВУЗ"};
        professions[0] = new Teacher(25, "Анатолий", "Педагогический ВУЗ");
        professions[1] = new Doctor(35, "Денис", "Медицинский ВУЗ");
        professions[2] = new Engineer(45, "Евгений", "Политехнический ВУЗ");
        for (int i = 0; i < professions.length && i < getArrayDiplomaResult.length; i++) {
            getArrayDiplomaResult[i] = professions[i].getDiploma();
        }
        assertArrayEquals(getArrayDiplomaExcept, getArrayDiplomaResult);
    }
    @Test
    public void whenRunGetTreatsOrRepairOrTeachThenArrayAction() {
        String[] getArrayActionProfResult = new String[3];
        String[] getArrayActionProExcept = {"Анатолий учит студента по имени Иван", "Доктор Денис лечит пациента Игорь",
                "Евгений чинит машину марки Toyota"};
        Teacher teacher = new Teacher(25, "Анатолий", "Педагогический ВУЗ");
        Doctor doctor = new Doctor(35, "Денис", "Медицинский ВУЗ");
        Engineer engineer = new Engineer(45, "Евгений", "Политехнический ВУЗ");
        Student student = new Student(20, "Иван", "ничего не знает");
        Patient patient = new Patient(34, "Игорь", "болен");
        Car car = new Car(10, "Toyota", "неисправна");
        getArrayActionProfResult[0] = teacher.teach(student);
        getArrayActionProfResult[1] = doctor.treats(patient);
        getArrayActionProfResult[2] = engineer.repair(car);
        assertArrayEquals(getArrayActionProExcept, getArrayActionProfResult);
    }
    @Test
    public void whenRunGetConditionBeforeThenArrayCondition() {
        String[] getArrayConditionResult = new String[3];
        String[] getArrayConditionExcept = {"ничего не знает", "болен", "неисправна"};
        Student student = new Student(20, "Иван", "ничего не знает");
        Patient patient = new Patient(34, "Игорь", "болен");
        Car car = new Car(15, "Toyota", "неисправна");
        getArrayConditionResult[0] = student.getCondition();
        getArrayConditionResult[1] = patient.getCondition();
        getArrayConditionResult[2] = car.getCondition();
        assertArrayEquals(getArrayConditionExcept, getArrayConditionResult);
    }
    @Test
    public void whenRunGetKnowledgeOrRecoverOrHealthThenArrayAction() {
        String[] getArrayActionPeopleOrCarfResult = new String[3];
        String[] getArrayActionPeopleOrCarExcept = {"Студент Иван учился у учителя по имени Анатолий и получил знания",
                "Пациент Игорь лечился у доктора по имени Денис и вылечился",
                "Машина марки Toyota ремонтировалась у инженера по имени Евгений и теперь она исправна"};
        Teacher teacher = new Teacher(25, "Анатолий", "Педагогический ВУЗ");
        Doctor doctor = new Doctor(35, "Денис", "Медицинский ВУЗ");
        Engineer engineer = new Engineer(45, "Евгений", "Политехнический ВУЗ");
        Student student = new Student(20, "Иван", "ничего не знает");
        Patient patient = new Patient(34, "Игорь", "болен");
        Car car = new Car(10, "Toyota", "неисправна");
        getArrayActionPeopleOrCarfResult[0] = student.knowledge(teacher);
        getArrayActionPeopleOrCarfResult[1] = patient.health(doctor);
        getArrayActionPeopleOrCarfResult[2] = car.recovery(engineer);
        assertArrayEquals(getArrayActionPeopleOrCarExcept, getArrayActionPeopleOrCarfResult);
    }
}
