
package candy.crush;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Pointplay 
{
    static ArrayList <Candy> array1 = new ArrayList();
    static ArrayList <Candy> array2 = new ArrayList();
    static ArrayList <Candy> array3 = new ArrayList();
    static ArrayList <Candy> array4 = new ArrayList();
    static ArrayList <Candy> array5 = new ArrayList();
    static ArrayList <Candy> array6 = new ArrayList();
    static ArrayList <Candy> array7 = new ArrayList();
    static ArrayList <Candy> array8 = new ArrayList();
    static ArrayList <Candy> array9 = new ArrayList();
    static ArrayList <Candy> array10 = new ArrayList();
    //**************************************************************************
    public static boolean check = true; //baray mojaz bodan harekat
    public static int firstarray;       //jabejaei
    public static int firstcandy;       //jabejaei
    public static int secondarray;      //jabejaei
    public static int secondcandy;      //jabejaei
    public static int count = 0;        //shomare harekat 1-2
    //**************************************************************************
    private static Formatter Info;
    public static Random myR = new Random();
    static pointPanel set = new pointPanel();
    static JFrame game = new JFrame();
    static JFrame lw = new JFrame(); //baray etmam bazi
    //**************************************************************************
    private static int pointscore;
    private static int pointmoves;
    private static int moves = 0;
    private static int score = 0;
    private static String pointcandy; //noe shokolat 
    private static int pointc;        //tedad hadaf
    private static int countcandy = 0;//shomaresh shokolatha
    private static boolean setgame;   //noe bazi
    
    public Pointplay(int p , int m ,String pc, int can,boolean s)
    {
        pointscore = p;
        pointmoves = m;
        pointcandy = pc;
        pointc = can;
        setgame = s;
        creatFile();
        fillArray();
        Delete();
        countcandy = 0;
        score = 0;
        set_buttback();
        game.setLocation(450, 100);
        set.jProgressBar1.setMaximum(pointscore);
        set.jTextField1.setEditable(false);
        set.jTextField2.setEditable(false);
        set.jTextField3.setEditable(false);
        set.jTextField4.setEditable(false);
        set.jTextField5.setEditable(false);
        set.jTextField6.setEditable(false);
        set.jTextField2.setText(String.valueOf(pointscore));
        set.jTextField3.setText(String.valueOf(pointmoves));
        set.jTextField5.setText(String.valueOf(pointc)+" "+pointcandy+" Candy");
        display();
    }
    
    public static void Main_Game()
    {
        replace();
        Delete_2sp();
        Delete_a();
        Delete_O();
        if(check == false)
        {
            JOptionPane.showMessageDialog(null, "You cant do this move...", "Candy Message",0,new ImageIcon("ERROR2.jpg"));
            replace();
            check = false;
            moves-= 2;
        }
        Delete();
        fillArray();
        set_buttback();
        display();
        count = 0;
    }
    
    public void creatFile() //sakht file baray zakhire
    {
        if(setgame)
        {
            try
            {
                Info = new Formatter("get"+pointscore+" points in"+pointmoves+" moves.txt");
            }

            catch(FileNotFoundException e)
            {
                System.err.println("File not find!!!");
                System.exit(1);
            }

            catch(SecurityException e)
            {
                System.err.println("File not find!!!");
                System.exit(1);            
            }
        }
        else
        {
            try
            {
                Info = new Formatter("Collecting"+pointc+pointcandy+" Candy.txt");
            }

            catch(FileNotFoundException e)
            {
                System.err.println("File not find!!!");
                System.exit(1);
            }

            catch(SecurityException e)
            {
                System.err.println("File not find!!!");
                System.exit(1);            
            }
        }
    }
    
    public static void save_info() //zakhire etelaat
    {
        try
        {
            if(setgame)
                Info.format("get %S points in %S moves:\r\n",String.valueOf(pointscore),String.valueOf(pointmoves));
                else
                Info.format("Collecting %S %S Candy:\r\n",String.valueOf(pointc),pointcandy);
            for(int i = 9 ; i >= 0 ; i--)
            {
                Info.format("%S  %S  %S  %S  %S  %S  %S  %S  %S  %S\r\n",array1.get(i).get_Name(),
                                                            array2.get(i).get_Name(),
                                                            array3.get(i).get_Name(),
                                                            array4.get(i).get_Name(),
                                                            array5.get(i).get_Name(),
                                                            array6.get(i).get_Name(),
                                                            array7.get(i).get_Name(),
                                                            array8.get(i).get_Name(),
                                                            array9.get(i).get_Name(),
                                                            array10.get(i).get_Name());
            }
            Info.format("Remain Moves:%S\r\n",String.valueOf(pointmoves-moves));
            Info.format("Score:%S\r\n***********************************************\r\n",String.valueOf(score)); 
        }
    
        catch(IllegalFormatException e)
              {
                  System.err.println("something wrong!!");
              }
    }   
    
    public static void closefile() //bastan file
    {
        
        if( Info != null )
            Info.close();
    }
    
    public static void replace() //jabejae
    {
        if((firstarray == secondarray+1 || firstarray == secondarray-1 || firstarray == secondarray) && (firstcandy == secondcandy+1 || firstcandy == secondcandy-1 || firstcandy == secondcandy))
        {
            moves++;
            switch(firstarray)
            {
                case 1:
                    if(secondarray == 1)
                    {
                        Candy temps = new Candy(array1.get(secondcandy).get_Code());
                        array1.set(secondcandy, array1.get(firstcandy));
                        array1.set(firstcandy, temps);
                    }
                    else if(secondarray == 2)
                    {
                        Candy temps = new Candy(array2.get(secondcandy).get_Code());
                        array2.set(secondcandy, array1.get(firstcandy));
                        array1.set(firstcandy, temps);
                    }
                    break;
                case 2:
                    switch (secondarray) {
                        case 2:
                            {
                                Candy temps = new Candy(array2.get(secondcandy).get_Code());
                                array2.set(secondcandy, array2.get(firstcandy));
                                array2.set(firstcandy, temps);                        
                                break;
                            }
                        case 1:
                            {
                                Candy temps = new Candy(array2.get(firstcandy).get_Code());
                                array2.set(firstcandy, array1.get(secondcandy));
                                array1.set(secondcandy, temps);                        
                                break;
                            }
                        case 3:
                            {
                                Candy temps = new Candy(array2.get(firstcandy).get_Code());
                                array2.set(firstcandy, array3.get(secondcandy));
                                array3.set(secondcandy, temps);                        
                                break;
                            }
                    }
                    break;
                case 3:
                    switch (secondarray) {
                        case 3:
                            {
                                Candy temps = new Candy(array3.get(secondcandy).get_Code());
                                array3.set(secondcandy, array3.get(firstcandy));
                                array3.set(firstcandy, temps);                        
                                break;
                            }
                        case 2:
                            {
                                Candy temps = new Candy(array3.get(firstcandy).get_Code());
                                array3.set(firstcandy, array2.get(secondcandy));
                                array2.set(secondcandy, temps);                        
                                break;
                            }
                        case 4:
                            {
                                Candy temps = new Candy(array3.get(firstcandy).get_Code());
                                array3.set(firstcandy, array4.get(secondcandy));
                                array4.set(secondcandy, temps);
                                break;                   
                            }
                    }
                    break;
                case 4:
                    switch (secondarray) {
                        case 4:
                            {
                                Candy temps = new Candy(array4.get(secondcandy).get_Code());
                                array4.set(secondcandy, array4.get(firstcandy));
                                array4.set(firstcandy, temps);                        
                                break;
                            }
                        case 3:
                            {
                                Candy temps = new Candy(array4.get(firstcandy).get_Code());
                                array4.set(firstcandy, array3.get(secondcandy));
                                array3.set(secondcandy, temps);                        
                                break;
                            }
                        case 5:
                            {
                                Candy temps = new Candy(array4.get(firstcandy).get_Code());
                                array4.set(firstcandy, array5.get(secondcandy));
                                array5.set(secondcandy, temps);
                                break;                     
                            }
                    }
                    break;
                case 5:
                    switch (secondarray) {
                        case 5:
                            {
                                Candy temps = new Candy(array5.get(secondcandy).get_Code());
                                array5.set(secondcandy, array5.get(firstcandy));
                                array5.set(firstcandy, temps);                        
                                break;
                            }
                        case 4:
                            {
                                Candy temps = new Candy(array5.get(firstcandy).get_Code());
                                array5.set(firstcandy, array4.get(secondcandy));
                                array4.set(secondcandy, temps);                        
                                break;
                            }
                        case 6:
                            {
                                Candy temps = new Candy(array5.get(firstcandy).get_Code());
                                array5.set(firstcandy, array6.get(secondcandy));
                                array6.set(secondcandy, temps);
                                break;                     
                            }
                    }
                    break;
                case 6:
                    switch (secondarray) {
                        case 6:
                            {
                                Candy temps = new Candy(array6.get(secondcandy).get_Code());
                                array6.set(secondcandy, array6.get(firstcandy));
                                array6.set(firstcandy, temps);                        
                                break;
                            }
                        case 5:
                            {
                                Candy temps = new Candy(array6.get(firstcandy).get_Code());
                                array6.set(firstcandy, array5.get(secondcandy));
                                array5.set(secondcandy, temps);                        
                                break;
                            }
                        case 7:
                            {
                                Candy temps = new Candy(array6.get(firstcandy).get_Code());
                                array6.set(firstcandy, array7.get(secondcandy));
                                array7.set(secondcandy, temps);
                                break;                     
                            }
                    }
                    break;
                case 7:
                    switch (secondarray) {
                        case 7:
                            {
                                Candy temps = new Candy(array7.get(secondcandy).get_Code());
                                array7.set(secondcandy, array7.get(firstcandy));
                                array7.set(firstcandy, temps);                        
                                break;
                            }
                        case 6:
                            {
                                Candy temps = new Candy(array7.get(firstcandy).get_Code());
                                array7.set(firstcandy, array6.get(secondcandy));
                                array6.set(secondcandy, temps);                        
                                break;
                            }
                        case 8:
                            {
                                Candy temps = new Candy(array7.get(firstcandy).get_Code());
                                array7.set(firstcandy, array8.get(secondcandy));
                                array8.set(secondcandy, temps);
                                break;                     
                            }
                    }
                    break;
                case 8:
                    switch (secondarray) {
                        case 8:
                            {
                                Candy temps = new Candy(array8.get(secondcandy).get_Code());
                                array8.set(secondcandy, array8.get(firstcandy));
                                array8.set(firstcandy, temps);                        
                                break;
                            }
                        case 7:
                            {
                                Candy temps = new Candy(array8.get(firstcandy).get_Code());
                                array8.set(firstcandy, array7.get(secondcandy));
                                array7.set(secondcandy, temps);                        
                                break;
                            }
                        case 9:
                            {
                                Candy temps = new Candy(array8.get(firstcandy).get_Code());
                                array8.set(firstcandy, array9.get(secondcandy));
                                array9.set(secondcandy, temps);
                                break;                     
                            }
                    }
                    break;
                case 9:
                    switch (secondarray) {
                        case 9:
                            {
                                Candy temps = new Candy(array9.get(secondcandy).get_Code());
                                array9.set(secondcandy, array9.get(firstcandy));
                                array9.set(firstcandy, temps);                        
                                break;
                            }
                        case 8:
                            {
                                Candy temps = new Candy(array9.get(firstcandy).get_Code());
                                array9.set(firstcandy, array8.get(secondcandy));
                                array8.set(secondcandy, temps);                        
                                break;
                            }
                        case 10:
                            {
                                Candy temps = new Candy(array9.get(firstcandy).get_Code());
                                array9.set(firstcandy, array10.get(secondcandy));
                                array10.set(secondcandy, temps);
                                break;                     
                            }
                    }
                    break;
                case 10:
                    if(secondarray == 10)
                    {
                        Candy temps = new Candy(array10.get(secondcandy).get_Code());
                        array10.set(secondcandy, array10.get(firstcandy));
                        array10.set(firstcandy, temps);                        
                    }
                    else if(secondarray == 9)
                    {
                        Candy temps = new Candy(array10.get(firstcandy).get_Code());
                        array10.set(firstcandy, array9.get(secondcandy));
                        array9.set(secondcandy, temps);                        
                    }
                    break;                    
            }
        } 
        else
        {
            check = false;
        }
    }
    
    public static void display() //nemayesh
    {
        set.jProgressBar1.setValue(score);
        set.jTextField1.setText(String.valueOf(score));
        set.jTextField4.setText(String.valueOf(moves));
        set.jTextField6.setText(String.valueOf(countcandy));
        game.add(set);
        game.setTitle("Candy Crush....");
        game.setSize(575, 470);
        game.setVisible(true);
        game.setResizable(false);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endgame();
    }
    
    public static void random_transfer()//jabeja kardan chand shokolat be surat random
    {
        int pointextra;
        moves++;
        for (int i =0 ; i <5 ; i++)
        {
            int a = myR.nextInt(9);
            int b = myR.nextInt(9);
            Candy temp1 = new Candy(array1.get(a).get_Code());
            array1.set(a, array5.get(b));
            array5.set(b, temp1);
            
            Candy temp2 = new Candy(array2.get(a).get_Code());
            array2.set(a, array6.get(b));
            array6.set(b, temp2);
            
            Candy temp3 = new Candy(array3.get(a).get_Code());
            array3.set(a, array7.get(b));
            array7.set(b, temp3);
            
            Candy temp4 = new Candy(array4.get(a).get_Code());
            array4.set(a, array8.get(b));
            array8.set(b, temp4);
            
            Candy temp5 = new Candy(array5.get(a).get_Code());
            array5.set(a, array10.get(b));
            array10.set(b, temp5);
            
            pointextra = score;
            Delete();
            score -= (score - pointextra);
        }
        
    }
    
    public static void endgame() //panel etmam bazi
    {
        if(setgame)
        {
            if(score >= pointscore && pointmoves == moves)
            { 
                closefile();
                JOptionPane.showMessageDialog(null, "you win!!!\nclick to exit.", "end", 0, new ImageIcon("wins.jpg"));
                System.exit(0);
            }
            if(pointmoves < moves)
            { 
                closefile();
                JOptionPane.showMessageDialog(null, "you losses!!!\nclick to exit.", "end", 0, new ImageIcon("loss.jpg"));
                System.exit(0);
            }
        }
        else if(setgame == false)
        {
            if(pointc <= countcandy && moves <= pointmoves)
            { 
                closefile();
                JOptionPane.showMessageDialog(null, "you win!!!\nclick to exit.", "end", 0, new ImageIcon("wins.jpg"));
                System.exit(0);
            }
            if(pointmoves < moves)
            { 
                closefile();
                JOptionPane.showMessageDialog(null, "you losses!!!\nclick to exit.", "end", 0, new ImageIcon("loss.jpg"));
                System.exit(0);
            }
        }
    }
    
    public static void fillArray () //por kardan arrayha ta 100
    {
        int r;
        for(int i = 0 ; i < 100-array1.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array1.add(cgame);  
        }
        for(int i = 0 ; i < 100-array2.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array2.add(cgame);  
        }
        for(int i = 0 ; i < 100-array3.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array3.add(cgame);  
        }
        for(int i = 0 ; i < 100-array4.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array4.add(cgame);  
        }
        for(int i = 0 ; i < 100-array5.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array5.add(cgame);  
        }
        for(int i = 0 ; i < 100-array6.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array6.add(cgame);  
        }
        for(int i = 0 ; i < 100-array7.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array7.add(cgame);  
        }
        for(int i = 0 ; i < 100-array8.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array8.add(cgame);  
        }
        for(int i = 0 ; i < 100-array9.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array9.add(cgame);  
        }
        for(int i = 0 ; i < 100-array10.size() ; i++ )
        {
            r = myR.nextInt(6)+1;
            Candy cgame = new Candy(r);
            array10.add(cgame);  
        }
    }
    
    public static void set_buttback() // tasvir buttonha
    {
        set.jButton1.setIcon(array1.get(9).get_Myicon());
        set.jButton2.setIcon(array1.get(8).get_Myicon());
        set.jButton3.setIcon(array1.get(7).get_Myicon());
        set.jButton4.setIcon(array1.get(6).get_Myicon());
        set.jButton5.setIcon(array1.get(5).get_Myicon());
        set.jButton6.setIcon(array1.get(4).get_Myicon());
        set.jButton7.setIcon(array1.get(3).get_Myicon());
        set.jButton8.setIcon(array1.get(2).get_Myicon());
        set.jButton9.setIcon(array1.get(1).get_Myicon());
        set.jButton10.setIcon(array1.get(0).get_Myicon());
        
        set.jButton11.setIcon(array2.get(9).get_Myicon());
        set.jButton12.setIcon(array2.get(8).get_Myicon());
        set.jButton13.setIcon(array2.get(7).get_Myicon());
        set.jButton14.setIcon(array2.get(6).get_Myicon());
        set.jButton15.setIcon(array2.get(5).get_Myicon());
        set.jButton16.setIcon(array2.get(4).get_Myicon());
        set.jButton17.setIcon(array2.get(3).get_Myicon());
        set.jButton18.setIcon(array2.get(2).get_Myicon());
        set.jButton19.setIcon(array2.get(1).get_Myicon());
        set.jButton20.setIcon(array2.get(0).get_Myicon());
        
        set.jButton21.setIcon(array3.get(9).get_Myicon());
        set.jButton22.setIcon(array3.get(8).get_Myicon());
        set.jButton23.setIcon(array3.get(7).get_Myicon());
        set.jButton24.setIcon(array3.get(6).get_Myicon());
        set.jButton25.setIcon(array3.get(5).get_Myicon());
        set.jButton26.setIcon(array3.get(4).get_Myicon());
        set.jButton27.setIcon(array3.get(3).get_Myicon());
        set.jButton28.setIcon(array3.get(2).get_Myicon());
        set.jButton29.setIcon(array3.get(1).get_Myicon());
        set.jButton30.setIcon(array3.get(0).get_Myicon());
        
        set.jButton31.setIcon(array4.get(9).get_Myicon());
        set.jButton32.setIcon(array4.get(8).get_Myicon());
        set.jButton33.setIcon(array4.get(7).get_Myicon());
        set.jButton34.setIcon(array4.get(6).get_Myicon());
        set.jButton35.setIcon(array4.get(5).get_Myicon());
        set.jButton36.setIcon(array4.get(4).get_Myicon());
        set.jButton37.setIcon(array4.get(3).get_Myicon());
        set.jButton38.setIcon(array4.get(2).get_Myicon());
        set.jButton39.setIcon(array4.get(1).get_Myicon());
        set.jButton40.setIcon(array4.get(0).get_Myicon());
        
        set.jButton41.setIcon(array5.get(9).get_Myicon());
        set.jButton42.setIcon(array5.get(8).get_Myicon());
        set.jButton43.setIcon(array5.get(7).get_Myicon());
        set.jButton44.setIcon(array5.get(6).get_Myicon());
        set.jButton45.setIcon(array5.get(5).get_Myicon());
        set.jButton46.setIcon(array5.get(4).get_Myicon());
        set.jButton47.setIcon(array5.get(3).get_Myicon());
        set.jButton48.setIcon(array5.get(2).get_Myicon());
        set.jButton49.setIcon(array5.get(1).get_Myicon());
        set.jButton50.setIcon(array5.get(0).get_Myicon());
        
        set.jButton51.setIcon(array6.get(9).get_Myicon());
        set.jButton52.setIcon(array6.get(8).get_Myicon());
        set.jButton53.setIcon(array6.get(7).get_Myicon());
        set.jButton54.setIcon(array6.get(6).get_Myicon());
        set.jButton55.setIcon(array6.get(5).get_Myicon());
        set.jButton56.setIcon(array6.get(4).get_Myicon());
        set.jButton57.setIcon(array6.get(3).get_Myicon());
        set.jButton58.setIcon(array6.get(2).get_Myicon());
        set.jButton59.setIcon(array6.get(1).get_Myicon());
        set.jButton60.setIcon(array6.get(0).get_Myicon());
        
        set.jButton61.setIcon(array7.get(9).get_Myicon());
        set.jButton62.setIcon(array7.get(8).get_Myicon());
        set.jButton63.setIcon(array7.get(7).get_Myicon());
        set.jButton64.setIcon(array7.get(6).get_Myicon());
        set.jButton65.setIcon(array7.get(5).get_Myicon());
        set.jButton66.setIcon(array7.get(4).get_Myicon());
        set.jButton67.setIcon(array7.get(3).get_Myicon());
        set.jButton68.setIcon(array7.get(2).get_Myicon());
        set.jButton69.setIcon(array7.get(1).get_Myicon());
        set.jButton70.setIcon(array7.get(0).get_Myicon());
        
        set.jButton71.setIcon(array8.get(9).get_Myicon());
        set.jButton72.setIcon(array8.get(8).get_Myicon());
        set.jButton73.setIcon(array8.get(7).get_Myicon());
        set.jButton74.setIcon(array8.get(6).get_Myicon());
        set.jButton75.setIcon(array8.get(5).get_Myicon());
        set.jButton76.setIcon(array8.get(4).get_Myicon());
        set.jButton77.setIcon(array8.get(3).get_Myicon());
        set.jButton78.setIcon(array8.get(2).get_Myicon());
        set.jButton79.setIcon(array8.get(1).get_Myicon());
        set.jButton80.setIcon(array8.get(0).get_Myicon());
        
        set.jButton81.setIcon(array9.get(9).get_Myicon());
        set.jButton82.setIcon(array9.get(8).get_Myicon());
        set.jButton83.setIcon(array9.get(7).get_Myicon());
        set.jButton84.setIcon(array9.get(6).get_Myicon());
        set.jButton85.setIcon(array9.get(5).get_Myicon());
        set.jButton86.setIcon(array9.get(4).get_Myicon());
        set.jButton87.setIcon(array9.get(3).get_Myicon());
        set.jButton88.setIcon(array9.get(2).get_Myicon());
        set.jButton89.setIcon(array9.get(1).get_Myicon());
        set.jButton90.setIcon(array9.get(0).get_Myicon());
        
        set.jButton91.setIcon(array10.get(9).get_Myicon());
        set.jButton92.setIcon(array10.get(8).get_Myicon());
        set.jButton93.setIcon(array10.get(7).get_Myicon());
        set.jButton94.setIcon(array10.get(6).get_Myicon());
        set.jButton95.setIcon(array10.get(5).get_Myicon());
        set.jButton96.setIcon(array10.get(4).get_Myicon());
        set.jButton97.setIcon(array10.get(3).get_Myicon());
        set.jButton98.setIcon(array10.get(2).get_Myicon());
        set.jButton99.setIcon(array10.get(1).get_Myicon());
        set.jButton100.setIcon(array10.get(0).get_Myicon());
    }
    
    public static void Delete_2sp() //hazfe do shokolat vije
    {
        if(firstarray == secondarray && firstcandy == secondcandy)
        {
            //nothing hapen
        }   
        else
        {
            switch(firstarray)
                {
                    case 1:
                        if(secondarray == 1)
                        {
                            if(array1.get(firstcandy).get_Sp() && array1.get(secondcandy).get_Sp())
                            {
                                switch (firstcandy) {
                                    case 0:
                                        array1.remove(firstcandy);
                                        array1.remove(firstcandy+1);
                                        array2.remove(firstcandy);
                                        array2.remove(firstcandy+1);
                                        check = true;
                                        break;
                                    case 9:
                                        array1.remove(firstcandy);
                                        array1.remove(firstcandy-1);
                                        array2.remove(firstcandy);
                                        array2.remove(firstcandy-1);
                                        check = true;
                                        break;
                                    default:
                                        array1.remove(firstcandy);
                                        array1.remove(firstcandy-1);
                                        array1.remove(firstcandy+1);
                                        array2.remove(firstcandy);
                                        array2.remove(firstcandy-1);
                                        array2.remove(firstcandy+1);
                                        check = true;
                                        break;
                                }
                            }
                        }
                        else if(secondarray == 2)
                        {
                            if(array1.get(firstcandy).get_Sp() && array1.get(secondcandy).get_Sp())
                            {
                                switch (firstcandy) {
                                    case 0:
                                        array1.remove(firstcandy);
                                        array1.remove(firstcandy+1);
                                        array2.remove(firstcandy);
                                        array2.remove(firstcandy+1);
                                        check = true;
                                        break;
                                    case 9:
                                        array1.remove(firstcandy);
                                        array1.remove(firstcandy-1);
                                        array2.remove(firstcandy);
                                        array2.remove(firstcandy-1);
                                        check = true;
                                        break;
                                    default:
                                        array1.remove(firstcandy);
                                        array1.remove(firstcandy-1);
                                        array1.remove(firstcandy+1);
                                        array2.remove(firstcandy);
                                        array2.remove(firstcandy-1);
                                        array2.remove(firstcandy+1);
                                        check = true;
                                        break;
                                }
                            }
                        }
                        break;
                    case 2:
                        switch (secondarray) {
                            case 2:
                                {
                                if(array2.get(firstcandy).get_Sp() && array2.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy+1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy-1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy-1);
                                            array1.remove(firstcandy+1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 1:
                                {
                                if(array2.get(firstcandy).get_Sp() && array1.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy+1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy-1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy-1);
                                            array1.remove(firstcandy+1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 3:
                                {
                                if(array2.get(firstcandy).get_Sp() && array3.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy+1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy-1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array1.remove(firstcandy);
                                            array1.remove(firstcandy-1);
                                            array1.remove(firstcandy+1);
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                        }
                        break;
                    case 3:
                        switch (secondarray) {
                            case 3:
                                {
                                if(array3.get(firstcandy).get_Sp() && array3.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                       
                                    break;
                                }
                            case 2:
                                {
                                if(array3.get(firstcandy).get_Sp() && array2.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 4:
                                {
                                if(array3.get(firstcandy).get_Sp() && array4.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array2.remove(firstcandy);
                                            array2.remove(firstcandy-1);
                                            array2.remove(firstcandy+1);
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }
                                    break;                   
                                }
                        }
                        break;
                    case 4:
                        switch (secondarray) {
                            case 4:
                                {
                                if(array4.get(firstcandy).get_Sp() && array4.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 3:
                                {
                                    if(array4.get(firstcandy).get_Sp() && array3.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                         
                                    break;
                                }
                            case 5:
                                {
                                    if(array4.get(firstcandy).get_Sp() && array5.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array3.remove(firstcandy);
                                            array3.remove(firstcandy-1);
                                            array3.remove(firstcandy+1);
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                } 
                                    break;                     
                                }
                        }
                        break;
                    case 5:
                        switch (secondarray) {
                            case 5:
                                {
                                    if(array5.get(firstcandy).get_Sp() && array5.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                         
                                    break;
                                }
                            case 4:
                                {
                                if(array5.get(firstcandy).get_Sp() && array4.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 6:
                                {
                                if(array5.get(firstcandy).get_Sp() && array6.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array4.remove(firstcandy);
                                            array4.remove(firstcandy-1);
                                            array4.remove(firstcandy+1);
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }
                                    break;                     
                                }
                        }
                        break;
                    case 6:
                        switch (secondarray) {
                            case 6:
                                {
                                if(array6.get(firstcandy).get_Sp() && array6.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 5:
                                {
                                    if(array6.get(firstcandy).get_Sp() && array5.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 7:
                                {
                                    if(array6.get(firstcandy).get_Sp() && array7.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array5.remove(firstcandy);
                                            array5.remove(firstcandy-1);
                                            array5.remove(firstcandy+1);
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }
                                    break;                     
                                }
                        }
                        break;
                    case 7:
                        switch (secondarray) {
                            case 7:
                                {
                                if(array7.get(firstcandy).get_Sp() && array7.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 6:
                                {
                                    if(array7.get(firstcandy).get_Sp() && array6.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                       
                                    break;
                                }
                            case 8:
                                {
                                    if(array7.get(firstcandy).get_Sp() && array8.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array6.remove(firstcandy);
                                            array6.remove(firstcandy-1);
                                            array6.remove(firstcandy+1);
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }
                                    break;                     
                                }
                        }
                        break;
                    case 8:
                        switch (secondarray) {
                            case 8:
                                {
                                if(array8.get(firstcandy).get_Sp() && array8.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 7:
                                {
                                    if(array8.get(firstcandy).get_Sp() && array7.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 9:
                                {
                                    if(array8.get(firstcandy).get_Sp() && array7.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array7.remove(firstcandy);
                                            array7.remove(firstcandy-1);
                                            array7.remove(firstcandy+1);
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }
                                    break;                     
                                }
                        }
                        break;
                    case 9:
                        switch (secondarray) {
                            case 9:
                                {
                                if(array9.get(firstcandy).get_Sp() && array9.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                                    break;
                                }
                            case 8:
                                {
                                    if(array9.get(firstcandy).get_Sp() && array8.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                       
                                    break;
                                }
                            case 10:
                                {
                                    if(array9.get(firstcandy).get_Sp() && array10.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array8.remove(firstcandy);
                                            array8.remove(firstcandy-1);
                                            array8.remove(firstcandy+1);
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }
                                    break;                     
                                }
                        }
                        break;
                    case 10:
                        if(secondarray == 10)
                        {
                            if(array10.get(firstcandy).get_Sp() && array10.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                       
                        }
                        else if(secondarray == 9)
                        {
                            if(array10.get(firstcandy).get_Sp() && array9.get(secondcandy).get_Sp())
                                {
                                    switch (firstcandy) {
                                        case 0:
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                        case 9:
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            check = true;
                                            break;
                                        default:
                                            array9.remove(firstcandy);
                                            array9.remove(firstcandy-1);
                                            array9.remove(firstcandy+1);
                                            array10.remove(firstcandy);
                                            array10.remove(firstcandy-1);
                                            array10.remove(firstcandy+1);
                                            check = true;
                                            break;
                                    }
                                }                        
                        }
                        break;                    
                }
        }
    }
    
    public static void Delete_a() //hazfe amudi
    {
        for (int i = 0 ; i <= 9 ; i++ )
            {
                if(array1.get(i).get_Code() == array1.get(i+1).get_Code())
                    if(array1.get(i+1).get_Code() == array1.get(i+2).get_Code())
                        if(array1.get(i+2).get_Code() == array1.get(i+3).get_Code())
                        {
                            if(array1.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array1.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array1.set(i, sp);
                            array1.remove(i+3);
                            array1.remove(i+2);
                            array1.remove(i+1);      
                        }

                else if(array1.get(i).get_Code() == array1.get(i+1).get_Code())
                    if(array1.get(i+1).get_Code() == array1.get(i+2).get_Code())
                    {
                            if(array1.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array1.remove(i+2);
                        array1.remove(i+1);
                        array1.remove(i);
                    }
                
                if(array1.get(i).get_Code2() == array1.get(i+1).get_Code2())
                        if(array1.get(i+1).get_Code2() == array1.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(0);
                        array1.remove(1);
                        array1.remove(2);
                        array1.remove(3);
                        array1.remove(4);
                        array1.remove(5);
                        array1.remove(6);
                        array1.remove(7);
                        array1.remove(8);
                        array1.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array2.get(i).get_Code() == array2.get(i+1).get_Code())
                    if(array2.get(i+1).get_Code() == array2.get(i+2).get_Code())
                        if(array2.get(i+2).get_Code() == array2.get(i+3).get_Code())
                        {
                            if(array2.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array2.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array2.set(i, sp);
                            array2.remove(i+3);
                            array2.remove(i+2);
                            array2.remove(i+1);
                        }

                else if(array2.get(i).get_Code() == array2.get(i+1).get_Code())
                    if(array2.get(i+1).get_Code() == array2.get(i+2).get_Code())
                    {
                        if(array2.get(i).get_Name().equals(pointcandy))
                            countcandy+= 3;
                        score+= 60;
                        check = true;
                        array2.remove(i+2);
                        array2.remove(i+1);
                        array2.remove(i);
                    }
                
                if(array2.get(i).get_Code2() == array2.get(i+1).get_Code2())
                        if    (array2.get(i+1).get_Code2() == array2.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array2.remove(0);
                        array2.remove(1);
                        array2.remove(2);
                        array2.remove(3);
                        array2.remove(4);
                        array2.remove(5);
                        array2.remove(6);
                        array2.remove(7);
                        array2.remove(8);
                        array2.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array3.get(i).get_Code() == array3.get(i+1).get_Code())
                    if(array3.get(i+1).get_Code() == array3.get(i+2).get_Code())
                        if(array3.get(i+2).get_Code() == array3.get(i+3).get_Code())
                        {
                            if(array3.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array3.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array3.set(i, sp);
                            array3.remove(i+3);
                            array3.remove(i+2);
                            array3.remove(i+1);
                        }

                else if(array3.get(i).get_Code() == array3.get(i+1).get_Code())
                    if(array3.get(i+1).get_Code() == array3.get(i+2).get_Code())
                    {
                            if(array3.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array3.remove(i+2);
                        array3.remove(i+1);
                        array3.remove(i);
                    }
                
                if(array3.get(i).get_Code2() == array3.get(i+1).get_Code2())
                        if    (array3.get(i+1).get_Code2() == array3.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array3.remove(0);
                        array3.remove(1);
                        array3.remove(2);
                        array3.remove(3);
                        array3.remove(4);
                        array3.remove(5);
                        array3.remove(6);
                        array3.remove(7);
                        array3.remove(8);
                        array3.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array4.get(i).get_Code() == array4.get(i+1).get_Code())
                    if(array4.get(i+1).get_Code() == array4.get(i+2).get_Code())
                        if(array4.get(i+2).get_Code() == array4.get(i+3).get_Code())
                        {
                            if(array4.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array4.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array4.set(i, sp);
                            array4.remove(i+3);
                            array4.remove(i+2);
                            array4.remove(i+1);
                        }

                else if(array4.get(i).get_Code() == array4.get(i+1).get_Code())
                    if(array4.get(i+1).get_Code() == array4.get(i+2).get_Code())
                    {
                            if(array4.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array4.remove(i+2);
                        array4.remove(i+1);
                        array4.remove(i);
                    }
                
                if(array4.get(i).get_Code2() == array4.get(i+1).get_Code2())
                        if    (array4.get(i+1).get_Code2() == array4.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array4.remove(0);
                        array4.remove(1);
                        array4.remove(2);
                        array4.remove(3);
                        array4.remove(4);
                        array4.remove(5);
                        array4.remove(6);
                        array4.remove(7);
                        array4.remove(8);
                        array4.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array5.get(i).get_Code() == array5.get(i+1).get_Code())
                    if(array5.get(i+1).get_Code() == array5.get(i+2).get_Code())
                        if(array5.get(i+2).get_Code() == array5.get(i+3).get_Code())
                        {
                            if(array5.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array5.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array5.set(i, sp);
                            array5.remove(i+3);
                            array5.remove(i+2);
                            array5.remove(i+1);
                        }

                else if(array5.get(i).get_Code() == array5.get(i+1).get_Code())
                    if(array5.get(i+1).get_Code() == array5.get(i+2).get_Code())
                    {
                            if(array5.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array5.remove(i+2);
                        array5.remove(i+1);
                        array5.remove(i);
                    }
                
                if(array5.get(i).get_Code2() == array5.get(i+1).get_Code2())
                        if    (array5.get(i+1).get_Code2() == array5.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array5.remove(0);
                        array5.remove(1);
                        array5.remove(2);
                        array5.remove(3);
                        array5.remove(4);
                        array5.remove(5);
                        array5.remove(6);
                        array5.remove(7);
                        array5.remove(8);
                        array5.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array6.get(i).get_Code() == array6.get(i+1).get_Code())
                    if(array6.get(i+1).get_Code() == array6.get(i+2).get_Code())
                        if(array6.get(i+2).get_Code() == array6.get(i+3).get_Code())
                        {
                            if(array6.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array6.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array6.set(i, sp);
                            array6.remove(i+3);
                            array6.remove(i+2);
                            array6.remove(i+1);
                        }

                else if(array6.get(i).get_Code() == array6.get(i+1).get_Code())
                    if(array6.get(i+1).get_Code() == array6.get(i+2).get_Code())
                    {
                            if(array6.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array6.remove(i+2);
                        array6.remove(i+1);
                        array6.remove(i);
                    }
                
                if(array6.get(i).get_Code2() == array6.get(i+1).get_Code2())
                        if    (array6.get(i+1).get_Code2() == array6.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array6.remove(0);
                        array6.remove(1);
                        array6.remove(2);
                        array6.remove(3);
                        array6.remove(4);
                        array6.remove(5);
                        array6.remove(6);
                        array6.remove(7);
                        array6.remove(8);
                        array6.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array7.get(i).get_Code() == array7.get(i+1).get_Code())
                    if(array7.get(i+1).get_Code() == array7.get(i+2).get_Code())
                        if(array1.get(i+2).get_Code() == array7.get(i+3).get_Code())
                        {
                            if(array7.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array7.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array7.set(i, sp);
                            array7.remove(i+3);
                            array7.remove(i+2);
                            array7.remove(i+1);
                        }

                else if(array7.get(i).get_Code() == array7.get(i+1).get_Code())
                    if(array7.get(i+1).get_Code() == array7.get(i+2).get_Code())
                    {
                            if(array7.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array7.remove(i+2);
                        array7.remove(i+1);
                        array7.remove(i);
                    }
                
                if(array7.get(i).get_Code2() == array7.get(i+1).get_Code2())
                        if    (array7.get(i+1).get_Code2() == array7.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array7.remove(0);
                        array7.remove(1);
                        array7.remove(2);
                        array7.remove(3);
                        array7.remove(4);
                        array7.remove(5);
                        array7.remove(6);
                        array7.remove(7);
                        array7.remove(8);
                        array7.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array8.get(i).get_Code() == array8.get(i+1).get_Code())
                    if(array8.get(i+1).get_Code() == array8.get(i+2).get_Code())
                        if(array8.get(i+2).get_Code() == array8.get(i+3).get_Code())
                        {
                            if(array8.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array8.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array8.set(i, sp);
                            array8.remove(i+3);
                            array8.remove(i+2);
                            array8.remove(i+1);
                        }

                else if(array8.get(i).get_Code() == array8.get(i+1).get_Code())
                    if(array8.get(i+1).get_Code() == array8.get(i+2).get_Code())
                    {
                            if(array8.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array8.remove(i+2);
                        array8.remove(i+1);
                        array8.remove(i);
                    }
                
                if(array8.get(i).get_Code2() == array8.get(i+1).get_Code2())
                        if    (array8.get(i+1).get_Code2() == array8.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array8.remove(0);
                        array8.remove(1);
                        array8.remove(2);
                        array8.remove(3);
                        array8.remove(4);
                        array8.remove(5);
                        array8.remove(6);
                        array8.remove(7);
                        array8.remove(8);
                        array8.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array9.get(i).get_Code() == array9.get(i+1).get_Code())
                    if(array9.get(i+1).get_Code() == array9.get(i+2).get_Code())
                        if(array9.get(i+2).get_Code() == array9.get(i+3).get_Code())
                        {
                            if(array9.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array9.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array9.set(i, sp);
                            array9.remove(i+3);
                            array9.remove(i+2);
                            array9.remove(i+1);
                        }

                else if(array9.get(i).get_Code() == array9.get(i+1).get_Code())
                    if(array9.get(i+1).get_Code() == array9.get(i+2).get_Code())
                    {
                            if(array9.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array9.remove(i+2);
                        array9.remove(i+1);
                        array9.remove(i);
                    }
                
                if(array9.get(i).get_Code2() == array9.get(i+1).get_Code2())
                        if    (array9.get(i+1).get_Code2() == array9.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array9.remove(0);
                        array9.remove(1);
                        array9.remove(2);
                        array9.remove(3);
                        array9.remove(4);
                        array9.remove(5);
                        array9.remove(6);
                        array9.remove(7);
                        array9.remove(8);
                        array9.remove(9);
                    }
            }

            for (int i = 0 ; i <= 7 ; i++ )
            {
                if(array10.get(i).get_Code() == array10.get(i+1).get_Code())
                    if(array10.get(i+1).get_Code() == array10.get(i+2).get_Code())
                        if(array10.get(i+2).get_Code() == array10.get(i+3).get_Code())
                        {
                            if(array10.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array10.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array10.set(i, sp);
                            array10.remove(i+3);
                            array10.remove(i+2);
                            array10.remove(i+1);
                        }

                else if(array10.get(i).get_Code() == array10.get(i+1).get_Code())
                    if(array10.get(i+1).get_Code() == array10.get(i+2).get_Code())
                    {
                            if(array10.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array10.remove(i+2);
                        array10.remove(i+1);
                        array10.remove(i);
                    }
                
                if(array10.get(i).get_Code2() == array10.get(i+1).get_Code2())
                        if    (array10.get(i+1).get_Code2() == array10.get(i+2).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array10.remove(0);
                        array10.remove(1);
                        array10.remove(2);
                        array10.remove(3);
                        array10.remove(4);
                        array10.remove(5);
                        array10.remove(6);
                        array10.remove(7);
                        array10.remove(8);
                        array10.remove(9);
                    }
            }
        
    }
    public static void Delete_O()//hazfe ofoghi
    {
        for(int i = 0 ; i<=10 ; i++)
            {
                if(array1.get(i).get_Code() == array2.get(i).get_Code())
                    if(array2.get(i).get_Code() == array3.get(i).get_Code())
                        if(array3.get(i).get_Code() == array4.get(i).get_Code())
                        {
                            if(array1.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array1.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array1.set(i, sp);
                            array2.remove(i);
                            array3.remove(i);
                            array4.remove(i);
                        }
                if(array1.get(i).get_Code() == array2.get(i).get_Code())
                    if(array2.get(i).get_Code() == array3.get(i).get_Code())
                    {
                            if(array1.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                    }
                
                if(array1.get(i).get_Code2() == array2.get(i).get_Code2())
                    if(array2.get(i).get_Code2() == array3.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }

                if(array2.get(i).get_Code() == array3.get(i).get_Code())
                    if(array3.get(i).get_Code() == array4.get(i).get_Code())
                        if(array4.get(i).get_Code() == array5.get(i).get_Code())
                        {
                            if(array2.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array2.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array2.set(i, sp);
                            array3.remove(i);
                            array4.remove(i);
                            array5.remove(i);
                        }
                if(array2.get(i).get_Code() == array3.get(i).get_Code())
                    if(array3.get(i).get_Code() == array4.get(i).get_Code())
                    {
                            if(array2.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                    }
                
                if(array2.get(i).get_Code2() == array3.get(i).get_Code2())
                    if(array3.get(i).get_Code2() == array4.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }

                if(array3.get(i).get_Code() == array4.get(i).get_Code())
                    if(array4.get(i).get_Code() == array5.get(i).get_Code())
                        if(array5.get(i).get_Code() == array6.get(i).get_Code())
                        {
                            if(array3.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array3.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array3.set(i, sp);
                            array4.remove(i);
                            array5.remove(i);
                            array6.remove(i);
                        }
                if(array3.get(i).get_Code() == array4.get(i).get_Code())
                    if(array4.get(i).get_Code() == array5.get(i).get_Code())
                    {
                            if(array3.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                    }
                
                if(array3.get(i).get_Code2() == array4.get(i).get_Code2())
                    if(array4.get(i).get_Code2() == array5.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }

                if(array4.get(i).get_Code() == array5.get(i).get_Code())
                    if(array5.get(i).get_Code() == array6.get(i).get_Code())
                        if(array6.get(i).get_Code() == array7.get(i).get_Code())
                        {
                            if(array4.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array4.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array4.set(i, sp);
                            array5.remove(i);
                            array6.remove(i);
                            array7.remove(i);
                        }
                if(array4.get(i).get_Code() == array5.get(i).get_Code())
                    if(array5.get(i).get_Code() == array6.get(i).get_Code())
                    {
                            if(array4.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                    }
                if(array4.get(i).get_Code2() == array5.get(i).get_Code2())
                    if(array5.get(i).get_Code2() == array6.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }

                if(array5.get(i).get_Code() == array6.get(i).get_Code())
                    if(array6.get(i).get_Code() == array7.get(i).get_Code())
                        if(array7.get(i).get_Code() == array8.get(i).get_Code())
                        {
                            if(array5.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array5.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array5.set(i, sp);
                            array6.remove(i);
                            array7.remove(i);
                            array8.remove(i);
                        }
                if(array5.get(i).get_Code() == array6.get(i).get_Code())
                    if(array6.get(i).get_Code() == array7.get(i).get_Code())
                    {
                            if(array5.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                    }
                
                if(array5.get(i).get_Code2() == array6.get(i).get_Code2())
                    if(array6.get(i).get_Code2() == array7.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }

                if(array6.get(i).get_Code() == array7.get(i).get_Code())
                    if(array7.get(i).get_Code() == array8.get(i).get_Code())
                        if(array8.get(i).get_Code() == array9.get(i).get_Code())
                        {
                            if(array6.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array6.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array6.set(i, sp);
                            array7.remove(i);
                            array8.remove(i);
                            array9.remove(i);
                        }
                if(array6.get(i).get_Code() == array7.get(i).get_Code())
                    if(array7.get(i).get_Code() == array8.get(i).get_Code())
                    {
                            if(array6.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                    }
                
                if(array6.get(i).get_Code2() == array7.get(i).get_Code2())
                    if(array7.get(i).get_Code2() == array8.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }

                if(array7.get(i).get_Code() == array8.get(i).get_Code())
                    if(array8.get(i).get_Code() == array9.get(i).get_Code())
                        if(array9.get(i).get_Code() == array10.get(i).get_Code())
                        {
                            if(array7.get(i).get_Name().equals(pointcandy))
                                countcandy+= 4;
                            score+=200;
                            check = true;
                            int n = array7.get(i).get_Code()+6;
                            Candy sp = new Candy(n);
                            array7.set(i, sp);
                            array8.remove(i);
                            array9.remove(i);
                            array10.remove(i);
                        }
                if(array7.get(i).get_Code() == array8.get(i).get_Code())
                    if(array8.get(i).get_Code() == array9.get(i).get_Code())
                    {
                            if(array7.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                    }
                if(array7.get(i).get_Code2() == array8.get(i).get_Code2())
                    if(array8.get(i).get_Code2() == array9.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }
                if(array8.get(i).get_Code() == array9.get(i).get_Code())
                    if(array9.get(i).get_Code() == array10.get(i).get_Code())
                    {
                            if(array8.get(i).get_Name().equals(pointcandy))
                                countcandy+= 3;
                        score+= 60;
                        check = true;
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }   
                
                if(array8.get(i).get_Code2() == array9.get(i).get_Code2())
                    if(array9.get(i).get_Code2() == array10.get(i).get_Code2())
                    {
                        score+= 300;
                        check = true;
                        array1.remove(i);
                        array2.remove(i);
                        array3.remove(i);
                        array4.remove(i);
                        array5.remove(i);
                        array6.remove(i);
                        array7.remove(i);
                        array8.remove(i);
                        array9.remove(i);
                        array10.remove(i);
                    }
            }
        
    }
    
    public static void Delete() // hazfe
    {
        check = true;
        while(check)
        {
            check = false;
            Delete_a();
            Delete_O();
        }
        check = false;
    }  
}


