
package candy.crush;

import javax.swing.ImageIcon;


public class Candy 
{
    private boolean sp = false;//true for spicial
    private int code2;//for colors
    private int code;// az 1-12
    private String name;// r,b,o....
    private ImageIcon myicon;//for buttone bagrond
    public Candy(int c)
    {
        code = c ;
        switch (c)
        {
            case 1:
                name = "R" ; // red
                myicon = new ImageIcon("candy_red.jpg");
                code2 = 1;
                break;
            case 2:
                name = "G" ; // grean
                myicon = new ImageIcon("candy_grean.jpg");
                code2 = 2;
                break;
            case 3:
                name = "B" ; // blue
                myicon = new ImageIcon("candy_blue.jpg");
                code2 = 3;
                break;
            case 4:
                name = "Y" ; // yellow
                myicon = new ImageIcon("candy_yellow.jpg");
                code2 = 4;
                break;
            case 5 :
                name = "V" ; // violet
                myicon = new ImageIcon("candy_violet.jpg");
                code2 = 5;
                break;
            case 6:
                name = "O" ; // orange
                myicon = new ImageIcon("candy_orange.jpg");
                code2 = 6;
                break;
            case 7:
                name = "Rs" ; // especial red
                myicon = new ImageIcon("candy_reds.jpg");
                code2 = 1;
                sp = true;
                break;
            case 8:
                name = "Gs" ; // especial grean
                myicon = new ImageIcon("candy_greans.jpg");
                code2 = 2;
                sp = true;
                break;
            case 9:
                name = "Bs" ; // especial blue
                myicon = new ImageIcon("candy_blues.jpg");
                code2 = 3;
                sp = true;
                break;
            case 10:
                name = "Ys" ; // especial yellow
                myicon = new ImageIcon("candy_yellows.jpg");
                code2 = 4;
                sp = true;
                break;
            case 11 :
                name = "Vs" ; // especial violet
                myicon = new ImageIcon("candy_violets.jpg");
                code2 = 5;
                sp = true;
                break;
            case 12:
                name = "Os" ; // especial orange
                myicon = new ImageIcon("candy_oranges.jpg");
                code2 = 6;
                sp = true;
                break;       
        }
        
    }

    public boolean get_Sp() 
    {
        return sp;
    }

    public int get_Code2() 
    {
        return code2;
    }

    public void set_Code(int code) 
    {
        this.code = code;
    }

    public void set_Name(String name) 
    {
        this.name = name;
    }

    public int get_Code() 
    {
        return code;
    }

    public String get_Name() 
    {
        return name;
    } 

    public ImageIcon get_Myicon() 
    {
        return myicon;
    }
    
    
}
