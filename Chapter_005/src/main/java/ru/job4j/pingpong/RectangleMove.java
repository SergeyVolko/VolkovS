package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 21.07.2018
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private Stage stage;
    private boolean flag = false;

    public RectangleMove(Rectangle rect, Stage stage) {
        this.rect = rect;
        this.stage = stage;
    }

    @Override
    public void run() {
        int znakX = 1;
        int znakY = 1;
        while (!Thread.interrupted()) {
            if (this.rect.getX() <= 0 || this.rect.getX() >= 300) {
                znakX *= -1;
            }
            if (this.rect.getY() <= 0 || this.rect.getY() >= 300) {
                znakY *= -1;
            }
            this.rect.setX(this.rect.getX() + znakX);
            this.rect.setY(this.rect.getY() + znakY);
            stage.setOnCloseRequest(event -> this.flag = true);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.flag) {
                Thread.currentThread().interrupt();
                this.flag = false;
            }
        }
    }

}
