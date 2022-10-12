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
        long[] stat = Stats.getStat(player.getUniqueId().toString());
        if (!(stat[0] > 0)){
            Stats.CreateNewStat(player.getUniqueId().toString());
        }
        e.setJoinMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "어서 오십시요, "+ e.getPlayer() +" 용사님.");
    }


}
