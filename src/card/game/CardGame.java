// --------------------------------------------------------
// Name: Sydnee Woodhouse
// Email: svwoodhouse@gmail.com
// Date: July 26, 2016
// Project: Fulltime Project- Card Game
// Description: This card game is for 2-4 players. It
// allows each player to draw a card from the deck.
// Whoever has the highest ranked card in the deck
// gets 2 points added to their score and any player that
// gets a penalty card, gets 1 point of their  score.
//---------------------------------------------------------


package card.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame 
{
    public static void main(String[] args) 
    {
        int numOfPlayers;
        boolean loop = true;
        int rounds = 1;
        String winner;
        int totalCards;
        int numOfRounds;
        
        int highScore = 0; 
        int secondHighest = 0;
        
        // Creates a new deck and an arraylist to hold all of the players 
        Deck d = new Deck();
        ArrayList <Player> players = new ArrayList<Player>();
 
        // Main Menu
        System.out.println("*****************************************");
        System.out.println("**              Card Game              **");
        System.out.println("*****************************************");
        System.out.println("**     Enter the number of players:    **");
        System.out.println("*****************************************");
        
            // Gets number of players from the user
                Scanner keyboard = new Scanner(System.in);
                numOfPlayers = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println();
                // Checks to make that the user entered a number between 2 - 4 reperesenting the number of players
                // If users enters an invalid number, asks for another number until user enters a number between 2 and 4
                while (numOfPlayers < 2 || numOfPlayers > 4)
                {
                    System.out.println("Number of players: ");
                    numOfPlayers = keyboard.nextInt();
                }
                
                // Creates the number of players from the Player class called p and adds them to an arraylist called players
                for(int i = 1; i <= numOfPlayers; i++)
                {
                    Player p = new Player(0,"Player " + Integer.toString(i));
                    players.add(p);
                }
                
                if(56 % numOfPlayers != 0)
                {
                    numOfRounds = (56 -(56 % numOfPlayers) )/ numOfPlayers;
                }
                else
                    numOfRounds = 56 / numOfPlayers;
                
                totalCards = numOfRounds * numOfPlayers;
                int p = 0;

                    System.out.println("---------------");
                    System.out.println("    Round " + rounds);   
                    System.out.println("---------------");
                    
                // Main loop for the game. Runs until one player has a score of 21 or higher and is leading by 2 points
            while(loop)
            {
                // This for loop, hands out to each player a card until it is out of cards or a player reaches 21 or more and is leading by 2 points
                for(int i = 0; i < totalCards; i++)
                {
                    //------------------------------------------------------------------------
                    // Loop checks to see if a player is the champion and ends the game if so
                    // Finds the highest score and the second highest score and sees if the
                    // highest score is leading by 2 points. If so, ends the while loop
                    // which ends the game
                    //-------------------------------------------------------------------------
                    
                    for(int l = 0; l < players.size(); l++)
                    {
                        if(players.get(l).score > highScore)
                        {
                            secondHighest = highScore;
                            highScore = players.get(l).score;
                        }
                        else if(players.get(l).score > secondHighest)
                        {
                            secondHighest = players.get(l).score;
                        }
                    }
                    
                if(highScore >= 21 && (highScore - secondHighest) >= 2)
                {
                    for(int o= 0; o < players.size(); o++)
                    {
                        if(players.get(o).score == highScore)
                        {
                            System.out.println("----------------------------------");
                            System.out.println("   " + players.get(o).name + " is the champion!");
                            System.out.println("----------------------------------");
                            
                        }
                    }
                    loop = false;
                    break;
                }

                    System.out.println("");
                    System.out.println("Player " + (p + 1));
                    System.out.println("Press ENTER to get a card");
                    keyboard.nextLine();
                    
                    //--------------------------------------------------------------------------------
                    // This makes each player get a card. P is a variable that loops for each player
                    // The variable i is to loop through each card in the deck and gives one to
                    // each player and shows the player their card.
                    //---------------------------------------------------------------------------------
                    
                    players.get(p).getCard(i);
                    System.out.println("Your card is: " + players.get(p).playerCard);
                    
                    //--------------------------------------------------------------------------------------
                    // Checks to see if p is the same number as the number of players.
                    // If it is, it resets p to zero allwing the first player to draw a new card next round
                    // Announces the winner of the round and displays the round number
                    // Gives the winner of the round 2 points to their score and displays the scoreboard
                    //--------------------------------------------------------------------------------------
                    
                    if (p == numOfPlayers - 1)
                    {
                        p = 0;
                        
                        //Finds the winner of the round using the compareCard method
                        winner = compareCards(players);
                        
                        System.out.println();
                        System.out.println("------------------------------------------");
                        System.out.println("  Winner of Round " + rounds +": " + winner);
                        System.out.println("------------------------------------------");

                        // Finds the winner by using the string that was returned in the compareCards method
                        // and stored in the variable winner and adds 2 points to their score
                        switch (winner)
                        {
                            case "Player 1": players.get(0).score +=2;
                                                break;
                            case "Player 2": players.get(1).score +=2;
                                                break;
                            case "Player 3": players.get(2).score +=2;
                                                break;
                            case "Player 4": players.get(3).score +=2;
                        }
                        
                        System.out.println();
                        System.out.println("--------------------------------");
                        System.out.println("           ScoreBoard           ");
                        System.out.println("--------------------------------");
                        
                        // Displays each players score
                        for(int k = 0; k < players.size(); k++)
                        {
                            System.out.println(players.get(k).name + ": " + players.get(k).score);
                        }
                        
                        System.out.println("--------------------------------");
                        System.out.println("--------------------------------");
                        System.out.println();
                        rounds++;         
                    System.out.println("---------------");
                    System.out.println("    Round " + rounds);   
                    System.out.println("---------------");
                    }
                    
                    // if p is not equal to the last player, it adds one onto p
                    else 
                        p++;
                }
            }
}
    //---------------------------------------------------------------------------
    // Function that compares each players cards after each player selects a card
    // and finds the highest ranked card. It then returns the name of the winner 
    // in a string
    //----------------------------------------------------------------------------
    
    public static String compareCards(ArrayList<Player> a)
    {
        String winner = null;
        int winnerSuit = 0;
        int winnerRank = 0;
        
        // Goes through each players cards
        for(int i = 0; i < a.size(); i++)
        {
            // Checks to see if player has a penalty card and takes one point off their score
            // unless the score is already zero
            if(a.get(i).cSuit == 1 && a.get(i).score != 0)
            {
                a.get(i).score -=1;
            }
            
            //-------------------------------------------------------------------------------------
            // If card is the same suit (based on numerical number given in the enum Suits)
            // it then compares the rank (based on the numerical number given in the enum CardRank)
            // of the card to see which is greater
            //--------------------------------------------------------------------------------------
            
            if(a.get(i).cSuit == winnerSuit && a.get(i).cRank > winnerRank)
            {
              winnerSuit = a.get(i).cSuit;
              winnerRank = a.get(i).cRank;
              winner = a.get(i).name;
            }
            
            //Checks to see which player suit is the highest
            if(a.get(i).cSuit > winnerSuit)
            {
              winnerSuit = a.get(i).cSuit;
              winnerRank = a.get(i).cRank;
              winner = a.get(i).name;
            } 
        } 
        return winner;
    }
}

