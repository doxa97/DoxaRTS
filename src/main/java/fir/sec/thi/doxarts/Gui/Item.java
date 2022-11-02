package fir.sec.thi.doxarts.Gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class Item implements Listener {

    public static ItemStack NormalWeaponSetting(int CustomModel, String display, String lore, double meleeattack, double magicattack, double attackspeed, double critical, double drain, String Skill, String SkillLore){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        meta.setLore(Arrays.asList(
                "[ 무기 ]",
                "강화 수치 : 0",
                lore,
                "물리 공격력 : " +meleeattack,
                "마법 공격력 : " +magicattack,
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

    public static ItemStack MagicianWeaponSetting(int CustomModel, String display, String lore, double meleeattack, double magicattack, double attackspeed, double critical, double drain){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        meta.setLore(Arrays.asList(
                "[ 무기 ]",
                "강화 수치 : 0",
                lore,
                "물리 공격력 : " +meleeattack,
                "마법 공격력 : " +magicattack,
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

    public static ItemStack ShopNormalWeaponSetting(int CustomModel, String display, String lore, double meleeattack, double magicattack, double attackspeed, double critical, double drain, String Skill, String SkillLore, int sell){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        meta.setLore(Arrays.asList(
                "========[ 상점 ]========",
                "[ 무기 ]",
                "강화 수치 : 0",
                lore,
                "물리 공격력 : " +meleeattack,
                "마법 공격력 : " +magicattack,
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
                "[ 비어 있음 ]",
                "========[ 비용 ]========",
                "판매 비용 : " + sell + " 페린"
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack ShopAccessorySetting(int CustomModel, String display, String lore, double Con, double Str, double Agi, double Int, double Dex, int sell){
        ItemStack item = new ItemStack(Material.WITHER_ROSE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        meta.setLore(Arrays.asList(
                "========[ 상점 ]========",
                "[ 장신구 ]",
                lore,
                "활력 : " +Con,
                "근력 : " +Str,
                "민첩 : " +Agi,
                "지력 : " +Int,
                "손재주 : " +Dex,
                "========[ 비용 ]========",
                "판매 비용 : " + sell + " 페린"
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack ShopItemSetting(Material material, int CustomModel, String display, String type , String lore, int buy, int sell){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setUnbreakable(true);
        meta.setCustomModelData(CustomModel);
        String Type = switch (type) {
            case "material" -> "재료";
            case "delete" -> "제거";
            case "skill" -> "기술";
            case "upgrade" -> "강화";
            case "mercenary" -> "용병";
            case "heal" -> "회복";
            default -> null;
        };
        if (buy == 0){
            meta.setLore(Arrays.asList(
                    "========[ 상점 ]========",
                    "[ " + Type + " ]",
                    ChatColor.GOLD +lore,
                    "========[ 비용 ]========",
                    "판매 비용 : " + sell + " 페린",
                    "우클릭 시 판매됩니다. 쉬프트를 누르면 64개 판매됩니다."

            ));
        }else {
            if (sell == 0){
                meta.setLore(Arrays.asList(
                        "========[ 상점 ]========",
                        lore,
                        "========[ 비용 ]========",
                        "구매 비용 : " + buy + " 페린",
                        "좌클릭 시 구매됩니다. 쉬프트를 누르면 64개 구매됩니다."

                ));

            } else {
                meta.setLore(Arrays.asList(
                        "========[ 상점 ]========",
                        lore,
                        "========[ 비용 ]========",
                        "구매 비용 : " + buy + " 페린",
                        "판매 비용 : " + sell + " 페린",
                        "좌클릭 시 구매됩니다. 쉬프트를 누르면 64개 구매됩니다.",
                        "우클릭 시 판매됩니다. 쉬프트를 누르면 64개 판매됩니다."

                ));
            }
        }

        return item;
    }

}






















