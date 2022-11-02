package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static fir.sec.thi.doxarts.GUI.RunSound;

public class SkillSet implements Listener {

    public static void SkillSetting(Player player){

        ItemStack weapon = player.getOpenInventory().getItem(4);
        ItemStack first = player.getOpenInventory().getItem(10);
        ItemStack second = player.getOpenInventory().getItem(12);
        ItemStack third = player.getOpenInventory().getItem(14);
        ItemStack fourth = player.getOpenInventory().getItem(16);


        ArrayList<String> Weapon = new ArrayList<>();
        ArrayList<String> First = new ArrayList<>();
        ArrayList<String> Second = new ArrayList<>();
        ArrayList<String> Third = new ArrayList<>();
        ArrayList<String> Fourth = new ArrayList<>();

        if (weapon.getItemMeta().getLore().contains("[ 무기 ]")){
            Weapon.addAll(weapon.getItemMeta().getLore());
        }//10,12,14,16
        if (first.getItemMeta().getLore().contains("[ 기술 ]")){
            First.addAll(first.getItemMeta().getLore());
        }
        if (second.getItemMeta().getLore().contains("[ 기술 ]")){
            Second.addAll(second.getItemMeta().getLore());
        }
        if (third.getItemMeta().getLore().contains("[ 기술 ]")){
            Third.addAll(third.getItemMeta().getLore());
        }
        if (fourth.getItemMeta().getLore().contains("[ 기술 ]")){
            Fourth.addAll(fourth.getItemMeta().getLore());
        }
        for (int i = 0; i < Weapon.size(); i++){
            if (Weapon.get(i).contains("[ 첫번째 슬롯 ]")){
                if (Weapon.get(i+1).contains("[ 비어 있음 ]")){
                    if (first.getItemMeta().getLore().contains("[ 기술 ]")){
                        Weapon.set(i+1,"[ "+first.getItemMeta().getDisplayName()+" ]");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 첫번째 슬롯에 기술을 정상 등록하였습니다.");
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 등록하기 위해서는 기술책이 필요합니다.");
                    }
                }
                else {
                    if (first.getItemMeta().getLore().contains("[ 제거 ]")){
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 첫번째 슬롯을 정상적으로 제거했습니다.");
                        Weapon.set(i+1,"[ 비어 있음 ]");
                        for (int num = 0; num < First.size(); num++){
                            if (First.get(num).contains("[ 두번째 슬롯 ]")){
                                if (num > i + 2) {
                                    First.subList(i + 2, num).clear();
                                }
                            }
                        }
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 제거하기 위해서는 제거 수정이 필요합니다.");
                    }
                }
            }
            if (Weapon.get(i).contains("[ 두번째 슬롯 ]")){
                if (Weapon.get(i+1).contains("[ 비어 있음 ]")){
                    if (second.getItemMeta().getLore().contains("[ 기술 ]")){
                        Weapon.set(i+1,"[ "+second.getItemMeta().getDisplayName()+" ]");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 두번째 슬롯에 기술을 정상 등록하였습니다.");
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 등록하기 위해서는 기술책이 필요합니다.");
                    }
                }
                else {
                    if (second.getItemMeta().getLore().contains("[ 제거 ]")){
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 두번째 슬롯을 정상적으로 제거했습니다.");
                        Weapon.set(i+1,"[ 비어 있음 ]");
                        for (int num = 0; num < Second.size(); num++){
                            if (Second.get(num).contains("[ 세번째 슬롯 ]")){
                                if (num > i + 2) {
                                    Second.subList(i + 2, num).clear();
                                }
                            }
                        }
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 제거하기 위해서는 제거 수정이 필요합니다.");
                    }
                }
            }
            if (Weapon.get(i).contains("[ 세번째 슬롯 ]")){
                if (Weapon.get(i+1).contains("[ 비어 있음 ]")){
                    if (third.getItemMeta().getLore().contains("[ 기술 ]")){
                        Weapon.set(i+1,"[ "+third.getItemMeta().getDisplayName()+" ]");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 세번째 슬롯에 기술을 정상 등록하였습니다.");
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 등록하기 위해서는 기술책이 필요합니다.");
                    }
                }
                else {
                    if (third.getItemMeta().getLore().contains("[ 제거 ]")){
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 세번째 슬롯을 정상적으로 제거했습니다.");
                        Weapon.set(i+1,"[ 비어 있음 ]");
                        for (int num = 0; num < Third.size(); num++){
                            if (Third.get(num).contains("[ 네번째 슬롯 ]")){
                                if (num > i + 2) {
                                    Third.subList(i + 2, num).clear();
                                }
                            }
                        }
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 제거하기 위해서는 제거 수정이 필요합니다.");
                    }
                }
            }
            if (Weapon.get(i).contains("[ 네번째 슬롯 ]")){
                if (Weapon.get(i+1).contains("[ 비어 있음 ]")){
                    if (fourth.getItemMeta().getLore().contains("[ 기술 ]")){
                        Weapon.set(i+1,"[ "+fourth.getItemMeta().getDisplayName()+" ]");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 네번째 슬롯에 기술을 정상 등록하였습니다.");
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 등록하기 위해서는 기술책이 필요합니다.");
                    }
                }
                else {
                    if (fourth.getItemMeta().getLore().contains("[ 제거 ]")){
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 네번째 슬롯을 정상적으로 제거했습니다.");
                        Weapon.set(i+1,"[ 비어 있음 ]");
                        if (Weapon.size() >= i + 2) {
                            Fourth.subList(i + 2, Weapon.size() + 1).clear();
                        }
                    }
                    else {
                        RunSound(player,"no",70,1);
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 기술을 제거하기 위해서는 제거 수정이 필요합니다.");
                    }
                }
            }
        }
        weapon.getItemMeta().setLore(Weapon);

        /*
        ex)
        한손검
        [ 무기 ]
        설명
        능력치
        [ 첫번째 슬롯 ]
        [ 비어 있음 ]
        [ 두번째 슬롯 ]
        [ 1번 스킬 ]
        1번 스킬 설명

        십자베기
        [ 기술 ]
        설명

        */

    }

}
