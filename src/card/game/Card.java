// -----------------------------------
// Name: Sydnee Woodhouse
// Email: svwoodhouse@gmail.com
// Date: July 26, 2016
// Project: Fulltime Project- Card Game
//------------------------------------
package card.game;

import java.util.ArrayList;
import java.util.List;

//---------------------------------------------------
// This is the card class where I take the card suit
// and card rank enums and use them to create a card
//---------------------------------------------------
public class Card 
{
    public Suits suit;
    public CardRank rank;
    
    //Getters and Setters for the card's suit and rank
    Card(Suits suit, CardRank rank)
    {
        this.rank = rank;
        this.suit = suit;
    }
    
    public Suits getSuit()
    {
        return suit;
    }
    
    public CardRank getRank()
    {
        return rank;
    }
}
