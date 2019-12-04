/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rules;

/**
 *
 * @author Jonida
 */
import model.Deck;
import model.Dealer;
import model.Player;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    
	a_dealer.DealCard(a_player, true);
	a_dealer.DealCard(a_player, true);
	a_dealer.DealCard(a_player, true);
	a_dealer.DealCard(a_player, true);
  
    return true;
  }
}
