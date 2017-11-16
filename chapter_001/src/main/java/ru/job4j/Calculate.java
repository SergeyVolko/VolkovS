package ru.job4j;

/**
 * Calculate.
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 15.11.2017
 */
public class Calculate {
	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
		Calculate calc = new Calculate();
        System.out.println(calc.echo("Sergey Volkov"));
    }
}

