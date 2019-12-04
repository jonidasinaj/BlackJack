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
import model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
}