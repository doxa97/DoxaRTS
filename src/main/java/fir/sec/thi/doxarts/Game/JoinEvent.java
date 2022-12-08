package fir.sec.thi.doxarts.Game;

import fir.sec.thi.doxarts.Stat.Stats;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

import static fir.sec.thi.doxarts.Variable.PlayerTotalStat;
import static fir.sec.thi.doxarts.Variable.cooldown;

public class JoinEvent implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String name = player.getName();
        if (player.getLevel() == 0) {
            Stats.CreateNewStat(player);
            player.setLevel(1);
            cooldown.put(name+"potion",0);
            PlayerTotalStat.put(name+"Regeneration",0.0);
        }
        e.setJoinMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "어서 오십시오, "+ player.getName() +" 용사님.");
    }


}
