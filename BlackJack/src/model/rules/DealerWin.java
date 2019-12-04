/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rules;
import model.Player;
/**
 *
 * @author Jonida
 */
public class DealerWin implements Win{
    public boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore){
        if(a_player.CalcScore() > g_maxScore){
            return true;
        }
        else if(a_dealer.CalcScore() > g_maxScore){
            return false;
        }
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}