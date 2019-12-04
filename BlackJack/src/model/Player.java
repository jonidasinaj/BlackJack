/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 *
 * @author Jonida
 */

public class Player {

    private List<Card> m_hand;
    protected final int g_maxScore = 21;
    public ArrayList<CardObserver> m_observer;

  public Player()
  {
  
    m_hand = new LinkedList<Card>();
    System.out.println("Hello List World");
    m_observer = new ArrayList<CardObserver>();
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand);
    notifyMember();
  }
  
  public Iterable<Card> GetHand()
  {
    return m_hand;
  }
  
  public void ClearHand()
  {
    m_hand.clear();
  }
  
  public void ShowHand()
  {
    for(Card c : m_hand)
    {
      c.Show(true);
      notifyMember();
    }
  }
  
  public void addMember(CardObserver obs){
      m_observer.add(obs);
  }
  
 /* public void removeMember(){
        m_observer = null;
  }*/
  
  private void notifyMember(){
      for(CardObserver a_observer : m_observer){
          a_observer.update();
      }
  }
  
  
    public int CalcNewScore(){
        int cardScores[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11};
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
    
        int score = 0;

        for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
        }
    }
    return score;
    } 
    
    public int CalcScore()
  {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int score = CalcNewScore();
    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }
    return score;
  }
}
