package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class Interact implements Listener {

    public void PlayerInteract(PlayerInteractEvent event){

    }

    public void EntityInteract(EntityInteractEvent event){

    }

    public void SwapLeftHand(PlayerSwapHandItemsEvent event){
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "왼손 사용은 불가능합니다.");
    }

    public void InventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        long[] stat = Stats.getStat(player.getUniqueId().toString());
        if (event.getClickedInventory().getType() == InventoryType.PLAYER){
            if (event.getSlot() == -106){
                event.setCancelled(true);
                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "왼손 사용은 불가능합니다.");
            }
            if (event.getSlot() == 9 && event.getSlot() == 10 && event.getSlot() == 11 && event.getSlot() == 12){
                if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 장신구 ]")){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "장신구 란에는 장신구만 장비가 가능합니다.");
                }
                else {
                    player.getItemOnCursor().setAmount(0);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "정상적으로 장신구를 장착하였습니다.");
                }
            }
        }
        if (event.getClickedInventory().getType() == InventoryType.CHEST){
            if (event.getView().getTitle().contains("[ S T A T U S ]")){
                event.setCancelled(true);
                switch (event.getSlot()){
                    case 0 : Stats.StatUp(stat, player, 4);
                    case 2 : Stats.StatUp(stat, player, 5);
                    case 4 : Stats.StatUp(stat, player, 6);
                    case 6 : Stats.StatUp(stat, player, 7);
                    case 8 : Stats.StatUp(stat, player, 8);
                }
            }
        }
    }

    public void InventoryClose(InventoryCloseEvent event){

    }

}