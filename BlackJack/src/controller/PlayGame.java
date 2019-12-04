/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.IView;
import model.Game;
import view.Operation;
/**
 *
 * @author Jonida
 */
public class PlayGame{
  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
	a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
	
    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    //int input = Integer.parseInt(a_view.GetInput());
    Operation input = a_view.GetInput();
    
    switch (input) {
        case Play:
            a_game.NewGame();
                break;
        case Hit:
            a_game.Hit();
            break;
        case Stand:
            a_game.Stand();
            break;
        default:
            break;
    }    
    return input != Operation.Quit;
  }
}
