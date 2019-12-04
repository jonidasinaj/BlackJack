/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
/**
 *
 * @author Jonida
 */
public class SimpleView implements IView 
{

    public void DisplayWelcomeMessage()
      {
        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
      }

    public Operation GetInput()
    {
      try {
        int c = System.in.read();
        do {
            c = System.in.read();
            switch (c) {
            case 'h':
            case 'H':
                    return Operation.Hit;
            case 'p':
            case 'P':
                    return Operation.Play;
            case 's':
            case 'S':
                    return Operation.Stand;
            case 'q':
            case 'Q':
                    return Operation.Quit;
            default:
                    break;
            }
        }while (c == '\r' || c == '\n');
        return Operation.Default;
        //return c;
      } catch (java.io.IOException e) {
        System.out.println("" + e);
        return Operation.Default;
        //return 0;
      }
    }

    public void update(){
        try {
                System.out.println("PAUSE");
                Thread.sleep(2000);
        } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
        }
    }

    public void DisplayCard(model.Card a_card)
    {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Has: ");
        for(model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Dealer Won!");
        }
        else
        {
            System.out.println("You Won!");
        }

    }
}
