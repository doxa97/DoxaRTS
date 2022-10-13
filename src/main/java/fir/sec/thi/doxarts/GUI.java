package fir.sec.thi.doxarts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI implements Listener {

    public static ItemStack GuiTool(Material material, String DisplayName, List<String> Lore, int CustomModelData){
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(DisplayName);
        meta.setLore(Lore);
        meta.setCustomModelData(CustomModelData);
        meta.setUnbreakable(true);
        stack.setItemMeta(meta);
        return stack;
    }

    public static void Status(Player player){
        Inventory status = Bukkit.createInventory(null, 9,"[ S T A T U S ]");

        status.setItem(0, GuiTool(Material.COOKED_BEEF, ChatColor.RED+ "[ 활력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(2, GuiTool(Material.IRON_SWORD, ChatColor.DARK_RED + "[ 근력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(4, GuiTool(Material.LEATHER_BOOTS,  ChatColor.AQUA+ "[ 민첩 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(6, GuiTool(Material.KNOWLEDGE_BOOK, ChatColor.DARK_PURPLE + "[ 지력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(8, GuiTool(Material.BOW,  ChatColor.GOLD+ "[ 손재주 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));

        player.openInventory(status);

    }

    public static void Smith(Player player){
        Inventory smith = Bukkit.createInventory(null, 9,"[ 대장간 ]");

        smith.setItem(2, GuiTool(Material.BARRIER,ChatColor.GOLD+ "[ 장비 강화 ]", Arrays.asList(ChatColor.GRAY+"장비를 강화할 수 있습니다.","누르면 장비 강화로 넘어갑니다."), 10000));
        smith.setItem(6, GuiTool(Material.BARRIER,ChatColor.LIGHT_PURPLE+ "[ 무기 기술 ]", Arrays.asList(ChatColor.GRAY+"무기에 기술을 장착하거나 해제할 수 있습니다.","누르면 무기 기술로 넘어갑니다."), 10000));

        player.openInventory(smith);

    }

    public static void Upgrade(Player player){
        Inventory upgrade = Bukkit.createInventory(null, 9,"[ 장비 강화 ]");

        upgrade.setItem(0,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
        upgrade.setItem(2,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));

        upgrade.setItem(3,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 재료를 놓아주세요."),10000));
        upgrade.setItem(6,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 재료를 놓아주세요."),10000));

        upgrade.setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","비용 : "),10000));
        upgrade.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));

        player.openInventory(upgrade);

    }

    public static void Skill(Player player){
        Inventory skill = Bukkit.createInventory(null, 18,"[ 무기 기술 ]");

        skill.setItem(3,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
        skill.setItem(5,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
        skill.setItem(9,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
        skill.setItem(11,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
        skill.setItem(13,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
        skill.setItem(15,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
        skill.setItem(17,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
        skill.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));
        skill.setItem(0, GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+ "[ 등록 및 제거 ]", Arrays.asList(ChatColor.GRAY+"기술을 등록 또는 제거합니다."), 10000));

        player.openInventory(skill);

    }

    public static void Shop(Player player){
        Inventory shop = Bukkit.createInventory(null, 9,"[ 상점 ]");

        shop.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));

        player.openInventory(shop);

    }

}
