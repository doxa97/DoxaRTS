package fir.sec.thi.doxarts;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

import static fir.sec.thi.doxarts.GUI.RunSound;

public class Upgrade implements Listener {

    public static void Upgrading(Player player){

        ArrayList<String> lore = (ArrayList<String>) player.getOpenInventory().getTopInventory().getItem(1).getItemMeta().getLore();
        String UpgradeName = player.getOpenInventory().getTopInventory().getItem(5).getItemMeta().getDisplayName();

        if (lore.contains("[ 무기 ]")){
            for (int i = 0; i <= lore.size(); i++){
                if (lore.get(i).contains("강화 수치")){
                    int up = Integer.parseInt(lore.get(i).replace("강화","").replace("수치","")
                            .replace(" ","").replace(":",""));
                    switch (up) {
                        case 0 : lore.set(i,lore.get(i).replace("0","1"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 1 : lore.set(i,lore.get(i).replace("1","2"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 2 : lore.set(i,lore.get(i).replace("2","3"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 3 : lore.set(i,lore.get(i).replace("3","4"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 4 : lore.set(i,lore.get(i).replace("4","5"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 5 : lore.set(i,lore.get(i).replace("5","6"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 6 : lore.set(i,lore.get(i).replace("6","7"));
                            RunSound(player,"upgrade",70,1);
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 강화가 완료되었습니다.");
                            for (int o = 0; o <= lore.size(); o++){
                                if (UpgradeName.contains("물리 공격력 : ")){
                                    //13
                                    if (lore.get(o).contains("물리 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("물리","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 13 ;
                                        lore.set(o,"물리 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("마법 공격력 : ")){
                                    //15
                                    if (lore.get(o).contains("마법 공격력 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("마법","").replace("공격력","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 15 ;
                                        lore.set(o,"마법 공격력 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("공격 속도 : ")){
                                    //0.15
                                    if (lore.get(o).contains("공격 속도 :")){
                                        double upgrade = Integer.parseInt(lore.get(o).replace("공격","").replace("속도","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 0.15 ;
                                        lore.set(o,"공격 속도 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("치명타 확률 : ")){
                                    //8
                                    if (lore.get(o).contains("치명타 확률 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("치명타","").replace("확률","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 8 ;
                                        lore.set(o,"치명타 확률 : " + upgrade);
                                    }
                                }
                                if (UpgradeName.contains("흡혈 : ")){
                                    //3
                                    if (lore.get(o).contains("흡혈 :")){
                                        int upgrade = Integer.parseInt(lore.get(o).replace("흡혈","")
                                                .replace(" ","").replace(":",""));
                                        upgrade = upgrade + 3 ;
                                        lore.set(o,"흡혈 : " + upgrade);
                                    }
                                }
                            }

                        case 7 : player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" + ChatColor.GRAY + " 해당 무기는 최대 강화입니다.");
                            RunSound(player,"no",70,1);
                    }
                }
            }
        }
        player.getOpenInventory().getTopInventory().getItem(1).getItemMeta().setLore(lore);
    }

}
