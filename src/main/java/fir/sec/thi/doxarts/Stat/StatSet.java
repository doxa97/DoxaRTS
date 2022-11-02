package fir.sec.thi.doxarts.Stat;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Objects;

import static fir.sec.thi.doxarts.Stat.Stats.getStat;
import static fir.sec.thi.doxarts.Variable.*;
import static fir.sec.thi.doxarts.Variable.base;

public class StatSet implements Listener {

    public static void StatSetting(Player player){

        long[] stat = getStat(player);
        String name = player.getName();

        Stat.put(name+"con", (int) stat[9]);
        Stat.put(name+"str", (int) stat[10]);
        Stat.put(name+"agi", (int) stat[11]);
        Stat.put(name+"int", (int) stat[12]);
        Stat.put(name+"dex", (int) stat[13]);

        PlayerTotalStat.put(name+"Health",(Stat.get(name+"con") * 25) + (Stat.get(name+"str") * 10) + (base.get(name+"health")));
        PlayerTotalStat.put(name+"Melee", (double) ((Stat.get(name+"str") * 6) + (Stat.get(name+"dex") * 3) + (weapon.get("meleeattack"))));
        PlayerTotalStat.put(name+"Magic", (double) ((Stat.get(name+"int") * 10) + (Stat.get(name+"dex") * 3) + (weapon.get("magicattack"))));
        PlayerTotalStat.put(name+"Critical", (double) ((Stat.get(name+"agi") * 3) + (Stat.get(name+"dex")) + (weapon.get("crit"))));
        PlayerTotalStat.put(name+"Movement", (Stat.get(name+"agi") * 0.05) + (base.get(name+"movement")));
        PlayerTotalStat.put(name+"AttackSpeed",(Stat.get(name+"agi") * 0.05) + (weapon.get("attackspeed")));
        PlayerTotalStat.put(name+"Regeneration", (double) (Stat.get(name+"con") * 3));


        double perexp = (double) stat[3] / stat[2];
        player.setExp(Float.parseFloat(String.format("%.2f", perexp)));
        player.setLevel((int) stat[0]);

        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(PlayerTotalStat.get(name+"AttackSpeed"));
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(PlayerTotalStat.get(name+"Movement"));
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(PlayerTotalStat.get(name+"Health"));

    }

}
















