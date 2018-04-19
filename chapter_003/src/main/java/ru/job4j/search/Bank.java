package ru.job4j.search;
// Добавить комментарий.

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Bank {
    // Можно использовать, если в UserPerson реализован интерфейс Comparable и переопределены методы hashCode и equals
    // В обобщенных параметрах лучше изменить ArrayList на List
    // treemap лучше переименовать в treeMap
    // private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();
    private TreeMap<UserPerson, List<Account>> treeMap = new TreeMap<>();
    // Добавим коментарий к методу.

    /**
     * Данный метод добавляет в карту по ключу типа UserPerson пустой список.
     *
     * @param user
     */
    public void addUser(UserPerson user) {
        this.treeMap.put(user, new ArrayList<>());
    }
    // Добавим коментарий к методу.

    /**
     * Метод удоляет по ключу user список счетов
     *
     * @param user
     */
    public void delete(UserPerson user) {
        this.treeMap.remove(user);
    }
    // Добавим коментарий к методу.
    //Переименуем метод в addAccount т.к. мы добавляем определенному user новый счет account

    /**
     * Метод вызывает список по ключу user и добавляет в него новый счет.
     *
     * @param user
     * @param account
     */
    public void addAccount(UserPerson user, Account account) {
        this.treeMap.get(user).add(account);
    }

    // Добавим коментарий к методу.
    // Этот метод излишен. Его можно удалить.
    // Метод используется в методе transfer. Метод transfer можно реализовать без getActualAccount
    /*
        private Account getActualAccount(User user, Account account) {
            ArrayList<Account> list = this.treemap.get(user);
            return list.get(list.indexOf(account));
        }
     */
    // Добавим коментарий к методу.

    /**
     * Метод вызывает список счетов по ключу user и удаляет счет account.
     *
     * @param user
     * @param account
     */
    public void deleteAccount(UserPerson user, Account account) {
        this.treeMap.get(user).remove(account);
    }
    // Добавим коментарий к методу.

    /**
     * Метод возвращает список счетов пользователя user
     *
     * @param user
     * @return
     */
    public List<Account> getAccounts(UserPerson user) {
        return this.treeMap.get(user);
    }
    // Добавим коментарий к методу.
    // Вметоде transfer заменим getActualAccount на account1 и account2.
    // Этот метод может вызвать исключение если в treeMap нет ключа user1 или user2.

    /**
     * Метод переводит деньги  со счета account1 пользвателя user1 на счет account2 пользователю user2 в количестве
     * amount
     *
     * @param user1
     * @param account1
     * @param user2
     * @param account2
     * @param amount
     * @return
     */
    public boolean transfer(UserPerson user1, Account account1,
                            UserPerson user2, Account account2, double amount) {
        return this.treeMap.get(user1).contains(account1)
                && this.treeMap.get(user2).contains(account2)
                && account1.transfer(account2, amount);
    }

    @Override
    public String toString() {
        return "Bank{" + "accounts=" + treeMap + "}";
    }

}