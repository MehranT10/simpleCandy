//mehran taheri
package candy.crush;

import javax.swing.JFrame;


public class CandyCrush {

    public static void main(String[] args) 
    {
        JFrame start = new JFrame();
        myPanel spanel = new myPanel();
        start.setTitle("Candy menu.....");
        start.add(spanel);
        start.setLocation(150, 100);
        start.setSize(310, 380);
        start.setVisible(true);
        start.setResizable(false);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}
