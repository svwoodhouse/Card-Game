// -----------------------------------
// Name: Sydnee Woodhouse
// Email: svwoodhouse@gmail.com
// Date: July 26, 2016
// Project: Fulltime Project- Card Game
//------------------------------------

package card.game;

//---------------------------------------------
// This is an enum where I store the different
// card suits and rank them from highest to
// lowest.
//--------------------------------------------

public enum Suits 
{
   PENALTY(1),
   CLUB(2),
   DIAMOND(3),
   HEART(4),
   SPADE(5);  
    
    private final int cardSuit;
    
    // Getter and Setter for the cardSuit variable
    private Suits(int cardSuit)
    {
        this.cardSuit = cardSuit;
    }
    
    public int setSuit()
    {
        return cardSuit;
    }
}
