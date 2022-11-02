package fir.sec.thi.doxarts;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import static fir.sec.thi.doxarts.Teams.board;

public class Spawn implements Listener {

    @EventHandler
    public void RedSpawn(PlayerSpawnLocationEvent event){
        Player player = event.getPlayer();
        if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
            Location loc = new Location(player.getWorld(), 0,30,0);
            event.setSpawnLocation(loc);
        }
    }

    @EventHandler
    public void BlueSpawn(PlayerSpawnLocationEvent event){
        Player player = event.getPlayer();
        if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
            Location loc = new Location(player.getWorld(), 0,30,0);
            event.setSpawnLocation(loc);
        }
    }

    @EventHandler
    public void NormalSpawn(PlayerSpawnLocationEvent event){
        Player player = event.getPlayer();
        if (!board.getEntryTeam(player.getName()).getName().equals("레드팀") && !board.getEntryTeam(player.getName()).getName().equals("블루팀")){
            Location loc = new Location(player.getWorld(),0,30,0);
            event.setSpawnLocation(loc);
        }
    }

}
