package fir.sec.thi.doxarts;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class Spawn implements Listener {

    public void RedSpawn(PlayerSpawnLocationEvent event){
        Player player = event.getPlayer();
        if (player.getScoreboard().getTeams().equals("레드팀")){
            Location loc = new Location(player.getWorld(), 0,30,0);
            event.setSpawnLocation(loc);
        }
    }

    public void BlueSpawn(PlayerSpawnLocationEvent event){
        Player player = event.getPlayer();
        if (player.getScoreboard().getTeams().equals("블루팀")){
            Location loc = new Location(player.getWorld(), 0,30,0);
            event.setSpawnLocation(loc);
        }
    }

}
