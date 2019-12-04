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
public interface IView extends model.CardObserver
{
  void DisplayWelcomeMessage();
  Operation GetInput();
  void DisplayCard(model.Card a_card);
  void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
}
