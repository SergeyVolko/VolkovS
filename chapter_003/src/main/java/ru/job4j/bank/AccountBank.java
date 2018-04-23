package ru.job4j.bank;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 23.04.2018
 */
public class AccountBank {
    private String requisites;
    private double value;

    public AccountBank(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    /**
     * Метод отвечает за перевод денег в количестве amount с текущего счета на сторонний счет.
     *
     * @param accountBank - сторонний счет на который переводятся деньги
     * @param amount      - сумма перевода
     * @return - возвращает true, если перевод состоялся, иначе false.
     */
    public boolean transfer(AccountBank accountBank, double amount) {
        boolean flag = false;
        if (accountBank != null && amount > 0 && this.value >= amount) {
            accountBank.value += amount;
            this.value -= amount;
            flag = true;
        }
        return flag;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccountBank that = (AccountBank) o;

        if (Double.compare(that.value, value) != 0) {
            return false;
        }
        return requisites != null ? requisites.equals(that.requisites) : that.requisites == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = requisites != null ? requisites.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AccountBank{" + "requisites='" + requisites + '\'' + ", value=" + value + '}';
    }
}
