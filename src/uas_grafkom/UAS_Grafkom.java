/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_grafkom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javafx.scene.shape.TriangleMesh;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author YOGI
 */
public class UAS_Grafkom extends JApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame android = new JFrame();
        android.setTitle("roket meluncur");
        android.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new UAS_Grafkom();
        applet.init();
        android.getContentPane().add(applet);
        android.pack();
        android.setVisible(true);

    }

    @Override

    public void init() {

        JPanel panel = new Gambar();

        getContentPane().add(panel);

    }

}

class Gambar extends JPanel {

    int x1 = 0;

    int x2 = 0;
    int moveup = 0;
    int movedown = 0;
    int moveupasap = 0;
    int movedownasap = 0;

    move_up up = new move_up(this, 0);
    move_down down = new move_down(this, 0);
    moveup_asap upasap = new moveup_asap(this, 0);
    movedown_asap downasap = new movedown_asap(this, 0);

    public Gambar() {

        setPreferredSize(new Dimension(1000, 600));

        setBackground(Color.white);

        up.start();
        down.start();
        upasap.start();
        downasap.start();

    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        movedown = down.getPosisi();
        moveup = up.getPosisi();
        moveupasap = upasap.getPosisi();
        movedownasap = downasap.getPosisi();

        Shape atasss = new Rectangle2D.Double(0, -1500 + movedown, 4000, 3000);
        gd.setPaint(Color.BLACK);
        gd.fill(atasss);

        Shape atass = new Rectangle2D.Double(0, -1000 + movedown, 3000, 3000);
        GradientPaint paintt = new GradientPaint(400, 300, new Color(75, 75, 75), 500, 0, Color.white);
        gd.setPaint(paintt);
        gd.fill(atass);

        Shape atas = new Rectangle2D.Double(0, -500 + movedown, 3000, 3000);
        GradientPaint paint = new GradientPaint(400, 300, new Color(100, 250, 255), 500, 0, Color.white);
        gd.setPaint(paint);
        gd.fill(atas);

        Shape bawah = new Rectangle2D.Double(0, 300 + movedown, 3000, 500);
        GradientPaint paint1 = new GradientPaint(400, 400, new Color(20, 220, 55), 400, 300, new Color(0, 200, 220, 200));
        gd.setPaint(paint1);
        gd.fill(bawah);

        //ellipse planet
        gd.setPaint(Color.yellow);
        gd.fillOval(movedownasap + 10 - moveupasap, movedown + -1300, 150, 150);
        gd.setPaint(Color.blue);
        gd.fillOval(movedownasap + 500 - moveupasap, movedown + -1400, 100, 100);
        gd.setPaint(Color.red);
        gd.fillOval(movedownasap + 800 - moveupasap, movedown + -1200, 100, 100);

//        gunung
        Polygon pola1, pola2;
        int x1[] = {350, 0, 700};
        int y1[] = {movedown + 100, movedown + 300, movedown + 300};

        int x2[] = {700, 350, 1000};
        int y2[] = {180 + movedown, 300 + movedown, 300 + movedown};

        pola1 = new Polygon(x1, y1, x1.length);
        pola2 = new Polygon(x2, y2, y2.length);

        gd.setPaint(Color.DARK_GRAY);
        gd.fill(pola1);
        gd.fill(pola2);

        //kepala roket
        Polygon pola;
        int x[] = {270, 310, 350};
        int y[] = {320, 250, 320};
        pola = new Polygon(x, y, x.length);
        gd.setPaint(Color.red);
        gd.fill(pola);

        //badan roket
        Shape putih = new Rectangle2D.Double(270, 320, 80, 100);
        gd.setColor(Color.blue);
        gd.fill(putih);

        //jendela roket 
        Ellipse2D lingkaran1, lingkaran2;
        double Lx1 = 295, Ly1 = 285;
        double diameter1 = 30;

        double Lx2 = 300, Ly2 = 290;
        double diameter2 = 20;

        lingkaran1 = new Ellipse2D.Double(Lx1, Ly1, diameter1, diameter1);
        lingkaran2 = new Ellipse2D.Double(Lx2, Ly2, diameter2, diameter2);
        gd.setColor(Color.black);
        gd.fill(lingkaran1);
        gd.setColor(Color.white);
        gd.fill(lingkaran2);

        //sayap roket
        Polygon sayapkiri, sayaptengah, sayapkanan;
        int xkiri[] = {270, 240, 240, 270};
        int ykiri[] = {350, 410, 440, 420};

        int xkanan[] = {350, 380, 380, 350};
        int ykanan[] = {350, 410, 440, 420};

        int xtengah[] = {310, 300, 310, 320};
        int ytengah[] = {350, 410, 440, 410};

        sayapkiri = new Polygon(xkiri, ykiri, xkiri.length);
        sayapkanan = new Polygon(xkanan, ykanan, xkanan.length);
        sayaptengah = new Polygon(xtengah, ytengah, xtengah.length);

        gd.setPaint(Color.red);
        gd.fill(sayapkiri);
        gd.fill(sayapkanan);
        gd.fill(sayaptengah);

        //asap roket
        gd.setPaint(Color.white);
        gd.fillOval(279, moveupasap + 460, 20, 70);
        gd.fillOval(320, moveupasap + 460, 20, 70);

        gd.fillOval(290, moveupasap + 500, 40, 40);
        gd.fillOval(285, moveupasap + 500, 40, 40);
        gd.fillOval(280, moveupasap + 520, 40, 40);
        gd.fillOval(300, moveupasap + 520, 40, 40);
        gd.fillOval(305, moveupasap + 520, 40, 40);
        gd.fillOval(280, moveupasap + 540, 40, 40);
        gd.fillOval(275, moveupasap + 540, 40, 40);
        gd.fillOval(305, moveupasap + 540, 40, 40);
        gd.fillOval(255, moveupasap + 560, 40, 40);
        gd.fillOval(275, moveupasap + 560, 40, 40);
        gd.fillOval(285, moveupasap + 560, 40, 40);
        gd.fillOval(275, moveupasap + 560, 40, 40);
        gd.fillOval(235, moveupasap + 580, 40, 40);
        gd.fillOval(255, moveupasap + 580, 40, 40);
        gd.fillOval(275, moveupasap + 580, 40, 40);
        gd.fillOval(295, moveupasap + 580, 40, 40);
        gd.fillOval(285, moveupasap + 580, 40, 40);
        gd.fillOval(300, moveupasap + 560, 40, 40);
        gd.fillOval(320, moveupasap + 560, 40, 40);
        gd.fillOval(330, moveupasap + 580, 40, 40);
        gd.fillOval(250, moveupasap + 580, 40, 40);

        //api roket
        gd.setPaint(Color.yellow);
        gd.fillOval(279, 420, 20, 70);
        gd.fillOval(320, 420, 20, 70);

        gd.setPaint(Color.red);
        gd.fillOval(282, 420, 15, 50);
        gd.fillOval(322, 420, 15, 50);
        //kaki roket
        int xkirii = 280, ykirii = 420;
        int p = 20, l = 20;

        Rectangle kotak = new Rectangle(xkirii, ykirii, p, l);
        gd.setColor(Color.black);
        gd.fill(kotak);

        int xkanaan = 320, ykanaan = 420;
        int pkanan = 20, lkanan = 20;

        Rectangle kotakk = new Rectangle(xkanaan, ykanaan, pkanan, lkanan);
        gd.setColor(Color.black);
        gd.fill(kotakk);

        //bangunan
        int x1t = 370, y1t = movedown + 250;//tiang
        int p1 = 20, l1 = 240;

        int x2b = 390, y2b = movedown + 400;//bangunnan
        int p2 = 400, l2 = 90;

        int x3p = movedown + 290, y3p = movedown + 370;//pengait
        int p3 = 150, l3 = 20;

        int x4 = 390, y4 = movedown + 370;//bangunan 2
        int p4 = 300, l4 = 30;

        Rectangle tiang = new Rectangle(x1t, y1t, p1, l1);
        Rectangle bangun = new Rectangle(x2b, y2b, p2, l2);
        Rectangle pengait = new Rectangle(x3p, y3p, p3, l3);
        Rectangle bangun2 = new Rectangle(x4, y4, p4, l4);
        gd.setColor(Color.BLUE);
        gd.fill(tiang);
        gd.fill(bangun);
        gd.fill(pengait);
        gd.fill(bangun2);

        // gambar awan
        g.setColor(Color.white);
        g.fillOval(movedown + 0, movedown + 100, 30, 30);
        g.fillOval(movedown + 25, movedown + 100, 30, 30);
        g.fillOval(movedown + 50, movedown + 100, 30, 30);
        g.fillOval(movedown + 15, movedown + 80, 30, 30);
        g.fillOval(movedown + 32, movedown + 80, 30, 30);

        g.fillOval(movedown + 90, movedown + 80, 30, 30);
        g.fillOval(movedown + 115, movedown + 80, 30, 30);
        g.fillOval(movedown + 140, movedown + 80, 30, 30);
        g.fillOval(movedown + 105, movedown + 60, 30, 30);
        g.fillOval(movedown + 122, movedown + 60, 30, 30);

        g.fillOval(movedown + 180, movedown + 100, 30, 30);
        g.fillOval(movedown + 205, movedown + 100, 30, 30);
        g.fillOval(movedown + 230, movedown + 100, 30, 30);
        g.fillOval(movedown + 195, movedown + 80, 30, 30);
        g.fillOval(movedown + 212, movedown + 80, 30, 30);

        g.fillOval(moveup + 690, movedown + 80, 30, 30);
        g.fillOval(moveup + 715, movedown + 80, 30, 30);
        g.fillOval(moveup + 740, movedown + 80, 30, 30);
        g.fillOval(moveup + 705, movedown + 60, 30, 30);
        g.fillOval(moveup + 722, movedown + 60, 30, 30);

        g.fillOval(moveup + 780, movedown + 100, 30, 30);
        g.fillOval(moveup + 805, movedown + 100, 30, 30);
        g.fillOval(moveup + 830, movedown + 100, 30, 30);
        g.fillOval(moveup + 795, movedown + 80, 30, 30);
        g.fillOval(moveup + 812, movedown + 80, 30, 30);

        g.fillOval(moveup + 870, movedown + 80, 30, 30);
        g.fillOval(moveup + 895, movedown + 80, 30, 30);
        g.fillOval(moveup + 920, movedown + 80, 30, 30);
        g.fillOval(moveup + 885, movedown + 60, 30, 30);
        g.fillOval(moveup + 902, movedown + 60, 30, 30);

        //Bintang
        gd.setColor(Color.yellow);
        int[] a = {715, 716, 710, 720, 725, 730, 740, 734, 738, 725};
        int[] b = {-535 + movedown, -523 + movedown, -515 + movedown, -515 + movedown, -505 + movedown, -515 + movedown, -515 + movedown, -523 + movedown, -535 + movedown, -530 + movedown};
        gd.fillPolygon(a, b, a.length);

        gd.setColor(Color.yellow);
        int[] a1 = {70, 71, 65, 75, 80, 85, 95, 89, 93, 80};
        int[] b1 = {-585 + movedown, -573 + movedown, -565 + movedown, -565 + movedown, -555 + movedown, -565 + movedown, -565 + movedown, -573 + movedown, -585 + movedown, -580 + movedown};
        gd.fillPolygon(a1, b1, a1.length);

        gd.setColor(Color.yellow);
        int[] a2 = {170, 171, 165, 175, 180, 185, 195, 189, 193, 180};
        int[] b2 = {-585 + movedown, -573 + movedown, -565 + movedown, -565 + movedown, -555 + movedown, -565 + movedown, -565 + movedown, -573 + movedown, -585 + movedown, -580 + movedown};
        gd.fillPolygon(a2, b2, a2.length);

        gd.setColor(Color.yellow);
        int[] a3 = {715, 716, 710, 720, 725, 730, 740, 734, 738, 725};
        int[] b3 = {-735 + movedown, -723 + movedown, -715 + movedown, -715 + movedown, -705 + movedown, -715 + movedown, -715 + movedown, -723 + movedown, -735 + movedown, -730 + movedown};
        gd.fillPolygon(a3, b3, a.length);

        gd.setColor(Color.yellow);
        int[] a8 = {1015, 1016, 1010, 1020, 1025, 1030, 1040, 1034, 1038, 1025};
        int[] b8 = {-1035 + movedown, -1023 + movedown, -1015 + movedown, -1015 + movedown, -1005 + movedown, -1015 + movedown, -1015 + movedown, -1023 + movedown, -1035 + movedown, -1030 + movedown};
        gd.fillPolygon(a8, b8, a.length);

        gd.setColor(Color.yellow);
        int[] a4 = {915, 916, 910, 920, 925, 930, 940, 934, 938, 925};
        int[] b4 = {-935 + movedown, -923 + movedown, -915 + movedown, -915 + movedown, -905 + movedown, -915 + movedown, -915 + movedown, -923 + movedown, -935 + movedown, -930 + movedown};
        gd.fillPolygon(a4, b4, a.length);

        gd.setColor(Color.yellow);
        int[] a5 = {170, 171, 165, 175, 180, 185, 195, 189, 193, 180};
        int[] b5 = {-885 + movedown, -873 + movedown, -865 + movedown, -865 + movedown, -855 + movedown, -865 + movedown, -865 + movedown, -873 + movedown, -885 + movedown, -880 + movedown};
        gd.fillPolygon(a5, b5, a2.length);

        gd.setColor(Color.yellow);
        int[] a6 = {470, 471, 465, 475, 480, 485, 495, 489, 493, 480};
        int[] b6 = {-1085 + movedown, -1073 + movedown, -1065 + movedown, -1065 + movedown, -1055 + movedown, -1065 + movedown, -1065 + movedown, -1073 + movedown, -1085 + movedown, -1080 + movedown};
        gd.fillPolygon(a6, b6, a2.length);

        gd.setColor(Color.yellow);
        int[] a7 = {570, 571, 565, 575, 580, 585, 595, 589, 593, 580};
        int[] b7 = {-1085 + movedown, -1073 + movedown, -1065 + movedown, -1065 + movedown, -1055 + movedown, -1065 + movedown, -1065 + movedown, -1073 + movedown, -1085 + movedown, -1080 + movedown};
        gd.fillPolygon(a7, b7, a2.length);

        gd.setColor(Color.yellow);
        int[] a9 = {1070, 1071, 1065, 1075, 1080, 1085, 1095, 1089, 1093, 1080};
        int[] b9 = {-1485 + movedown, -1473 + movedown, -1465 + movedown, -1465 + movedown, -1455 + movedown, -1465 + movedown, -1465 + movedown, -1473 + movedown, -1485 + movedown, -1480 + movedown};
        gd.fillPolygon(a7, b7, a2.length);

        gd.setColor(Color.yellow);
        int[] a11 = {170, 171, 165, 175, 180, 185, 195, 189, 193, 180};
        int[] b11 = {-1485 + movedown, -1473 + movedown, -1465 + movedown, -1465 + movedown, -1455 + movedown, -1465 + movedown, -1465 + movedown, -1473 + movedown, -1485 + movedown, -1480 + movedown};
        gd.fillPolygon(a11, b11, a2.length);

    }
}
