package fir.sec.thi.doxarts;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class Item implements Listener {

    public static ItemStack NormalWeaponSetting(Player player, int CustomModel, String display, String lore, double attack, double attackspeed, double critical, double drain, String Skill, String SkillLore){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        meta.setLore(Arrays.asList(
                "[ 무기 ]",
                lore,
                "공격력 : " +attack,
                "공격 속도 : " +attackspeed,
                "치명타 확률 : " +critical,
                "흡혈 : " +drain,
                "[ 첫번째 슬롯 ]",
                "[ " + Skill + " ]",
                SkillLore,
                "[ 두번째 슬롯 ]",
                "[ 비어 있음 ]",
                "[ 세번째 슬롯 ]",
                "[ 비어 있음 ]",
                "[ 네번째 슬롯 ]",
                "[ 비어 있음 ]"
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack MagicianWeaponSetting(Player player, int CustomModel, String display, String lore, double attack, double attackspeed, double critical, double drain){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        meta.setLore(Arrays.asList(
                "[ 무기 ]",
                lore,
                "공격력 : " +attack,
                "공격 속도 : " +attackspeed,
                "치명타 확률 : " +critical,
                "흡혈 : " +drain,
                "[ 첫번째 슬롯 ]",
                "[ 비어 있음 ]",
                "[ 두번째 슬롯 ]",
                "[ 비어 있음 ]",
                "[ 세번째 슬롯 ]",
                "[ 비어 있음 ]",
                "[ 네번째 슬롯 ]",
                "[ 비어 있음 ]"
        ));
        item.setItemMeta(meta);
        return item;
    }

}
