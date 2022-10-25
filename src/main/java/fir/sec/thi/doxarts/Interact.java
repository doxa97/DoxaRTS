package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

import static fir.sec.thi.doxarts.GUI.GuiTool;
import static fir.sec.thi.doxarts.SkillSet.SkillSetting;
import static fir.sec.thi.doxarts.Upgrade.Upgrading;

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
                switch (event.getRawSlot()){
                    case 0 : Stats.StatUp(stat, player, 4);
                    case 2 : Stats.StatUp(stat, player, 5);
                    case 4 : Stats.StatUp(stat, player, 6);
                    case 6 : Stats.StatUp(stat, player, 7);
                    case 8 : Stats.StatUp(stat, player, 8);
                }
            }
            if (event.getView().getTitle().contains("[ 대장간 ]")) {
                event.setCancelled(true);
                switch (event.getRawSlot()) {
                    case 2:
                        GUI.Upgrade(player);
                    case 6:
                        GUI.Skill(player);
                }
            }
            if (event.getView().getTitle().contains("[ 장비 강화 ]")){
                switch (event.getRawSlot()){
                    case 0, 2, 3, 7 :
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "강화 틀은 건드릴 수 없습니다.");
                    case 1 :
                        ArrayList<String> getUpgrade = (ArrayList<String>) player.getItemOnCursor().getItemMeta().getLore();
                        if (!getUpgrade.contains("[ 무기 ]")){
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "무기 이외에는 강화할 수 없습니다.");
                        }
                        else {
                            for (int i = 0; i <= getUpgrade.size(); i++) {
                                if (getUpgrade.get(i).contains("강화 수치")){
                                    int upgrade = Integer.parseInt(getUpgrade.get(i).replace("강화","").replace("수치","").replace(" ","")
                                            .replace(":",""));
                                    switch (upgrade){
                                        case 1 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 12"),10000));
                                        case 2 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 4","필요 에르 광물 : 24"),10000));
                                        case 3 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 8","필요 에르 광물 : 36"),10000));
                                        case 4 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 12","필요 에르 광물 : 48"),10000));
                                        case 5 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 16","필요 에르 광물 : 60"),10000));
                                        case 6 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 25","필요 에르 광물 : 64"),10000));
                                        case 7 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 0"),10000));
                                    }
                                }
                            }
                        }
                    case 5, 6 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 재료 ]")){
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "재료 이외에는 넣을 수 없습니다.");
                        }
                    case 8 :
                        event.setCancelled(true);
                        ArrayList<String> lore = (ArrayList<String>) player.getOpenInventory().getTopInventory().getItem(7).getItemMeta().getLore();
                        for (int i = 0; i <= lore.size(); i++) {
                            int NeedEr = 0;
                            int NeedKin = 0;
                            int HaveEr = 0;
                            int HaveKin = 0;
                            if (lore.get(i).contains("필요 에르 광물")) {
                                NeedEr = Integer.parseInt(lore.get(i).replace("필요","").replace("에르","")
                                                .replace(" ","").replace(":","").replace("광물",""));
                            }
                            if (lore.get(i).contains("필요 킨 광물")){
                                NeedKin = Integer.parseInt(lore.get(i).replace("필요","").replace("킨","")
                                        .replace(" ","").replace(":","").replace("광물",""));
                            }
                            ItemStack First = player.getOpenInventory().getItem(5);
                            ItemStack Second = player.getOpenInventory().getItem(6);
                            if (First.getItemMeta().getDisplayName().contains("에르")){
                                HaveEr = HaveEr + First.getAmount();
                            }
                            if (First.getItemMeta().getDisplayName().contains("킨")){
                                HaveKin = HaveKin + First.getAmount();
                            }
                            if (Second.getItemMeta().getDisplayName().contains("에르")){
                                HaveEr = HaveEr + First.getAmount();
                            }
                            if (Second.getItemMeta().getDisplayName().contains("킨")){
                                HaveKin = HaveKin + First.getAmount();
                            }
                            if (NeedKin > HaveKin || NeedEr > HaveEr){
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "재료가 부족합니다!");
                            }else {
                                if (First.getItemMeta().getDisplayName().contains("에르")){
                                    player.getOpenInventory().getItem(5).setAmount(HaveEr - NeedEr);
                                }
                                if (First.getItemMeta().getDisplayName().contains("킨")){
                                    player.getOpenInventory().getItem(5).setAmount(HaveKin - NeedKin);
                                }
                                if (Second.getItemMeta().getDisplayName().contains("에르")){
                                    player.getOpenInventory().getItem(6).setAmount(HaveEr - NeedEr);
                                }
                                if (Second.getItemMeta().getDisplayName().contains("킨")){
                                    player.getOpenInventory().getItem(6).setAmount(HaveKin - NeedKin);
                                }
                                Upgrading(player);
                            }
                        }
                }
            }
            if (event.getView().getTitle().contains("[ 스킬 ]")){
                switch (event.getRawSlot()){
                    case 0 :
                        SkillSetting(player);
                    case 4 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 무기 ]")){
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "무기 이외에는 올릴 수 없습니다.");
                        }
                    case 10 :
                        if (player.getScoreboardTags().contains("magician")){
                            if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 기술 ]") || !player.getItemOnCursor().getItemMeta().getLore().contains("[ 제거 ]")) {
                                event.setCancelled(true);
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "기술 등록 또는 제거 책 이외에는 올릴 수 없습니다.");
                            }
                        }
                        else {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "마법사 이외에는 선택할 수 없습니다.");
                        }
                    case 12, 14, 16 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 기술 ]") || !player.getItemOnCursor().getItemMeta().getLore().contains("[ 제거 ]")){
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "기술 등록 또는 제거 책 이외에는 올릴 수 없습니다.");
                        }
                    case 8 :

                    case 5,9,11,13,15,17 :
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "기본 틀은 건들 수 없습니다.");
                }
            }
        }
    }
    public void InventoryClose(InventoryCloseEvent event){

    }

}
