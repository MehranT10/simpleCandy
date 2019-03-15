
package candy.crush;


public class gamePlay1 
{
    private int score;
    private int move;
    private final boolean g1 = true;
    public gamePlay1(int s, int m)
    {
        score = s;
        move = m;
        Pointplay start = new Pointplay(score, move,"no", 0, g1);
    }
    
}
