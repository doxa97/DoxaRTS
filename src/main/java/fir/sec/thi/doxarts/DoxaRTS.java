package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Objects;

import static fir.sec.thi.doxarts.Variable.accessory;
import static fir.sec.thi.doxarts.Variable.weapon;


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

        getCommand("게임시작").setExecutor(new Command());
        getCommand("초기화").setExecutor(new Command());
        getCommand("참가").setExecutor(new Command());


        getLogger().info("RTS ON!");
        getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers()) {
                    long[] stat = Stats.getStat(player.getUniqueId().toString());
                    double perexp = (double) stat[3] / stat[2];
                    player.setExp(Float.parseFloat(String.format("%.2f", perexp)));
                    player.setLevel((int) stat[0]);

                    if (player.getInventory().getItem(9).getType() == null || player.getInventory().getItem(9).getType() == Material.AIR){
                        player.getInventory().setItem(9, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                                Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]",ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
                    }
                    if (player.getInventory().getItem(10).getType() == null || player.getInventory().getItem(10).getType() == Material.AIR){
                        player.getInventory().setItem(10, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                                Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]",ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
                    }
                    if (player.getInventory().getItem(11).getType() == null || player.getInventory().getItem(11).getType() == Material.AIR){
                        player.getInventory().setItem(11, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                                Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]",ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
                    }if (player.getInventory().getItem(12).getType() == null || player.getInventory().getItem(12).getType() == Material.AIR){
                        player.getInventory().setItem(12, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                                Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]",ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
                    }

                    ItemStack FirstAccessory = player.getInventory().getItem(9);
                    ItemStack SecondAccessory = player.getInventory().getItem(10);
                    ItemStack ThirdAccessory = player.getInventory().getItem(11);
                    ItemStack FourthAccessory = player.getInventory().getItem(12);

                    if (FirstAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE){
                        accessory.put("1con", 0);
                        accessory.put("1str", 0);
                        accessory.put("1agi", 0);
                        accessory.put("1int", 0);
                        accessory.put("1dex", 0);
                    }
                    else if (FirstAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                        ItemMeta meta = FirstAccessory.getItemMeta();
                        for (int i = 0; i <= meta.getLore().size(); i++) {
                            if (meta.getLore().get(i).contains("활력")) {
                                accessory.put("1con", Integer.valueOf(meta.getLore().get(i).
                                        replace("활력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("근력")) {
                                accessory.put("1str", Integer.valueOf(meta.getLore().get(i).
                                        replace("근력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("민첩")) {
                                accessory.put("1agi", Integer.valueOf(meta.getLore().get(i).
                                        replace("민첩", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("지력")) {
                                accessory.put("1int", Integer.valueOf(meta.getLore().get(i).
                                        replace("지력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("손재주")) {
                                accessory.put("1dex", Integer.valueOf(meta.getLore().get(i).
                                        replace("손재주", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                        }
                    }
                    if (SecondAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE){
                        accessory.put("2con", 0);
                        accessory.put("2str", 0);
                        accessory.put("2agi", 0);
                        accessory.put("2int", 0);
                        accessory.put("2dex", 0);
                    }
                    else if (SecondAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                        ItemMeta meta = SecondAccessory.getItemMeta();
                        for (int i = 0; i <= meta.getLore().size(); i++) {
                            if (meta.getLore().get(i).contains("활력")) {
                                accessory.put("2con", Integer.valueOf(meta.getLore().get(i).
                                        replace("활력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("근력")) {
                                accessory.put("2str", Integer.valueOf(meta.getLore().get(i).
                                        replace("근력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("민첩")) {
                                accessory.put("2agi", Integer.valueOf(meta.getLore().get(i).
                                        replace("민첩", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("지력")) {
                                accessory.put("2int", Integer.valueOf(meta.getLore().get(i).
                                        replace("지력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("손재주")) {
                                accessory.put("2dex", Integer.valueOf(meta.getLore().get(i).
                                        replace("손재주", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                        }
                    }
                    if (ThirdAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE){
                        accessory.put("3con", 0);
                        accessory.put("3str", 0);
                        accessory.put("3agi", 0);
                        accessory.put("3int", 0);
                        accessory.put("3dex", 0);
                    }
                    else if (ThirdAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                        ItemMeta meta = ThirdAccessory.getItemMeta();
                        for (int i = 0; i <= meta.getLore().size(); i++) {
                            if (meta.getLore().get(i).contains("활력")) {
                                accessory.put("3con", Integer.valueOf(meta.getLore().get(i).
                                        replace("활력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("근력")) {
                                accessory.put("3str", Integer.valueOf(meta.getLore().get(i).
                                        replace("근력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("민첩")) {
                                accessory.put("3agi", Integer.valueOf(meta.getLore().get(i).
                                        replace("민첩", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("지력")) {
                                accessory.put("3int", Integer.valueOf(meta.getLore().get(i).
                                        replace("지력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("손재주")) {
                                accessory.put("3dex", Integer.valueOf(meta.getLore().get(i).
                                        replace("손재주", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                        }
                    }
                    if (FourthAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE){
                        accessory.put("4con", 0);
                        accessory.put("4str", 0);
                        accessory.put("4agi", 0);
                        accessory.put("4int", 0);
                        accessory.put("4dex", 0);
                    }
                    else if (FourthAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                        ItemMeta meta = FourthAccessory.getItemMeta();
                        for (int i = 0; i <= meta.getLore().size(); i++) {
                            if (meta.getLore().get(i).contains("활력")) {
                                accessory.put("4con", Integer.valueOf(meta.getLore().get(i).
                                        replace("활력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("근력")) {
                                accessory.put("4str", Integer.valueOf(meta.getLore().get(i).
                                        replace("근력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("민첩")) {
                                accessory.put("4agi", Integer.valueOf(meta.getLore().get(i).
                                        replace("민첩", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("지력")) {
                                accessory.put("4int", Integer.valueOf(meta.getLore().get(i).
                                        replace("지력", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                            if (meta.getLore().get(i).contains("손재주")) {
                                accessory.put("4dex", Integer.valueOf(meta.getLore().get(i).
                                        replace("손재주", "").replace(" ", "").replace("상승량", "").
                                        replace(":", "")));
                            }
                        }
                    }
                    for (int i = 1; i <= 4 ; i++){
                        stat[9] = stat[4] + accessory.get(i+"con") + weapon.get("con");
                        stat[10] = stat[5] + accessory.get(i+"str") + weapon.get("str");
                        stat[11] = stat[6] + accessory.get(i+"agi") + weapon.get("agi");
                        stat[12] = stat[7] + accessory.get(i+"int") + weapon.get("int");
                        stat[13] = stat[8] + accessory.get(i+"dex") + weapon.get("dex");
                    }
                    Stats.setStat(player.getUniqueId().toString(),stat);
                    Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue((double) (1 + stat[11])/100);
                    Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue((double) 30 + stat[9]);
                }
            }
        },0,0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RTS OFF!");
    }


}
