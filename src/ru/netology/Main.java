package ru.netology;

public class Main {

    public static void main(String[] args) {

        final UselessBox uselessBox = new UselessBox();

        Runnable turnOn = uselessBox::userTurnOn;
        Runnable turnOff = uselessBox::boxTurnOff;

        Thread user = new Thread(null, turnOn, "Пользователь");
        Thread box = new Thread(null, turnOff, "Монстр в коробке");

        user.start();
        box.start();

        try {
            user.join();
            box.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\nЗавершение.");
    }
}
