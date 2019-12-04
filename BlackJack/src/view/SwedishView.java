/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
//import model.CardObserver;
/**
 *
 * @author Jonida
 */
public class SwedishView implements IView 
{
    public void DisplayWelcomeMessage()
    {

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
    }

    public Operation GetInput()
    {
      try {
        int c = System.in.read();
        do {
            c = System.in.read();
            switch (c) {
            case 'h':
                    return Operation.Hit;
            case 'p':
                    return Operation.Play;
            case 's':
                    return Operation.Stand;
            case 'q':
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
        if (a_card.GetColor() == model.Card.Color.Hidden)
        {
            System.out.println("Dolt Kort");
        }
        else
        {
            String colors[] = 
                { "Hjärter", "Spader", "Ruter", "Klöver" };
            String values[] =  
                { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }
    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Spelare", a_hand, a_score);
    }
    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Croupier", a_hand, a_score);
    }
    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("Slut: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Croupiern Vann!");
        }
        else
        {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Har: " + a_score);
        for(model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_score);
        System.out.println("");
    }
}
