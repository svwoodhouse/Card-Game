// ---------------------------------------
// Name: Sydnee Woodhouse
// Email: svwoodhouse@gmail.com
// Date: July 26, 2016
// Project: Fulltime Project- Card Game
//----------------------------------------

package card.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    // An array list to hold all the card objects
    public ArrayList<Card> deck;
    
    // Constructor that creates a deck anytime a new Deck object is created
    public Deck()
    {
        // Creates a new array list
        this.deck = new ArrayList<>();
        
        // For loops that loops through each suit and card rank and adds them to the arraylist to create a deck
        for(int i = 1; i < 5; i++)
        {
            // First loops through one suite at a time
            Suits s = Suits.values()[i];
            
            // Using that suite and loops through each of the card ranks
            for(int j = 1; j < 14; j++)
            {
                Card card = new Card(s,CardRank.values()[j]);
               
                // Adds cards to the deck
                this.deck.add(card);
            }
        }  
        
        // Adds penalty cards to the deck
        
        for(int i = 0; i < 4; i++)
        {
            Card c = new Card(Suits.PENALTY,CardRank.NEGATIVE);
            this.deck.add(c);
        }
        // Shuffles the deck
        Collections.shuffle(deck); 
    }
    
    public void showCard(int i)
    {
        System.out.println(deck.get(i).rank.toString()+ " of " + deck.get(i).suit.toString());
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }
}
