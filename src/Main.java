import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JComponent implements ActionListener {
    int x = 0;
    int y = 0;
    int w = 50;
    int h = 50;
    static int winW = 500;
    static int winH = 530;
    Image runningMan = new ImageIcon("src/runningMan.png").getImage();
    Image finishedMan = new ImageIcon("src/finishedMan.png").getImage();
    Timer timer = new Timer(10, this);


    public static void main(String[] args) {
        Main t = new Main();
        JFrame frame = new JFrame("Движение картинки по прямой");
        frame.setSize(winW, winH);
        frame.setLocation(434, 134);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(t);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (x+w+80<winH)
            g2d.drawImage(runningMan, x,y, w,h,null);
        else
            g2d.drawImage(finishedMan, x,y, w+10,h+10,null);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        x++;
        y++;
        if (x+w>=winW && y+h+30>=winH) {
            x=0;
            y=0;
        }
        repaint();
    }
}