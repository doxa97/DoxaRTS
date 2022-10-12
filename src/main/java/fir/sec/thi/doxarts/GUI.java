package fir.sec.thi.doxarts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

    public void Status(){
        Inventory status = Bukkit.createInventory(null, 9,"[ S T A T U S ]");
        ArrayList<String> arrayList = new ArrayList<>();

        status.setItem(0, GuiTool(Material.COOKED_BEEF, ChatColor.RED+ "[ 활력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(2, GuiTool(Material.IRON_SWORD, ChatColor.DARK_RED + "[ 근력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(4, GuiTool(Material.LEATHER_BOOTS,  ChatColor.AQUA+ "[ 민첩 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(6, GuiTool(Material.KNOWLEDGE_BOOK, ChatColor.DARK_PURPLE + "[ 지력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(8, GuiTool(Material.BOW,  ChatColor.GOLD+ "[ 손재주 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));

    }

}
