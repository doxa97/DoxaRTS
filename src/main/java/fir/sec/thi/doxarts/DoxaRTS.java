package fir.sec.thi.doxarts;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


import static fir.sec.thi.doxarts.BaseStat.BaseStatSetting;
import static fir.sec.thi.doxarts.EquipItem.AccessoryAndEquipment;
import static fir.sec.thi.doxarts.Skill.DamageSet;
import static fir.sec.thi.doxarts.StatSet.StatSetting;
import static fir.sec.thi.doxarts.Variable.*;
import static fir.sec.thi.doxarts.Win.BlueWin;
import static fir.sec.thi.doxarts.Win.RedWin;


public final class DoxaRTS extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new Stats(), this);
        getServer().getPluginManager().registerEvents(new AttackEvent(),this);
        getServer().getPluginManager().registerEvents(new Level(),this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new GUI(), this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
        getServer().getPluginManager().registerEvents(new Variable(), this);
        getServer().getPluginManager().registerEvents(new Teams(), this);
        getServer().getPluginManager().registerEvents(new Spawn(), this);
        getServer().getPluginManager().registerEvents(new Upgrade(),this);

        getCommand("게임시작").setExecutor(new Command());
        getCommand("초기화").setExecutor(new Command());
        getCommand("참가").setExecutor(new Command());
        getCommand("직업").setExecutor(new Command());
        getCommand("스탯").setExecutor(new Command());

        getLogger().info("RTS ON!");
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {

            for (Player player : getServer().getOnlinePlayers()) {
                String name = player.getName();

                DamageSet(player);
                BaseStatSetting(player);
                AccessoryAndEquipment(player);
                StatSetting(player);

                if (win.get("win").equals("blue")){
                    BlueWin(player);
                }
                if (win.get("win").equals("red")){
                    RedWin(player);
                }

            }
        },0,0);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : getServer().getOnlinePlayers()){
                String name = player.getName();
                player.setHealth(player.getHealth() + PlayerTotalStat.get(name+"Regeneration"));
            }
        },60,0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RTS OFF!");
    }


}
