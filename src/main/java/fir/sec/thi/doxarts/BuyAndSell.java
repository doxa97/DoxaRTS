package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.util.ArrayList;

import static fir.sec.thi.doxarts.GUI.RunSound;
import static fir.sec.thi.doxarts.Money.AddPerin;
import static fir.sec.thi.doxarts.Money.RemovePerin;
import static fir.sec.thi.doxarts.Teams.board;
import static fir.sec.thi.doxarts.Variable.money;

public class BuyAndSell implements Listener {

    public static void Buy(Player player){

        ItemStack item = player.getItemOnCursor();
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        int buy = 0;
        int HaveMoney = 0;

        for (int i = 0; i <= lore.size(); i++){
            if (lore.get(i).contains("구매 비용 : ")){
                buy = Integer.parseInt(lore.get(i).replace("구매","").replace("비용","")
                        .replace(" ","").replace(":","").replace("페린",""));
            }
        }
        if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
            HaveMoney = money.get("red");
        }
        if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
            HaveMoney = money.get("blue");
        }

        if (buy > HaveMoney){
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "돈이 부족하여 구매에 실패하였습니다.");
            RunSound(player,"no",70,1);
        }
        else {
            if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
                RemovePerin("red",buy);
            }
            if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
                RemovePerin("blue",buy);
            }
            for (int i = 0; i <= lore.size(); i++){
                if (lore.get(i).contains("=[ 상점 ]=")){
                    lore.remove(i--);
                }
                if (lore.get(i).contains("=[ 비용 ]=")){
                    for (int o = i; o<=lore.size(); o++){
                        lore.remove(o--);
                    }
                }
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "성공적으로 구매에 성공하셨습니다.");
            RunSound(player,"shop",70,1);
        }
    }

    public static void x64Buy(Player player){

        ItemStack item = player.getItemOnCursor();
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        int buy = 0;
        int HaveMoney = 0;

        for (int i = 0; i <= lore.size(); i++){
            if (lore.get(i).contains("구매 비용 : ")){
                buy = 64 * Integer.parseInt(lore.get(i).replace("구매","").replace("비용","")
                        .replace(" ","").replace(":","").replace("페린",""));
            }
        }
        if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
            HaveMoney = money.get("red");
        }
        if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
            HaveMoney = money.get("blue");
        }

        if (buy > HaveMoney){
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "돈이 부족하여 구매에 실패하였습니다.");
            RunSound(player,"no",70,1);
        }
        else {
            if (board.getEntryTeam(player.getName()).getName().equals("레드팀")){
                RemovePerin("red",buy);
            }
            if (board.getEntryTeam(player.getName()).getName().equals("블루팀")){
                RemovePerin("blue",buy);
            }
            for (int i = 0; i <= lore.size(); i++){
                if (lore.get(i).contains("=[ 상점 ]=")){
                    lore.remove(i--);
                }
                if (lore.get(i).contains("=[ 비용 ]=")){
                    for (int o = i; o<=lore.size(); o++){
                        lore.remove(o--);
                    }
                }
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            for (int max = 64; max >= 0; max--){
                player.getInventory().addItem(item);
            }
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "성공적으로 구매에 성공하셨습니다.");
            RunSound(player,"shop",70,1);
        }

    }

    public static void Sell(Player player) {

        ItemStack item = player.getItemOnCursor();
        ItemStack SellItem = null;
        for (int SellItemLoc = 0; SellItemLoc <= player.getInventory().getSize(); SellItemLoc++) {
            if (player.getInventory().getItem(SellItemLoc).getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
                SellItem = player.getInventory().getItem(SellItemLoc);
            }
        }
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        int sell = 0;

        for (int i = 0; i <= lore.size(); i++) {
            if (lore.get(i).contains("판매 비용 : ")) {
                sell = Integer.parseInt(lore.get(i).replace("판매", "").replace("비용", "")
                        .replace(" ", "").replace(":", "").replace("페린", ""));
            }
        }
        if (SellItem.getAmount() > 0) {
            if (board.getEntryTeam(player.getName()).getName().equals("레드팀")) {
                AddPerin("red", sell);
            }
            if (board.getEntryTeam(player.getName()).getName().equals("블루팀")) {
                AddPerin("blue", sell);
            }
            player.getInventory().remove(SellItem);
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "성공적으로 판매에 성공하셨습니다.");
            RunSound(player,"chain",70,1);
        } else {
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "물품이 부족하여 판매에 실패했습니다.");
            RunSound(player,"no",70,1);
        }
    }

    public static void x64Sell(Player player) {

        ItemStack item = player.getItemOnCursor();
        ItemStack SellItem = null;
        for (int SellItemLoc = 0; SellItemLoc <= player.getInventory().getSize(); SellItemLoc++) {
            if (player.getInventory().getItem(SellItemLoc).getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
                SellItem = player.getInventory().getItem(SellItemLoc);
            }
        }
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        int sell = 0;

        for (int i = 0; i <= lore.size(); i++) {
            if (lore.get(i).contains("판매 비용 : ")) {
                sell = 64 * Integer.parseInt(lore.get(i).replace("판매", "").replace("비용", "")
                        .replace(" ", "").replace(":", "").replace("페린", ""));
            }
        }
        if (SellItem.getAmount() >= 64) {
            if (board.getEntryTeam(player.getName()).getName().equals("레드팀")) {
                AddPerin("red", sell);
            }
            if (board.getEntryTeam(player.getName()).getName().equals("블루팀")) {
                AddPerin("blue", sell);
            }
            for (int max = 64; max >= 0; max--){
                player.getInventory().remove(SellItem);
            }
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "성공적으로 판매에 성공하셨습니다.");
            RunSound(player,"shop",70,1);
        } else {
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "물품이 부족하여 판매에 실패했습니다.");
            RunSound(player,"no",70,1);
        }
    }

}


















