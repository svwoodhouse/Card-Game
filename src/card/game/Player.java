// -------------------------------------
// Name: Sydnee Woodhouse
// Email: svwoodhouse@gmail.com
// Date: July 26, 2016
// Project: Fulltime Project- Card Game
//--------------------------------------

package card.game;

public class Player extends Deck
{
    public int score;
    public String name;
    public String playerCard;
    public int cRank;
    public int cSuit;
    
    Player(int score, String name)
    {
        this.score = score;
        this.name = name;
    }
    
    public int setScore()
    {
        return score;
    }
    
    public String setName()
    {
        return name;
    }
    
   void getCard(int i)
    {
        playerCard = deck.get(i).rank.name() + " of " + deck.get(i).suit.name();
        cRank = deck.get(i).rank.setRank();
        cSuit = deck.get(i).suit.setSuit();
        //showCard(i);
    }
}
