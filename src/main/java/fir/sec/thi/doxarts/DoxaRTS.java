package fir.sec.thi.doxarts;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;


public final class DoxaRTS extends JavaPlugin implements Listener {

    public static HashMap<String,Integer> weapon = new HashMap<>();
    public static HashMap<String,Integer> accessory = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new Stats(), this);
        getServer().getPluginManager().registerEvents(new AttackEvent(),this);
        getServer().getPluginManager().registerEvents(new Level(),this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getLogger().info("RTS ON!");
        getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers()) {
                    long[] stat = Stats.getStat(player.getUniqueId().toString());
                    double perexp = (double) stat[3] / stat[2];
                    player.setExp(Float.parseFloat(String.format("%.2f", perexp)));
                    player.setLevel((int) stat[0]);

                    for (int i = 0; i <= player.getInventory().getSize(); i++){
                        if (!(player.getInventory().getItem(i) == null) || !(Objects.requireNonNull(player.getInventory().getItem(i)).getType() == Material.AIR)) {
                            if (Objects.requireNonNull(Objects.requireNonNull(player.getInventory().getItem(i)).getItemMeta()).hasLore()) {
                                ItemMeta m = Objects.requireNonNull(player.getInventory().getItem(i)).getItemMeta();
                                if (Objects.requireNonNull(Objects.requireNonNull(m).getLore()).contains("[ 장신구 ]")){
                                    if (m.getLore().contains("활력 : ")){
                                        String con = String.valueOf(m.getLore().contains("활력 증가 : "));
                                        accessory.put(i+"con", Integer.valueOf(con.replace("활력 증가 : ","")));
                                    }
                                    if (m.getLore().contains("근력 : ")){
                                        String con = String.valueOf(m.getLore().contains("근력 증가 : "));
                                        accessory.put(i+"str", Integer.valueOf(con.replace("근력 증가 : ","")));
                                    }
                                    if (m.getLore().contains("민첩 : ")){
                                        String con = String.valueOf(m.getLore().contains("민첩 증가 : "));
                                        accessory.put(i+"agi", Integer.valueOf(con.replace("민첩 증가 : ","")));
                                    }
                                    if (m.getLore().contains("지력 : ")){
                                        String con = String.valueOf(m.getLore().contains("지력 증가 : "));
                                        accessory.put(i+"int", Integer.valueOf(con.replace("지력 증가 : ","")));
                                    }
                                    if (m.getLore().contains("손재주 : ")){
                                        String con = String.valueOf(m.getLore().contains("손재주 증가 : "));
                                        accessory.put(i+"dex", Integer.valueOf(con.replace("손재주 증가 : ","")));
                                    }
                                } else if (Objects.requireNonNull(Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getLore()).contains("[ 무기 ]")){
                                    ItemMeta mm = player.getInventory().getItemInMainHand().getItemMeta();
                                    if (mm.getLore().contains("근접 공격력 : ")){
                                        String melee = String.valueOf(mm.getLore().contains("근접 공격력 : "));
                                        weapon.put("melee", Integer.valueOf(melee.replace("근접 공격력 : ","")));
                                    }
                                    if (mm.getLore().contains("마법 공격력 : ")){
                                        String magic = String.valueOf(mm.getLore().contains("마법 공격력 : "));
                                        weapon.put("magic", Integer.valueOf(magic.replace("마법 공격력 : ","")));
                                    }
                                    if (mm.getLore().contains("원거리 공격력 : ")){
                                        String range = String.valueOf(mm.getLore().contains("원거리 공격력 : "));
                                        weapon.put("range", Integer.valueOf(range.replace("원거리 공격력 : ","")));
                                    }
                                    if (mm.getLore().contains("치명타 확률 : ")){
                                        String critical = String.valueOf(mm.getLore().contains("치명타 확률 : "));
                                        weapon.put("critical", Integer.valueOf(critical.replace("치명타 확률 : ","")));
                                    }
                                    if (mm.getLore().contains("이동 속도 : ")){
                                        String movement = String.valueOf(mm.getLore().contains("이동 속도 : "));
                                        weapon.put("movement", Integer.valueOf(movement.replace("이동 속도 : ","")));
                                    }
                                }
                            }
                        }
                        stat[9] = stat[4] + accessory.get(i+"con");
                        stat[10] = stat[5] + accessory.get(i+"str");
                        stat[11] = stat[6] + accessory.get(i+"agi");
                        stat[12] = stat[7] + accessory.get(i+"int");
                        stat[13] = stat[8] + accessory.get(i+"dex");
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
