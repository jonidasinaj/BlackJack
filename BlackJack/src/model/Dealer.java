/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private Win m_win;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_win = a_rulesFactory.DoWinRule();
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  public void DealCard(Player a_player, boolean visible){
      Card c = m_deck.GetCard();
      c.Show(visible);
      a_player.DealCard(c);
  }
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
        m_deck = new Deck();
        ClearHand();
        a_player.ClearHand();
        return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
        DealCard(a_player, true);
      
        return true;
    }
    return false;
  }
  
  public boolean Stand(Player a_player) {
    if (m_deck != null) {
        ShowHand();

        while (m_hitRule.DoHit(this)) {
            DealCard(a_player, true);
        }
        return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_win.IsDealerWinner(a_player, this, g_maxScore);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
}