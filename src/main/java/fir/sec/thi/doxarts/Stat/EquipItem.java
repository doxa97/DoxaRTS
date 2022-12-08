package fir.sec.thi.doxarts.Stat;

import fir.sec.thi.doxarts.Gui.GUI;
import fir.sec.thi.doxarts.Stat.Stats;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static fir.sec.thi.doxarts.Gui.GUI.RunSound;
import static fir.sec.thi.doxarts.Stat.Stats.getStat;
import static fir.sec.thi.doxarts.Variable.accessory;
import static fir.sec.thi.doxarts.Variable.weapon;
import static org.bukkit.Bukkit.getServer;

public class EquipItem implements Listener {

    public static void AccessoryAndEquipment() {
        for (Player player : getServer().getOnlinePlayers()) {

            String name = player.getName();

            long[] stat = getStat(player);

            if (player.getInventory().getItem(9).getType() == Material.AIR) {
                player.getInventory().setItem(9, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                        Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]", ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
            }
            if (player.getInventory().getItem(10).getType() == Material.AIR) {
                player.getInventory().setItem(10, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                        Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]", ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
            }
            if (player.getInventory().getItem(11).getType() == Material.AIR) {
                player.getInventory().setItem(11, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                        Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]", ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
            }
            if (player.getInventory().getItem(12).getType() == Material.AIR) {
                player.getInventory().setItem(12, GUI.GuiTool(Material.GRAY_STAINED_GLASS_PANE, ChatColor.DARK_GRAY + "[ 비어 있음 ]",
                        Arrays.asList(ChatColor.DARK_BLUE + "[ 장신구 ]", ChatColor.GRAY + "해당 장비란에 장신구를 넣어주세요."), 10000));
            }

            ItemStack EquipWeapon = player.getInventory().getItem(0);
            ItemStack FirstAccessory = player.getInventory().getItem(9);
            ItemStack SecondAccessory = player.getInventory().getItem(10);
            ItemStack ThirdAccessory = player.getInventory().getItem(11);
            ItemStack FourthAccessory = player.getInventory().getItem(12);

            if (EquipWeapon.getType() != Material.STICK) {
                weapon.put(name + "meleeattack", 1);
                weapon.put(name + "magicattack", 0);
                weapon.put(name + "drain", 0);
                weapon.put(name + "crit", 0);
                weapon.put(name + "attackspeed", 1);
            } else if (EquipWeapon.getType() == Material.STICK) {
                ItemMeta meta = EquipWeapon.getItemMeta();
                for (int i = 0; i <= meta.getLore().size(); i++) {
                    if (meta.getLore().get(i).contains("물리 공격력 :")) {
                        weapon.put(name + "meleeattack", Integer.valueOf(meta.getLore().get(i).replace(" ", "")
                                .replace("공격력", "").replace(":", "").replace("물리", "")));
                    }
                    if (meta.getLore().get(i).contains("마법 공격력 :")) {
                        weapon.put(name + "magicattack", Integer.valueOf(meta.getLore().get(i).replace(" ", "")
                                .replace("공격력", "").replace(":", "").replace("마법", "")));
                    }
                    if (meta.getLore().get(i).contains("공격 속도 :")) {
                        weapon.put(name + "attackspeed", Integer.valueOf(meta.getLore().get(i).replace(" ", "")
                                .replace("공격", "").replace(":", "").replace("속도", "")));
                    }
                    if (meta.getLore().get(i).contains("흡혈 :")) {
                        weapon.put(name + "drain", Integer.valueOf(meta.getLore().get(i).replace(" ", "")
                                .replace("흡혈", "").replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("치명타 확률 :")) {
                        weapon.put(name + "crit", Integer.valueOf(meta.getLore().get(i).replace(" ", "")
                                .replace("치명타", "").replace(":", "").replace("확률", "")));
                    }
                }
            }

            if (FirstAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE) {
                accessory.put(name + "1con", 0);
                accessory.put(name + "1str", 0);
                accessory.put(name + "1agi", 0);
                accessory.put(name + "1int", 0);
                accessory.put(name + "1dex", 0);
            } else if (FirstAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                ItemMeta meta = FirstAccessory.getItemMeta();
                for (int i = 0; i <= meta.getLore().size(); i++) {
                    if (meta.getLore().get(i).contains("활력")) {
                        accessory.put(name + "1con", Integer.valueOf(meta.getLore().get(i).
                                replace("활력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("근력")) {
                        accessory.put(name + "1str", Integer.valueOf(meta.getLore().get(i).
                                replace("근력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("민첩")) {
                        accessory.put(name + "1agi", Integer.valueOf(meta.getLore().get(i).
                                replace("민첩", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("지력")) {
                        accessory.put(name + "1int", Integer.valueOf(meta.getLore().get(i).
                                replace("지력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("손재주")) {
                        accessory.put(name + "1dex", Integer.valueOf(meta.getLore().get(i).
                                replace("손재주", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                }
            }
            if (SecondAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE) {
                accessory.put(name + "2con", 0);
                accessory.put(name + "2str", 0);
                accessory.put(name + "2agi", 0);
                accessory.put(name + "2int", 0);
                accessory.put(name + "2dex", 0);
            } else if (SecondAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                ItemMeta meta = SecondAccessory.getItemMeta();
                for (int i = 0; i <= meta.getLore().size(); i++) {
                    if (meta.getLore().get(i).contains("활력")) {
                        accessory.put(name + "2con", Integer.valueOf(meta.getLore().get(i).
                                replace("활력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("근력")) {
                        accessory.put(name + "2str", Integer.valueOf(meta.getLore().get(i).
                                replace("근력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("민첩")) {
                        accessory.put(name + "2agi", Integer.valueOf(meta.getLore().get(i).
                                replace("민첩", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("지력")) {
                        accessory.put(name + "2int", Integer.valueOf(meta.getLore().get(i).
                                replace("지력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("손재주")) {
                        accessory.put(name + "2dex", Integer.valueOf(meta.getLore().get(i).
                                replace("손재주", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                }
            }
            if (ThirdAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE) {
                accessory.put(name + "3con", 0);
                accessory.put(name + "3str", 0);
                accessory.put(name + "3agi", 0);
                accessory.put(name + "3int", 0);
                accessory.put(name + "3dex", 0);
            } else if (ThirdAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                ItemMeta meta = ThirdAccessory.getItemMeta();
                for (int i = 0; i <= meta.getLore().size(); i++) {
                    if (meta.getLore().get(i).contains("활력")) {
                        accessory.put(name + "3con", Integer.valueOf(meta.getLore().get(i).
                                replace("활력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("근력")) {
                        accessory.put(name + "3str", Integer.valueOf(meta.getLore().get(i).
                                replace("근력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("민첩")) {
                        accessory.put(name + "3agi", Integer.valueOf(meta.getLore().get(i).
                                replace("민첩", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("지력")) {
                        accessory.put(name + "3int", Integer.valueOf(meta.getLore().get(i).
                                replace("지력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("손재주")) {
                        accessory.put(name + "3dex", Integer.valueOf(meta.getLore().get(i).
                                replace("손재주", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                }
            }
            if (FourthAccessory.getType() == Material.GRAY_STAINED_GLASS_PANE) {
                accessory.put(name + "4con", 0);
                accessory.put(name + "4str", 0);
                accessory.put(name + "4agi", 0);
                accessory.put(name + "4int", 0);
                accessory.put(name + "4dex", 0);
            } else if (FourthAccessory.getType() != Material.GRAY_STAINED_GLASS_PANE) {
                ItemMeta meta = FourthAccessory.getItemMeta();
                for (int i = 0; i <= meta.getLore().size(); i++) {
                    if (meta.getLore().get(i).contains("활력")) {
                        accessory.put(name + "4con", Integer.valueOf(meta.getLore().get(i).
                                replace("활력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("근력")) {
                        accessory.put(name + "4str", Integer.valueOf(meta.getLore().get(i).
                                replace("근력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("민첩")) {
                        accessory.put(name + "4agi", Integer.valueOf(meta.getLore().get(i).
                                replace("민첩", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("지력")) {
                        accessory.put(name + "4int", Integer.valueOf(meta.getLore().get(i).
                                replace("지력", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                    if (meta.getLore().get(i).contains("손재주")) {
                        accessory.put(name + "4dex", Integer.valueOf(meta.getLore().get(i).
                                replace("손재주", "").replace(" ", "").replace("상승량", "").
                                replace(":", "")));
                    }
                }
            }

            if (player.getScoreboardTags().contains("assassin")) {
                if (!player.getInventory().getItemInOffHand().getItemMeta().getLore().contains("[ 무기 ]")) {
                    RunSound(player, "no", 70, 1);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "왼손에는 무기 이외 물건은 장착할 수 없습니다.");
                    ItemStack item = player.getInventory().getItemInOffHand();
                    player.getInventory().remove(item);
                    player.getInventory().addItem(item);
                }
            } else {
                if (player.getInventory().getItemInOffHand().getType() != Material.AIR) {
                    RunSound(player, "no", 70, 1);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "왼손에는 어떠한 것도 장착이 불가능합니다.");
                    ItemStack item = player.getInventory().getItemInOffHand();
                    player.getInventory().remove(item);
                    player.getInventory().addItem(item);
                }
            }

            for (int i = 1; i <= 4; i++) {
                stat[9] = stat[4] + accessory.get(name + i + "con");
                stat[10] = stat[5] + accessory.get(name + i + "str");
                stat[11] = stat[6] + accessory.get(name + i + "agi");
                stat[12] = stat[7] + accessory.get(name + i + "int");
                stat[13] = stat[8] + accessory.get(name + i + "dex");
            }
            Stats.setStat(player, stat);
        }
    }

}
