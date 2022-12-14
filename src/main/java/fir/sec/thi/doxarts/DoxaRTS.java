package fir.sec.thi.doxarts;

import fir.sec.thi.doxarts.Game.*;
import fir.sec.thi.doxarts.Gui.GUI;
import fir.sec.thi.doxarts.Gui.Item;
import fir.sec.thi.doxarts.Shop.BuyAndSell;
import fir.sec.thi.doxarts.Shop.Money;
import fir.sec.thi.doxarts.Shop.SkillSet;
import fir.sec.thi.doxarts.Shop.Upgrade;
import fir.sec.thi.doxarts.Skill.Skill;
import fir.sec.thi.doxarts.Stat.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


import static fir.sec.thi.doxarts.Shop.Money.PerinActionBar;
import static fir.sec.thi.doxarts.Stat.BaseStat.BaseStatSetting;
import static fir.sec.thi.doxarts.Stat.EquipItem.AccessoryAndEquipment;
import static fir.sec.thi.doxarts.Skill.Skill.DamageSet;
import static fir.sec.thi.doxarts.Stat.StatSet.StatSetting;
import static fir.sec.thi.doxarts.Variable.*;
import static fir.sec.thi.doxarts.Game.Win.BlueWin;
import static fir.sec.thi.doxarts.Game.Win.RedWin;


public final class DoxaRTS extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this,this);

        getServer().getPluginManager().registerEvents(new AttackEvent(),this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new Spawn(), this);
        getServer().getPluginManager().registerEvents(new Teams(), this);
        getServer().getPluginManager().registerEvents(new Win(), this);
        getServer().getPluginManager().registerEvents(new GUI(), this);
        getServer().getPluginManager().registerEvents(new Item(), this);
        getServer().getPluginManager().registerEvents(new BuyAndSell(), this);
        getServer().getPluginManager().registerEvents(new Money(), this);
        getServer().getPluginManager().registerEvents(new SkillSet(), this);
        getServer().getPluginManager().registerEvents(new Upgrade(), this);
        getServer().getPluginManager().registerEvents(new Skill(), this);
        getServer().getPluginManager().registerEvents(new BaseStat(), this);
        getServer().getPluginManager().registerEvents(new EquipItem(), this);
        getServer().getPluginManager().registerEvents(new Stats(), this);
        getServer().getPluginManager().registerEvents(new Level(),this);
        getServer().getPluginManager().registerEvents(new StatSet(), this);
        getServer().getPluginManager().registerEvents(new Variable(), this);

        getCommand("????????????").setExecutor(new Command());
        getCommand("?????????").setExecutor(new Command());
        getCommand("??????").setExecutor(new Command());
        getCommand("??????").setExecutor(new Command());
        getCommand("??????").setExecutor(new Command());
        getCommand("??????").setExecutor(new Command());
        getCommand("????????????").setExecutor(new Command());
        getCommand("????????????").setExecutor(new Command());

        getLogger().info("RTS ON!");
        getServer().getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            for (Player player : getServer().getOnlinePlayers()){
                player.sendMessage("0");
            }

            DamageSet();
            BaseStatSetting();
            AccessoryAndEquipment();
            StatSetting();
            PerinActionBar();

            if (!win.isEmpty()) {
                if (win.get("win").equals("blue")) {
                    BlueWin();
                }
                if (win.get("win").equals("red")) {
                    RedWin();
                }
            }
        },0,1);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : getServer().getOnlinePlayers()){
                player.sendMessage("20");
            }
            if (!cooldown.isEmpty()){
                Cooldown();
            }
        },20,1);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : getServer().getOnlinePlayers()){
                String name = player.getName();
                if (!PlayerTotalStat.isEmpty()){
                    player.setHealth(player.getHealth() + PlayerTotalStat.get(name+"Regeneration"));
                }
            }
        },60,0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RTS OFF!");
    }


}
