package fir.sec.thi.doxarts;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class Variable implements Listener {

    public static HashMap<String,Double> PlayerTotalStat = new HashMap<>();
    public static HashMap<String,Integer> money = new HashMap<>();
    public static HashMap<String,Integer> weapon = new HashMap<>();
    public static HashMap<String,Integer> accessory = new HashMap<>();
    public static HashMap<String,Double> base = new HashMap<>();
    public static HashMap<String,Integer> Stat = new HashMap<>();
    public static HashMap<String,String> win = new HashMap<>();
    public static HashMap<String,Integer> cooldown = new HashMap<>();

    public static void Cooldown(Player player){
        String name = player.getName();
        if (!(cooldown.get(name+"Potion") <= 0)){
            cooldown.put(name+"Potion", cooldown.get(name+"Potion") - 1);
        }
    }

}
