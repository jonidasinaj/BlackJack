/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rules;
import model.Player;
import model.Card;
/**
 *
 * @author Jonida
 */
public class HitStrategy17 implements IHitStrategy{
    private int g_hitLimit = 17;
    public boolean DoHit(Player a_dealer){
        if(a_dealer.CalcNewScore() == g_hitLimit){
            for(Card c : a_dealer.GetHand()){
                if(c.GetValue() == Card.Value.Ace){
                    return true;
                }
            }
        }
        return a_dealer.CalcScore() < g_hitLimit;
    }   
}