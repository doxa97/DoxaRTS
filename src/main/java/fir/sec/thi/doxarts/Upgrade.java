package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Upgrade implements Listener {

    public static void Upgrading(Player player){

        ArrayList<String> lore = (ArrayList<String>) player.getOpenInventory().getTopInventory().getItem(1).getItemMeta().getLore();

        if (lore.contains("[ 무기 ]")){
            for (int i = 0; i <= lore.size(); i++){
                if (lore.get(i).contains("강화 수치")){
                    int up = Integer.parseInt(lore.get(i).replace("강화","").replace("수치","")
                            .replace(" ","").replace(":",""));
                    switch (up) {
                        case 0 : lore.set(i,lore.get(i).replace("0","1"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 1 : lore.set(i,lore.get(i).replace("1","2"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 2 : lore.set(i,lore.get(i).replace("2","3"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 3 : lore.set(i,lore.get(i).replace("3","4"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 4 : lore.set(i,lore.get(i).replace("4","5"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 5 : lore.set(i,lore.get(i).replace("5","6"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 6 : lore.set(i,lore.get(i).replace("6","7"));
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (lore.get(o).contains("공격력 증가량")){
                                    int damage = Integer.parseInt(lore.get(o).replace("공격력","").replace("증가량","")
                                            .replace(" ","").replace(":",""));
                                    damage = damage + 7;
                                    lore.set(o,"공격력 증가량 : "+damage );
                                }
                                if (lore.get(o).contains("치명타 확률")) {
                                    int crit = Integer.parseInt(lore.get(o).replace("치명타", "").replace("확률", "")
                                            .replace(" ", "").replace(":", ""));
                                    crit = crit + 3;
                                    lore.set(o, "치명타 확률 : " + crit);
                                }
                            }
                        case 7 : player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 해당 무기는 최대 강화입니다.");
                    }
                }
            }
        }
        player.getOpenInventory().getTopInventory().getItem(1).getItemMeta().setLore(lore);
    }

}
