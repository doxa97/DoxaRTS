package fir.sec.thi.doxarts;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static fir.sec.thi.doxarts.Variable.base;

public class BaseStat implements Listener {

    public static void BaseStatSetting(Player player) {
        String name = player.getName();
        if (player.getScoreboardTags().isEmpty()){
            base.put(name+"health",20.0);
            base.put(name+"movement",0.1);
        }
        if (player.getScoreboardTags().contains("worrier")){
            base.put(name+"health",45.0);
            base.put(name+"movement",0.08);
        }
        if (player.getScoreboardTags().contains("swordsman")){
            base.put(name+"health",32.0);
            base.put(name+"movement",0.1);
        }
        if (player.getScoreboardTags().contains("assassin")){
            base.put(name+"health",17.0);
            base.put(name+"movement",0.12);
        }
        if (player.getScoreboardTags().contains("archer")){
            base.put(name+"health",23.0);
            base.put(name+"movement",0.11);
        }
        if (player.getScoreboardTags().contains("magician")){
            base.put(name+"health",20.0);
            base.put(name+"movement",0.09);
        }

    }

}