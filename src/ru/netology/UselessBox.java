package ru.netology;

public class UselessBox {
    private volatile boolean toggle;
    private static final int WAITING_TIME = 3000;
    private static final int TURNS_COUNT = 7;
    private int turns;

    public void userTurnOn() {
        while (turns < TURNS_COUNT) {
            try {
                Thread.sleep(WAITING_TIME);
                turns++;
                toggle = true;
                System.out.printf("%s включил тумблер (%d)\n", Thread.currentThread().getName(), turns);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void boxTurnOff() {
        while (!Thread.currentThread().isInterrupted()) {
            if (toggle) {
                toggle = false;
                System.out.printf("%s выключил тумблер (%d)\n", Thread.currentThread().getName(), turns);
            }
        }
    }
}
