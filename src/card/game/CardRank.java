// -----------------------------------
// Name: Sydnee Woodhouse
// Email: svwoodhouse@gmail.com
// Date: July 26, 2016
// Project: Fulltime Project- Card Game
//------------------------------------

package card.game;

//---------------------------------------------
// This is an enum where I store the different
// card ranks and rank them from lowest to
// highest.
//--------------------------------------------

public enum CardRank 
{
    NEGATIVE(-1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
    
    private final int cardValue;
    
    // Getters and Setters for the private cardValue variable
    private CardRank(int cardValue)
    {
        this.cardValue = cardValue;
    }
    
    public int setRank()
    {
        return cardValue;
    }
}
