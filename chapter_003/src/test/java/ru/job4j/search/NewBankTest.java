package ru.job4j.search;

import org.junit.Test;
import ru.job4j.bank.AccountBank;
import ru.job4j.bank.NewBank;
import ru.job4j.bank.UserBank;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NewBankTest {
    @Test
    public void whenAddUserThenAddUserInMap() {
        String expect = "NewBank{map={UserBank{name='Igor', passport='9797kjhjihj'}=[], UserBank{name='Vovan', passport='3555hhj'}=[]}}";
        NewBank newBank = new NewBank();
        newBank.addUser(new UserBank("Vovan", "3555hhj"));
        newBank.addUser(new UserBank("Igor", "9797kjhjihj"));
        assertThat(expect, is(newBank.toString()));
    }

    @Test
    public void whenDeleteUserThenDeleted() {
        String expect = "NewBank{map={UserBank{name='Vovan', passport='3555hhj'}=[]}}";
        NewBank newBank = new NewBank();
        newBank.addUser(new UserBank("Vovan", "3555hhj"));
        newBank.addUser(new UserBank("Igor", "9797kjhjihj"));
        newBank.deleteUser(new UserBank("Igor", "9797kjhjihj"));
        assertThat(expect, is(newBank.toString()));
    }

    @Test
    public void whenAddAccountToUserThenAddedAccount() {
        String expect = "NewBank{map={UserBank{name='Igor', passport='9797kjhjihj'}=[AccountBank{requisites='2423532556346', value=300.0}], UserBank{name='Vovan', passport='3555hhj'}=[AccountBank{requisites='22989242889', value=12345.56}]}}";
        NewBank newBank = new NewBank();
        newBank.addUser(new UserBank("Vovan", "3555hhj"));
        newBank.addUser(new UserBank("Igor", "9797kjhjihj"));
        newBank.addAccountToUser("3555hhj", new AccountBank("22989242889", 12345.56));
        newBank.addAccountToUser("9797kjhjihj", new AccountBank("2423532556346", 300.0));
        assertThat(expect, is(newBank.toString()));
    }

    @Test
    public void whenDeleteAccountFromUserThenDeletedAccount() {
        String expect = "NewBank{map={UserBank{name='Igor', passport='9797kjhjihj'}=[AccountBank{requisites='2423532556346', value=300.0}], UserBank{name='Vovan', passport='3555hhj'}=[]}}";
        NewBank newBank = new NewBank();
        newBank.addUser(new UserBank("Vovan", "3555hhj"));
        newBank.addUser(new UserBank("Igor", "9797kjhjihj"));
        newBank.addAccountToUser("3555hhj", new AccountBank("22989242889", 12345.56));
        newBank.addAccountToUser("9797kjhjihj", new AccountBank("2423532556346", 300.0));
        newBank.deleteAccountFromUser("3555hhj", new AccountBank("22989242889", 12345.56));
        assertThat(expect, is(newBank.toString()));
    }

    @Test
    public void whenGetUserAccountThenGetList() {
        String expect = "[AccountBank{requisites='22989242889', value=12345.56}]";
        NewBank newBank = new NewBank();
        newBank.addUser(new UserBank("Vovan", "3555hhj"));
        newBank.addAccountToUser("3555hhj", new AccountBank("22989242889", 12345.56));
        assertThat(expect, is(newBank.getUserAccounts("3555hhj").toString()));
    }

    @Test
    public void whenTransferMoneyThenTransfer() {
        String expect = "NewBank{map={UserBank{name='Igor', passport='9797kjhjihj'}=[AccountBank{requisites='2423532556346', value=10300.0}], UserBank{name='Vovan', passport='3555hhj'}=[AccountBank{requisites='22989242889', value=2345.5599999999995}]}}";
        NewBank newBank = new NewBank();
        newBank.addUser(new UserBank("Vovan", "3555hhj"));
        newBank.addUser(new UserBank("Igor", "9797kjhjihj"));
        newBank.addAccountToUser("3555hhj", new AccountBank("22989242889", 12345.56));
        newBank.addAccountToUser("9797kjhjihj", new AccountBank("2423532556346", 300.0));
        newBank.transferMoney("3555hhj", "22989242889", "9797kjhjihj", "2423532556346", 10000.0);
        assertThat(expect, is(newBank.toString()));
    }
}
