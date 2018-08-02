package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 21.07.2018
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int znakX = 1;
        int znakY = 1;
        while (true) {
            if (this.rect.getX() >= 300) {
                znakX = -1;
            }
            if (this.rect.getX() <= 0) {
                znakX = 1;
            }
            if (this.rect.getY() >= 300) {
                znakY = -1;
            }
            if (this.rect.getY() <= 0) {
                znakY = 1;
            }
            this.rect.setX(this.rect.getX() + znakX);
            this.rect.setY(this.rect.getY() + znakY);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
