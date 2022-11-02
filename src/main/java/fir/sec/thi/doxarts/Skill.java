package fir.sec.thi.doxarts;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

import static fir.sec.thi.doxarts.Variable.PlayerTotalStat;
import static fir.sec.thi.doxarts.Variable.weapon;
import static org.bukkit.Bukkit.getServer;

public class Skill implements Listener {

    public static void DamageSet(Player player){

        String name = player.getName();
        if (player.getInventory().getItem(0).getItemMeta().getLore().contains("[ 무기 ]")) {
            ArrayList<String> lore = (ArrayList<String>) player.getInventory().getItem(0).getItemMeta().getLore();
            for (int i = 0; i <= lore.size(); i++){

                //기본 공격
                if (lore.get(i).contains("[ 대검 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"대검의 기본 공격이다.");
                    lore.add(i+3,"사거리가 긴 대신, 무거운 무기로 인해 속도가 느리다.");
                }
                if (lore.get(i).contains("[ 직검 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"직검의 기본 공격이다.");
                    lore.add(i+3,"사거리와 공격속도 모두 준수한 편이다.");
                }
                if (lore.get(i).contains("[ 단검 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"단검의 기본 공격이다.");
                    lore.add(i+3,"사거리가 짧지만 빠른 공격으로 상대를 혼란시킬 수 있다.");
                }
                if (lore.get(i).contains("[ 역수 단검 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"단검의 역수 기본 공격이다.");
                    lore.add(i+3,"사거리가 짧지만 날카로운 공격으로 상대를 치명적으로 공격한다.");
                }
                if (lore.get(i).contains("[ 단궁 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"단궁의 기본 공격이다.");
                    lore.add(i+3,"활이 짧아 사거리가 짧지만, 공격속도가 빠르다.");
                }
                if (lore.get(i).contains("[ 장궁 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"장궁의 기본 공격이다.");
                    lore.add(i+3,"활이 길어 사거리가 길지만, 공격속도가 느리다.");
                }
                if (lore.get(i).contains("[ 마법 바람 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Magic"));
                    lore.add(i+2,"마법사의 기본 공격 중 바람 마법이다.");
                    lore.add(i+3,"빠른 공격이 가능하다.");
                }
                if (lore.get(i).contains("[ 마법 유도 화살 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Magic"));
                    lore.add(i+2,"마법사의 기본 공격 중 유도 마법이다.");
                    lore.add(i+3,"자동으로 조준한 상대를 추격하기에 용이하다.");
                }
                if (lore.get(i).contains("[ 마법 그림자 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Magic"));
                    lore.add(i+2,"마법사의 기본 공격 중 그림자 마법이다.");
                    lore.add(i+3,"상대의 그림자에서 검은 가시가 나와 상대를 공격한다.");
                }

                //전사
                if (lore.get(i).contains("[ 올려 베기 ]")){
                    lore.set(i+1,"올려 베기 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.85));
                    lore.add(i+2,"짧은 거리를 돌진하며 맞은 적을 약간 띄우고 그 후, 올려 베어낸다.");
                    lore.add(i+3,"4블럭 돌진하고, 5블럭 전방을 올려벤다. 재사용 대기시간 : 17 초");
                }
                if (lore.get(i).contains("[ 십자 베기 ]")){
                    lore.set(i+1,"십자 베기 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.6));
                    lore.add(i+2,"십자 형태로 전방을 베어내어 2회 피해를 입히는 기술이다.");
                    lore.add(i+3,"4블럭 전방을 베어낸다. 재사용 대기시간 : 13 초");
                }
                if (lore.get(i).contains("[ 연격 ]")){
                    lore.set(i+1,"연격 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.9));
                    lore.add(i+2,"3회 사용 기술로 1회와 2회는 전방을 약간 돌진하며 베고, 마지막은 2회전으로 전방을 베어낸다.");
                    lore.add(i+3,"1블럭 전진하며 3블럭 베어낸다. 5초 안에 다음 공격을 시도해야 한다. 재사용 대기시간 : 20 초");
                }
                if (lore.get(i).contains("[ 참격 ]")){
                    lore.set(i+1,"참격 피해량 : "+ (PlayerTotalStat.get(name+"Melee") + PlayerTotalStat.get(name+"Magic")));
                    lore.add(i+2,"전방을 크게 베어내고, 그 자리에서 참격이 날아가 피해를 입히는 기술이다.");
                    lore.add(i+3,"5블럭 베어내며 그 참격이 10블럭 나아간다. 재사용 대기시간 : 23 초");
                }
                if (lore.get(i).contains("[ 포효 ]")){
                    lore.set(i+1,"포효 피해량 : "+ ((PlayerTotalStat.get(name+"Melee") * 0.4) + (PlayerTotalStat.get(name+"Magic") * 0.4)));
                    lore.add(i+2,"적들에게 공포를 주는 함성을 내질러 잠시 기절 상태를 부여한다.");
                    lore.add(i+3,"반경 4블럭에 피해를 입히며 기절을 입힌다. 재사용 대기시간 : 16 초");
                }

                //도적
                if (lore.get(i).contains("[ 일섬 ]")){
                    lore.set(i+1,"일섬 피해량 : "+  String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.35 ));
                    lore.add(i+2,"전방으로 빠르게 이동하며 3회 베어내는 기술이다.");
                    lore.add(i+3,"7블럭 만큼 돌진한다. 재사용 대기시간 : 15 초");
                }
                if (lore.get(i).contains("[ 출혈 ]")){
                    lore.set(i+1,"출혈 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.12));
                    lore.add(i+2,"무기에 날카로운 조각을 심어 다음 1회 공격을 통해 출혈 상태를 입힌다.");
                    lore.add(i+3,"출혈은 7회 피해를 입힌다. 재사용 대기시간 : 8 초");
                }
                if (lore.get(i).contains("[ 목 긋기 ]")){
                    lore.set(i+1,"목 긋기 피해량 : "+ String.format("%.2f",(PlayerTotalStat.get(name+"Melee") * 0.3) + (PlayerTotalStat.get(name+"Magic") * 0.5) ));
                    lore.add(i+2,"상대에게 빠르게 접근해 상대의 성대를 그어 침묵시킨다.");
                    lore.add(i+3,"4블럭 안의 지정댄 대상에게 피해를 입힌다. 재사용 대기시간 : 12 초");
                }
                if (lore.get(i).contains("[ 난도 ]")){
                    lore.set(i+1,"난도 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") *  0.25));
                    lore.add(i+2,"전방을 빠르게 6회 베어내어 피해를 입히는 기술이다.");
                    lore.add(i+3,"전방 3블럭을 베어낸다. 재사용 대기시간 : 14 초");
                }
                if (lore.get(i).contains("[ 곡예 ]")) {
                    lore.set(i + 1, "곡예 피해량 : " + String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.8 ));
                    lore.add(i + 2, "뒤로 약간 후퇴하며 수리검을 날려 맞은 적의 뒤로 순간이동하는 기술이다.");
                    lore.add(i + 3, "2블럭 후퇴하며, 7블럭만큼 수리검을 던진다. 재사용 대기시간 : 17 초");
                }

                //궁수
                if (lore.get(i).contains("[ 후퇴 ]")){
                    lore.set(i+1,"후퇴 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.45));
                    lore.add(i+2,"뒤로 도약하며 전방으로 화살을 3회 사격합니다.");
                    lore.add(i+3,"뒤로 6블럭 후퇴하며 21블럭 전방으로 화살을 사격합니다. 재사용 대기시간 : 24 초");
                }
                if (lore.get(i).contains("[ 선풍 ]")){
                    lore.set(i+1,"선풍 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 1.3));
                    lore.add(i+2,"앞으로 바람을 일으켜 맞은 대상을 뒤로 밀어냅니다.");
                    lore.add(i+3,"전방 4블럭을 15블럭 밀쳐냅니다. 재사용 대기시간 : 19 초");
                }
                if (lore.get(i).contains("[ 관통 ]")){
                    lore.add(i+1,"잠시동안 화살의 관통 능력을 향상시켜 화살이 대상을 관통합니다.");
                    lore.add(i+2,"7초 동안 유지됩니다. 재사용 대기시간 : 35 초");
                }
                if (lore.get(i).contains("[ 속사 ]")){
                    lore.set(i+1,"속사 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.7));
                    lore.add(i+2,"일반 공격 시, 같은 궤적으로 2발의 화살을 추가로 사격합니다.");
                    lore.add(i+3,"10초 동안 유지됩니다. 재사용 대기시간 : 40 초");
                }
                if (lore.get(i).contains("[ 추격 ]")){
                    lore.set(i+1,"추격 피해량 : "+ String.format("%.2f",(PlayerTotalStat.get(name+"Melee") * 0.3) + (PlayerTotalStat.get(name+"Magic") * 0.3)));
                    lore.add(i+2,"잠시동안 화살이 대상에게 유도되어 날아갑니다.");
                    lore.add(i+3,"8초 동안 유지됩니다. 재사용 대기시간 : 40 초");
                }

                //마법사
                if (lore.get(i).contains("[ 고통의 대지 ]")){
                    lore.set(i+1,"고통의 대지 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 0.12));
                    lore.add(i+2,"지정한 위치에 고통의 대지를 형성하여 그 안의 적에게 지속적인 피해를 입힌다.");
                    lore.add(i+3,"직경 7블록에 10초 동안 25회 피해를 입힌다. 재사용 대기시간 : 27초");
                }
                if (lore.get(i).contains("[ 속죄 ]")){
                    lore.set(i+1,"속죄 패해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 1.3));
                    lore.add(i+2,"바라본 방향으로 어둠의 구체를 던져 맞은 적을 속박합니다.");
                    lore.add(i+3,"9블럭을 날아가며, 2.5초 동안 속박합니다. 재사용 대기시간 : 18 초");
                }
                if (lore.get(i).contains("[ 검은 손짓 ]")){
                    lore.set(i+1,"검은 손짓 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 1.25));
                    lore.add(i+2,"어둠의 기운이 바닥을 기어가 맞은 대상을 시전자의 앞으로 끌고옵니다.");
                    lore.add(i+3,"11블록을 기어가며, 1.5초 실명을 겁니다. 재사용 대기시간 : 24 초");
                }
                if (lore.get(i).contains("[ 순간이동 ]")){
                    lore.add(i+1,"일정 거리를 순간이동 합니다.");
                    lore.add(i+2,"최대 12블럭 순간이동 합니다. 재사용 대기시간 : 10 초");
                }
                if (lore.get(i).contains("[ 서릿발 ]")){
                    lore.set(i+1,"서릿발 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") *0.8));
                    lore.add(i+2,"주변을 순식간에 얼려 피해를 주며 둔화 효과를 부여합니다.");
                    lore.add(i+3,"반경 3.5블럭에 피해를 주며, 대상은 3초 둔화 효과가 부여됩니다. 재사용 대기시간 : 24 초");
                }
                if (lore.get(i).contains("[ 화염 ]")){
                    lore.set(i+1,"화염 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic")*0.1));
                    lore.add(i+2,"알으로 화염을 내뱉어 지속적인 피해를 입힙니다.");
                    lore.add(i+3,"1.5초 동안 지속되며, 총 15회 피해를 입힙니다. 재사용 대기시간 : 18 초");
                }
                if (lore.get(i).contains("[ 서리 지대 ]")){
                    lore.set(i+1,"서리 지대 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 0.08));
                    lore.add(i+2,"바라본 지점에 잠시동안 서리눈이 내리며, 맞은 대상에게 둔화 효과를 부여합니다.");
                    lore.add(i+3,"직경 10블럭에 10초동안 20회 피해를 주며, 0.5초 둔화 효과를 부여합니다. 재사용 대기시간 : 35 초");
                }
                if (lore.get(i).contains("[ 폭발 ]")){
                    lore.set(i+1,"폭발 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") *1.4 ));
                    lore.add(i+2,"폭발하는 화염을 앞으로 던져 피해를 입힙니다.");
                    lore.add(i+3,"12블럭 나아가며, 직경 3블럭 만큼 피해를 줍니다. 재사용 대기시간 : 8 초");
                }
                if (lore.get(i).contains("[ 치유 ]")){
                    lore.set(i+1,"치유 회복량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 1.1 ));
                    lore.add(i+2,"바라본 아군을 치유합니다.");
                    lore.add(i+3,"10블럭 내의 바라본 아군을 치유합니다. 재사용 대기시간 : 15 초");
                }
                if (lore.get(i).contains("[ 기도 ]")){
                    lore.set(i+1,"기도 회복량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Magic") * 0.6 ));
                    lore.add(i+2,"주변의 아군 모두를 치유합니다.");
                    lore.add(i+3,"반경 4블럭 내의 모든 아군을 치유합니다. 재사용 대기시간 : 24 초");
                }
            }
            player.getInventory().getItem(0).getItemMeta().setLore(lore);
        }
        if (player.getInventory().getItemInOffHand().getItemMeta().getLore().contains("[ 무기 ]")){
            ArrayList<String> lore = (ArrayList<String>) player.getInventory().getItemInOffHand().getItemMeta().getLore();
            for (int i = 0; i <= lore.size(); i++){

                if (lore.get(i).contains("[ 단검 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"단검의 기본 공격이다.");
                    lore.add(i+3,"사거리가 짧지만 빠른 공격으로 상대를 혼란시킬 수 있다.");
                }
                if (lore.get(i).contains("[ 역수 단검 기본 공격 ]")){
                    lore.set(i+1,"기본 공격 피해량 : "+ PlayerTotalStat.get(name+"Melee"));
                    lore.add(i+2,"단검의 역수 기본 공격이다.");
                    lore.add(i+3,"사거리가 짧지만 날카로운 공격으로 상대를 치명적으로 공격한다.");
                }
                //도적
                if (lore.get(i).contains("[ 일섬 ]")){
                    lore.set(i+1,"일섬 피해량 : "+  String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.35 ));
                    lore.add(i+2,"전방으로 빠르게 이동하며 3회 베어내는 기술이다.");
                    lore.add(i+3,"7블럭 만큼 돌진한다. 재사용 대기시간 : 15 초");
                }
                if (lore.get(i).contains("[ 출혈 ]")){
                    lore.set(i+1,"출혈 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.12));
                    lore.add(i+2,"무기에 날카로운 조각을 심어 다음 1회 공격을 통해 출혈 상태를 입힌다.");
                    lore.add(i+3,"출혈은 7회 피해를 입힌다. 재사용 대기시간 : 8 초");
                }
                if (lore.get(i).contains("[ 목 긋기 ]")){
                    lore.set(i+1,"목 긋기 피해량 : "+ String.format("%.2f",(PlayerTotalStat.get(name+"Melee") * 0.3) + (PlayerTotalStat.get(name+"Magic") * 0.5) ));
                    lore.add(i+2,"상대에게 빠르게 접근해 상대의 성대를 그어 침묵시킨다.");
                    lore.add(i+3,"4블럭 안의 지정댄 대상에게 피해를 입힌다. 재사용 대기시간 : 12 초");
                }
                if (lore.get(i).contains("[ 난도 ]")){
                    lore.set(i+1,"난도 피해량 : "+ String.format("%.2f",PlayerTotalStat.get(name+"Melee") *  0.25));
                    lore.add(i+2,"전방을 빠르게 6회 베어내어 피해를 입히는 기술이다.");
                    lore.add(i+3,"전방 3블럭을 베어낸다. 재사용 대기시간 : 14 초");
                }
                if (lore.get(i).contains("[ 곡예 ]")) {
                    lore.set(i + 1, "곡예 피해량 : " + String.format("%.2f",PlayerTotalStat.get(name+"Melee") * 0.8 ));
                    lore.add(i + 2, "뒤로 약간 후퇴하며 수리검을 날려 맞은 적의 뒤로 순간이동하는 기술이다.");
                    lore.add(i + 3, "2블럭 후퇴하며, 7블럭만큼 수리검을 던진다. 재사용 대기시간 : 17 초");
                }
            }
        }

    }

}




















