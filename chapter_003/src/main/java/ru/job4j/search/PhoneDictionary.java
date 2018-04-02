package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 26.03.2018
 */

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (value.getName().contains(key) || value.getSurname().contains(key) || value.getPhone().contains(key) || value.getAddress().contains(key)) {
                result.add(value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Pupkin", "Puputich", "455678", "voroneg"));
        List<Person> people = phoneDictionary.find("455");
        System.out.println(people.get(0).getAddress());
    }
}