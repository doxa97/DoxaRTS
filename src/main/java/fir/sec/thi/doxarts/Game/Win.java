package fir.sec.thi.doxarts.Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static fir.sec.thi.doxarts.Gui.GUI.RunSound;
import static fir.sec.thi.doxarts.Variable.win;
import static org.bukkit.Bukkit.getServer;

public class Win implements Listener {

    public static void BlueWin(){
        for (Player player : getServer().getOnlinePlayers()) {
            win.remove("win");
            player.sendTitle("5", "블루팀이 승리하였습니다!", 10, 20, 20);
            RunSound(player, "start", 70, 1);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "초기화");
        }
    }

    public static void RedWin() {
        for (Player player : getServer().getOnlinePlayers()) {
            win.remove("win");
            player.sendTitle("5", "레드팀이 승리하였습니다!", 10, 20, 20);
            RunSound(player, "start", 70, 1);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "초기화");
        }
    }

}
