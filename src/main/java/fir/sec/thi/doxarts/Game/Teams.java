package fir.sec.thi.doxarts.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Teams implements Listener {

    static ScoreboardManager manager = Bukkit.getScoreboardManager();
    public static Scoreboard board = manager.getNewScoreboard();
    static Team RedTeam = board.registerNewTeam("레드팀");
    static Team BlueTeam = board.registerNewTeam("블루팀");

    public static void RedTeamJoin(Player player){
        RedTeam.setCanSeeFriendlyInvisibles(true);
        RedTeam.setColor(ChatColor.RED);
        RedTeam.setAllowFriendlyFire(false);
        RedTeam.setDisplayName(ChatColor.RED+"레드팀");
        RedTeam.setPrefix(ChatColor.RED + "[ 레드 ]");
        if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
            BlueTeam.removeEntry(player.getName());
        }
        RedTeam.addEntry(player.getName());
    }

    public static void BlueTeamJoin(Player player){
        BlueTeam.setCanSeeFriendlyInvisibles(true);
        BlueTeam.setColor(ChatColor.AQUA);
        BlueTeam.setAllowFriendlyFire(false);
        BlueTeam.setDisplayName(ChatColor.AQUA+"블루팀");
        BlueTeam.setPrefix(ChatColor.AQUA + "[ 블루 ]");
        if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
            RedTeam.removeEntry(player.getName());
        }
        BlueTeam.addEntry(player.getName());
    }

    public static void TeamLeave(Player player){
        if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
            RedTeam.removeEntry(player.getName());
        }
        if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
            BlueTeam.removeEntry(player.getName());
        }
    }

}
