package fir.sec.thi.doxarts;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

import static fir.sec.thi.doxarts.Variable.weapon;
import static org.bukkit.Bukkit.getServer;

public class Skill implements Listener {

    public static void DamageSet(){

        for (Player player : getServer().getOnlinePlayers()){
            String name = player.getName();
            if (player.getInventory().getItem(0).getItemMeta().getLore().contains("[ 무기 ]")) {
                ArrayList<String> lore = (ArrayList<String>) player.getInventory().getItem(0).getItemMeta().getLore();
                for (int i = 0; i <= lore.size(); i++){

                    //기본 공격
                    if (lore.get(i).contains("[ 대검 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 직검 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 단검 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 역수 단검 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 단궁 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 장궁 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 마법 바람 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 마법 유도 화살 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 마법 그림자 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }

                    //전사
                    if (lore.get(i).contains("[ 올려 베기 ]")){
                        lore.set(i+1,"올려 베기 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 십자 베기 ]")){
                        lore.set(i+1,"십자 베기 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 연격 ]")){
                        lore.set(i+1,"연격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 참격 ]")){
                        lore.set(i+1,"참격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 포효 ]")){
                        lore.set(i+1,"포효 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }

                    //도적
                    if (lore.get(i).contains("[ 일섬 ]")){
                        lore.set(i+1,"일섬 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 출혈 ]")){
                        lore.set(i+1,"출혈 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 목 긋기 ]")){
                        lore.set(i+1,"목 긋기 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 난도 ]")){
                        lore.set(i+1,"난도 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 곡예 ]")){
                        lore.set(i+1,"곡예 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }

                    //궁수
                    if (lore.get(i).contains("[ 후퇴 ]")){
                        lore.set(i+1,"후퇴 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 선풍 ]")){
                        lore.set(i+1,"선풍 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 관통 ]")){
                        lore.add(i+1,"");
                        lore.add(i+2,"");
                    }
                    if (lore.get(i).contains("[ 속사 ]")){
                        lore.set(i+1,"속사 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 추격 ]")){
                        lore.set(i+1,"추격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }

                    //마법사
                    if (lore.get(i).contains("[ 고통의 대지 ]")){
                        lore.set(i+1,"고통의 대지 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 속죄 ]")){
                        lore.set(i+1,"속죄 패해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 검은 손짓 ]")){
                        lore.set(i+1,"검은 손짓 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 순간이동 ]")){
                        lore.add(i+1,"");
                        lore.add(i+2,"");
                    }
                    if (lore.get(i).contains("[ 서릿발 ]")){
                        lore.set(i+1,"서릿발 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 화염 ]")){
                        lore.set(i+1,"화염 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 서리 지대 ]")){
                        lore.set(i+1,"서리 지대 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 폭발 ]")){
                        lore.set(i+1,"폭발 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 치유 ]")){
                        lore.set(i+1,"치유 회복량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 기도 ]")){
                        lore.set(i+1,"기도 회복량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                }
                player.getInventory().getItem(0).getItemMeta().setLore(lore);
            }
            if (player.getInventory().getItemInOffHand().getItemMeta().getLore().contains("[ 무기 ]")){
                ArrayList<String> lore = (ArrayList<String>) player.getInventory().getItemInOffHand().getItemMeta().getLore();
                for (int i = 0; i <= lore.size(); i++){

                    if (lore.get(i).contains("[ 단검 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 역수 단검 기본 공격 ]")){
                        lore.set(i+1,"기본 공격 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    //도적
                    if (lore.get(i).contains("[ 일섬 ]")){
                        lore.set(i+1,"일섬 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 출혈 ]")){
                        lore.set(i+1,"출혈 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 목 긋기 ]")){
                        lore.set(i+1,"목 긋기 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 난도 ]")){
                        lore.set(i+1,"난도 피해량 : "+ weapon.get(name+"damage"));
                        lore.add(i+2,"");
                        lore.add(i+3,"");
                    }
                    if (lore.get(i).contains("[ 곡예 ]")) {
                        lore.set(i + 1, "곡예 피해량 : " + weapon.get(name+"damage"));
                        lore.add(i + 2, "");
                        lore.add(i + 3, "");
                    }
                }
            }
        }
    }

}




















