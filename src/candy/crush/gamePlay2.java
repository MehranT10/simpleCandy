
package candy.crush;


public class gamePlay2 
{
    private int scorecandy;
    private String candy;
    private final boolean g1 = false;
    public gamePlay2(int s,String c)
    {
        scorecandy = s;
        candy = c;
        Pointplay start = new Pointplay(0, 100,candy, scorecandy, g1);
        
    }
    
}
