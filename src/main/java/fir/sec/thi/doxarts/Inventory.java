package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.PlayerInventory;

public class Inventory implements Listener {

    public void InventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() instanceof PlayerInventory){
            if (event.getSlot() == 9 ||event.getSlot() ==  10 ||event.getSlot() ==  11 ||event.getSlot() ==  12){
                if (!event.getCurrentItem().getItemMeta().getLore().contains("[ 장신구 ]")){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "장신구가 아닌 물건은 장착할 수 없습니다.");
                }
            }
        }
    }

}
