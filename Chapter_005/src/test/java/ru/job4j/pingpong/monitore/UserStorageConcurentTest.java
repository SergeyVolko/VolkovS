package ru.job4j.pingpong.monitore;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 21.09.2018
 */

public class UserStorageConcurentTest {
    private UserStorage userStorage = new UserStorage();

    @Test
    public void whenTransferThenUseThreads() throws InterruptedException {
        userStorage.add(new User(1, 100));
        userStorage.add(new User(2, 0));
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    userStorage.transfer(1, 2, 10);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    userStorage.transfer(2, 1, 10);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(userStorage.getUser(1).getAmount(), is(100));
    }
}
