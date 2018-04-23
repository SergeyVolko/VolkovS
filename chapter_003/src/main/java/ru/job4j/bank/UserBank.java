package ru.job4j.bank;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 23.04.2018
 */
public class UserBank {
    private String name;
    private String passport;

    public UserBank(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserBank userBank = (UserBank) o;

        if (name != null ? !name.equals(userBank.name) : userBank.name != null) {
            return false;
        }
        return passport != null ? passport.equals(userBank.passport) : userBank.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserBank{" + "name='" + name + '\'' + ", passport='" + passport + '\'' + '}';
    }
}
