/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_grafkom;

import javax.swing.JPanel;

/**
 *
 * @author YOGI
 */
public class moveup_asap extends Thread implements Runnable {

    JPanel panel;

    int posisi;

    public int getPosisi() {

        return posisi;
    }

    public final int atas = 0;

    int a;

    public moveup_asap(JPanel panel, int a) {

        this.panel = panel;

        this.a = a;

    }

    @Override

    public void run() {

        while (true) {

            try {

                Thread.sleep(80);

            } catch (Exception e) {
            } finally {

                if (a == atas) {

                    posisi++;

                    if (posisi == 10) {

                        posisi = 0;

                    }

                }

            }

            panel.repaint();

        }

    }
}
