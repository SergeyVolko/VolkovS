package ru.job4j.bank;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 23.04.2018
 */

import java.util.*;

public class NewBank {
    // Сразу инициализируем карту.
    private Map<UserBank, List<AccountBank>> map = new HashMap<>();

    /**
     * Это вспомогательный метод отыскивающий пользователя по паспорту.
     * Производится переборка всех пользователей в коллекции ключей this.map.keySet()
     *
     * @param passport - передаваемый параметр типа String, сравниваемый через equals с полем passport класса UserBank
     * @return - возвращает null если ключ не найден, иначе ключ коллекции map.
     */
    private UserBank userKey(String passport) {
        UserBank user = null;
        if (passport != null) {
            for (UserBank userBank : this.map.keySet()) {
                if (userBank.getPassport().equals(passport)) {
                    user = userBank;
                }
            }
        }
        return user;
    }

    /**
     * Это вспомогательный метод, возвращающий счет пользователя.
     *
     * @param requisite - реквезиты по которым нужно найти счет.
     * @param userBank  - пользователь, счет которого нужно получить.
     * @return - возвращает null, если в коллекции this.map.get(userBank) нет счета account по реквизитам requisite
     */
    private AccountBank searchAccount(String requisite, UserBank userBank) {
        AccountBank account = null;
        for (AccountBank accountBank : this.map.get(userBank)) {
            if (accountBank.getRequisites().equals(requisite)) {
                account = accountBank;
            }
        }
        return account;
    }

    /**
     * Метод, добавляющий в карту map пользователя с пустым счетом.
     * В методе putIfAbsent проверяется наличие в карте map по ключу user ссылки на счет, если ссылка равнв null, то
     * добавляется по ключу новый счет.
     * Если бы мы использовали для добавления в карту метод put, то у нас была бы вероятность потери данных о счете
     * пользователя при вводе его повторно, т. к. счет по данному ключу перезапишется на пустой. С использованием
     * метода putIfAbsent не происходит перезаписывания счета по ключу user.
     *
     * @param user - пользователь с пустым счетом, которого нужно ввести в карту.
     */
    public void addUser(UserBank user) {
        this.map.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляющий счет account и пользователя user.
     *
     * @param user - пользователь, счет которого нужно удалить и его самого.
     */
    public void deleteUser(UserBank user) {
        this.map.remove(user);
    }

    /**
     * Метод добавляет по passport новый account
     *
     * @param passport - данные паспорта
     * @param account  - новый счет по паспорту.
     */
    public void addAccountToUser(String passport, AccountBank account) {
        if (passport != null && account != null) {
            UserBank user = userKey(passport);
            if (user != null) {
                this.map.get(user).add(account);
            }
        }
    }

    /**
     * Данный метод удаляет по паспорту счет пользователя.
     *
     * @param passport - данные паспорта пользователя.
     * @param account  - данные счета пользователя.
     */
    public void deleteAccountFromUser(String passport, AccountBank account) {
        if (passport != null && account != null) {
            List<AccountBank> list;
            UserBank user = userKey(passport);
            if (user != null) {
                list = this.map.get(user);
                if (list.contains(account)) {
                    list.remove(list.indexOf(account));
                }
            }
        }
    }

    /**
     * Метод возвращает все счета пользователя по паспорту.
     *
     * @param passport- данные паспорта пользователя.
     * @return - счета пользователя.
     */
    public List<AccountBank> getUserAccounts(String passport) {
        List<AccountBank> list = null;
        if (passport != null) {
            for (UserBank userBank : this.map.keySet()) {
                if (userBank.getPassport().equals(passport)) {
                    list = this.map.get(userBank);
                }
            }
        }
        return list;
    }

    /**
     * Метод переводит деньги со счета одного пользователя другому пользователю, если
     * srcPassport и destPassport совпадают, то перевод денег производится между своими счетами.
     *
     * @param srcPassport  - данные паспорта пользователя со счета которого нужно снять деньги.
     * @param srcRequisite - данные реквизита счета с которого нужно снять деньги.
     * @param destPassport - данные паспорта пользователя на счет которого нужно перевести деньги.
     * @param dstRequisite - данные реквизита счета на который нужно перевести деньги.
     * @param amount
     * @return - возвращает true, если перевод денег состоялся, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        UserBank user1 = this.userKey(srcPassport);
        UserBank user2 = this.userKey(destPassport);
        AccountBank account1 = null, account2 = null;
        if (user1 != null && user2 != null) {
            account1 = this.searchAccount(srcRequisite, user1);
            account2 = this.searchAccount(dstRequisite, user2);
        }
        return account1 != null && account2 != null && account1.transfer(account2, amount);
    }

    @Override
    public String toString() {
        return "NewBank{" + "map=" + map + '}';
    }
}
