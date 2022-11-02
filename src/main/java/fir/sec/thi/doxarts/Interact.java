package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

import static fir.sec.thi.doxarts.BuyAndSell.*;
import static fir.sec.thi.doxarts.GUI.*;
import static fir.sec.thi.doxarts.SkillSet.SkillSetting;
import static fir.sec.thi.doxarts.Teams.board;
import static fir.sec.thi.doxarts.Upgrade.Upgrading;

public class Interact implements Listener {

    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        Integer xPos = event.getClickedBlock().getX();
        Integer yPos = event.getClickedBlock().getY();
        Integer zPos = event.getClickedBlock().getZ();

        if (player.getInventory().getItemInMainHand().getType() == Material.VILLAGER_SPAWN_EGG){
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("돌진")){
                if (block.getType() == Material.EMERALD_BLOCK){
                    if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){

                    }
                }
                else {
                    RunSound(player,"no",70,1);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "돌진 용병은 에메랄드 블럭 위에한 소환 가능합니다.");
                }
            }

            else {
                RunSound(player,"no",70,1);
                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "특정 블럭에만 상호작용이 가능합니다.");
            }
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void EntityInteract(PlayerInteractEntityEvent event){
        LivingEntity entity = (LivingEntity) event.getRightClicked();
        Player player = event.getPlayer();
        if (entity.getName().contains("대장장이")){
            Smith(player);
        }
        if (entity.getName().contains("상인")){
            Shop(player);
        }
    }

    @EventHandler
    public void SwapLeftHand(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        if (!player.getScoreboardTags().contains("assassin")){
            event.setCancelled(true);
            RunSound(player,"no",70,1);
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "왼손 사용은 불가능합니다.");
        }
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        long[] stat = Stats.getStat(player);
        if (event.getClickedInventory().getType() == InventoryType.PLAYER){
            if (event.getSlot() == -106){
                if (!player.getScoreboardTags().contains("assassin")){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "왼손 사용은 불가능합니다.");
                    RunSound(player,"no",70,1);
                }
            }
            if (event.getSlot() == 9 && event.getSlot() == 10 && event.getSlot() == 11 && event.getSlot() == 12){
                if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 장신구 ]")){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "장신구 란에는 장신구만 장비가 가능합니다.");
                    RunSound(player,"no",70,1);
                }
                else {
                    player.getItemOnCursor().setAmount(0);
                    RunSound(player,"gui",70,1);
                    player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "정상적으로 장신구를 장착하였습니다.");
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
                        RunSound(player,"upgrade",70,1);
                    case 6:
                        GUI.Skill(player);
                        RunSound(player,"skill",70,1);
                }
            }
            if (event.getView().getTitle().contains("[ 장비 강화 ]")){
                switch (event.getRawSlot()){
                    case 0, 2, 3 :
                        event.setCancelled(true);
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "강화 틀은 건드릴 수 없습니다.");
                    case 1 :
                        ArrayList<String> getUpgrade = (ArrayList<String>) player.getItemOnCursor().getItemMeta().getLore();
                        if (!getUpgrade.contains("[ 무기 ]")){
                            event.setCancelled(true);
                            RunSound(player,"no",70,1);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "무기 이외에는 강화할 수 없습니다.");
                        }
                        else {
                            for (int i = 0; i <= getUpgrade.size(); i++) {
                                if (getUpgrade.get(i).contains("강화 수치")){
                                    int upgrade = Integer.parseInt(getUpgrade.get(i).replace("강화","").replace("수치","").replace(" ","")
                                            .replace(":",""));
                                    switch (upgrade){
                                        case 0 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 6"),10000));
                                        case 1 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 24"),10000));
                                        case 2 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 42"),10000));
                                        case 3 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 64"),10000));
                                        case 4 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 12","필요 에르 광물 : 0"),10000));
                                        case 5 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 24","필요 에르 광물 : 0"),10000));
                                        case 6 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 36","필요 에르 광물 : 0"),10000));
                                        case 7 :
                                            player.getOpenInventory().getTopInventory().setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 0"),10000));
                                    }
                                }
                            }
                        }
                    case 5 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 강화 ]")){
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "강화서 이외에는 넣을 수 없습니다.");
                            RunSound(player,"no",70,1);
                        }
                    case 6 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 재료 ]")){
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "재료 이외에는 넣을 수 없습니다.");
                            RunSound(player,"no",70,1);
                        }
                    case 8 :
                        Smith(player);
                    case 7 :
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

                            ItemStack material = player.getOpenInventory().getItem(6);
                            if (material.getItemMeta().getDisplayName().contains("에르")){
                                HaveEr = material.getAmount();
                            }
                            if (material.getItemMeta().getDisplayName().contains("킨")){
                                HaveKin = material.getAmount();
                            }
                            if (NeedKin > HaveKin || NeedEr > HaveEr){
                                RunSound(player,"no",70,1);
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "재료가 부족합니다!");
                            }else {
                                if (material.getItemMeta().getDisplayName().contains("에르")){
                                    player.getOpenInventory().getItem(6).setAmount(HaveEr - NeedEr);
                                }
                                if (material.getItemMeta().getDisplayName().contains("킨")){
                                    player.getOpenInventory().getItem(6).setAmount(HaveKin - NeedKin);
                                }
                                Upgrading(player);
                            }
                        }
                }
            }
            if (event.getView().getTitle().contains("[ 기술 ]")){
                switch (event.getRawSlot()){
                    case 0 :
                        SkillSetting(player);
                    case 4 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 무기 ]")){
                            event.setCancelled(true);
                            RunSound(player,"no",70,1);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "무기 이외에는 올릴 수 없습니다.");
                        }
                    case 10 :
                        if (player.getScoreboardTags().contains("magician")){
                            if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 기술 ]") || !player.getItemOnCursor().getItemMeta().getLore().contains("[ 제거 ]")) {
                                event.setCancelled(true);
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "기술 등록 또는 제거 책 이외에는 올릴 수 없습니다.");
                                RunSound(player,"no",70,1);
                            }
                        }
                        else {
                            event.setCancelled(true);
                            RunSound(player,"no",70,1);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "마법사 이외에는 선택할 수 없습니다.");
                        }
                    case 12, 14, 16 :
                        if (!player.getItemOnCursor().getItemMeta().getLore().contains("[ 기술 ]") || !player.getItemOnCursor().getItemMeta().getLore().contains("[ 제거 ]")){
                            event.setCancelled(true);
                            RunSound(player,"no",70,1);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "기술 등록 또는 제거 책 이외에는 올릴 수 없습니다.");
                        }
                    case 8 :
                        Smith(player);
                    case 5,9,11,13,15,17 :
                        event.setCancelled(true);
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "기본 틀은 건들 수 없습니다.");
                }
            }
            if (event.getView().getTitle().contains("[ 상점 ]")){
                if (event.getCurrentItem().getItemMeta().getLore().contains("[ 상점 ]")){
                    if (event.getClick().isLeftClick()){
                        if (event.getClick().isShiftClick()){
                            x64Buy(player);
                        }
                        else {
                            Buy(player);
                        }
                    }
                    if (event.getClick().isRightClick()){
                        if (event.getClick().isShiftClick()){
                            x64Sell(player);
                        }
                        else {
                            Sell(player);
                        }
                    }

                    event.setCancelled(true);
                }
                else {
                    if (event.getRawSlot() == 2 || event.getRawSlot() == 4 || event.getRawSlot() == 6){
                        if (event.getRawSlot() == 2){
                            SkillShop(player);
                            RunSound(player,"skill",70,1);
                        }
                        if (event.getRawSlot() == 4){
                            MercenaryShop(player);
                            RunSound(player,"mercenary",70,1);
                        }
                        if (event.getRawSlot() == 6){
                            UpgradeShop(player);
                            RunSound(player,"upgrade",70,1);
                        }
                    }
                    else {
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "상점 물품 이외에는 건들 수 없습니다.");
                        RunSound(player,"no",70,1);
                    }

                }
            }
            if (event.getView().getTitle().contains("[ 무기 강화 상점 ]")) {
                if (event.getCurrentItem().getItemMeta().getLore().contains("[ 상점 ]")) {
                    if (event.getClick().isLeftClick()) {
                        if (event.getClick().isShiftClick()) {
                            x64Buy(player);
                        } else {
                            Buy(player);
                        }
                    }
                    if (event.getClick().isRightClick()) {
                        if (event.getClick().isShiftClick()) {
                            x64Sell(player);
                        } else {
                            Sell(player);
                        }
                    }

                    event.setCancelled(true);
                } else {
                    if (event.getRawSlot() == 4) {
                        Shop(player);
                    } else {
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "상점 물품 이외에는 건들 수 없습니다.");
                        RunSound(player,"no",70,1);
                    }

                }
            }
            if (event.getView().getTitle().contains("[ 무기 강화 상점 ]")) {
                if (event.getCurrentItem().getItemMeta().getLore().contains("[ 상점 ]")) {
                    if (event.getClick().isLeftClick()) {
                        if (event.getClick().isShiftClick()) {
                            x64Buy(player);
                        } else {
                            Buy(player);
                        }
                    }
                    if (event.getClick().isRightClick()) {
                        if (event.getClick().isShiftClick()) {
                            x64Sell(player);
                        } else {
                            Sell(player);
                        }
                    }

                    event.setCancelled(true);
                } else {
                    if (event.getRawSlot() == 4) {
                        Shop(player);
                    } else {
                        RunSound(player,"no",70,1);
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "상점 물품 이외에는 건들 수 없습니다.");
                    }

                }
            }
            if (event.getView().getTitle().contains("[ 기술 상점 ]")){
                if (event.getCurrentItem().getItemMeta().getLore().contains("[ 상점 ]")){
                    if (event.getClick().isLeftClick()){
                        if (event.getClick().isShiftClick()){
                            x64Buy(player);
                        }
                        else {
                            Buy(player);
                        }
                    }
                    if (event.getClick().isRightClick()){
                        if (event.getClick().isShiftClick()){
                            x64Sell(player);
                        }
                        else {
                            Sell(player);
                        }
                    }

                    event.setCancelled(true);
                }
                else {
                    if (event.getRawSlot() == 4){
                        Shop(player);
                    }
                    else {
                        event.setCancelled(true);
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "상점 물품 이외에는 건들 수 없습니다.");
                    }

                }
            }
        }
    }

    @EventHandler
    public void InventoryClose(InventoryCloseEvent event){

        Player player = (Player) event.getPlayer();
        RunSound(player,"close",70,1);

        if (player.getOpenInventory().getTitle().contains("[ 장비 강화 ]")){
            ItemStack first = player.getOpenInventory().getTopInventory().getItem(1);
            ItemStack second = player.getOpenInventory().getTopInventory().getItem(4);
            ItemStack third = player.getOpenInventory().getTopInventory().getItem(5);
            player.getInventory().addItem(first,second,third);
        }
        if (player.getOpenInventory().getTitle().contains("[ 기술 ]")){
            if (player.getScoreboardTags().contains("magician")){
                ItemStack first = player.getOpenInventory().getTopInventory().getItem(4);
                ItemStack second = player.getOpenInventory().getTopInventory().getItem(10);
                ItemStack third = player.getOpenInventory().getTopInventory().getItem(12);
                ItemStack fourth = player.getOpenInventory().getTopInventory().getItem(14);
                ItemStack fifth = player.getOpenInventory().getTopInventory().getItem(16);
                player.getInventory().addItem(first,second,third,fourth,fifth);
            }
            else {
                ItemStack first = player.getOpenInventory().getTopInventory().getItem(4);
                ItemStack second = player.getOpenInventory().getTopInventory().getItem(12);
                ItemStack third = player.getOpenInventory().getTopInventory().getItem(14);
                ItemStack fourth = player.getOpenInventory().getTopInventory().getItem(16);
                player.getInventory().addItem(first,second,third,fourth);
            }
        }

    }

}
