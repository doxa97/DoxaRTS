package fir.sec.thi.doxarts;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class Level implements Listener {

    @EventHandler
    public void getExp(PlayerExpChangeEvent e){
        Player player = e.getPlayer();
        long[] stat;
        stat = Stats.getStat(player);
        int exp = e.getAmount();
        e.setAmount(0);
        stat[3] = stat[3] + exp;
        Stats.LevelUP(stat,player);
        Stats.setStat(player,stat);
    }

}
