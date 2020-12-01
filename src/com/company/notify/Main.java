package com.company.notify;

public class Main {
    boolean canPrintNum = true;

    public static void main(String[] args) {
        new Main().test();
    }

    public void test() {
        new Thread(this::printNum).start();
        new Thread(this::printChar).start();
    }

    private synchronized void printNum() {
        try {
            int i =1;
            while (true) {
                if (!canPrintNum) {
                    wait();
                }
                System.out.print(i++ + "" + i++);
                canPrintNum = false;
                notify();
                if (i >= 52) {
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    private synchronized void printChar() {
        try {
            int i =0;
            while (true) {
                if (canPrintNum) {
                    wait();
                }
                System.out.print((char)(i++ + 'a'));
                canPrintNum = true;
                notify();
                if (i >= 26) {
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
