package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (player.getLevel() == 0) {
            Stats.CreateNewStat(player);
            player.setLevel(1);
        }
        e.setJoinMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "어서 오십시오, "+ player.getName() +" 용사님.");
    }


}
