package model.rules;
import model.Player;
/**
 *
 * @author Jonida
 */
public interface Win {
    boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore);
}
