package ru.job4j.search;

// Добавить комментарий.
public class Account {
    // В классе Account поля должны быть приватными.
    private double values;
    //Поле reqs лучше переименовать в requisites
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return this.values;
    }

    // Название метода getReqs исправить на getRequisites
    public String getRequisites() {
        return this.requisites;
    }
    // Необходимо добавить комментарий к данному методу

    /**
     * Данный метод снимает деньги в количестве amount с текущего счета, уменеьшая его баланс values на amount и
     * переводит их на счет destination, увеличивая  баланса   destination.values на amount.
     * Если снять деньги возможно то метод вернет значение true, иначе false
     *
     * @param destination
     * @param amount
     * @return
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        /*
        Условие записано не правильно. Выражение destination != null нужно поставить в начало, т. к. при проверке
        условия может упасть ошибка.
         */
        if (destination != null && amount > 0 && amount < this.values) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    // Данный метод можно упростить.
    @Override
    public String toString() {
        return String.format("Account{values = %s requisites=%s \\}", this.values, this.requisites);
    }
    //При переопределении equals и hashCode нужно добавить аннотацию @Override

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.values, values) != 0) {
            return false;
        }
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    // Для большей уникальности hashCode нужно переопределить следующим образом.
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(values);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }


   /*
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
    */
}
