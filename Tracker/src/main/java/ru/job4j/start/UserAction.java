package ru.job4j.start;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.01.2018
 */
public interface UserAction {
	int key();
	void execute(Input iput, Tracker tracker);
	String info();	
}