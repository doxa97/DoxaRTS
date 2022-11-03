package fir.sec.thi.doxarts.Game;

import fir.sec.thi.doxarts.Gui.GUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static fir.sec.thi.doxarts.Gui.GUI.fillChest;
import static fir.sec.thi.doxarts.Shop.Money.AddPerin;
import static fir.sec.thi.doxarts.Game.Teams.board;
import static fir.sec.thi.doxarts.Stat.Stats.getStat;
import static fir.sec.thi.doxarts.Variable.*;

public class AttackEvent implements Listener {

    public int Critical(Player player, int damage){
        String name = player.getName();
        Double critical = PlayerTotalStat.get(name+"Critical");
        if (critical > 100) critical = 100.0;
        if (critical < 0) critical = (double) 0;
        int chance = Random(0, 100);
        if (chance <= critical){
            player.sendMessage("Critical!");
            return damage*2;
        }
        else {
            return damage;
        }
    }

    public int Random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }

    @EventHandler
    public void Interact(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        String name = player.getName();
        ItemMeta i = player.getInventory().getItemInMainHand().getItemMeta();
        ItemMeta l = player.getInventory().getItemInOffHand().getItemMeta();
        if (player.getInventory().getItemInMainHand().getType().equals(Material.PAPER)){
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                if (i.getLore().contains("[ 재화 ]")) {
                    event.setCancelled(true);
                    if (board.getEntryTeam(player.getName()).getName().contains("레드팀")){
                        int perin = Integer.parseInt(i.getDisplayName().replace("[","").replace("]","").replace(" ","")
                                        .replace("DOXRTS","").replace("페린",""));
                        AddPerin("red",perin);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ChatColor.GRAY + perin + " 페린을 주머니에 넣었습니다.");
                    }
                    if (board.getEntryTeam(player.getName()).getName().contains("블루팀")){
                        int perin = Integer.parseInt(i.getDisplayName().replace("[","").replace("]","").replace(" ","")
                                .replace("DOXRTS","").replace("페린",""));
                        AddPerin("blue",perin);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ChatColor.GRAY + perin + " 페린을 주머니에 넣었습니다.");
                    }
                }
            }
        }
        if (player.getInventory().getItemInMainHand().getType().equals(Material.GLASS_BOTTLE)){
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                if (i.getLore().contains("[ 회복 ]")) {
                    event.setCancelled(true);
                    if (!(cooldown.get(name+"Potion") <= 0)) {
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "아직 물약 재사용 대기시간이 " + cooldown.get("Potion") + " 초 남았습니다.");
                    }
                    else {
                        cooldown.put(name+"Potion",3);
                        if (i.getDisplayName().contains("고급")) {
                            player.setHealth(player.getHealth() + (player.getHealthScale() / 50));
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "고급 회복 물약을 섭취하였습니다.");
                        }
                        if (i.getDisplayName().contains("중급")) {
                            player.setHealth(player.getHealth() + (player.getHealthScale() / 30));
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "중급 회복 물약을 섭취하였습니다.");
                        }
                        if (i.getDisplayName().contains("최고급")) {
                            player.setHealth(player.getHealth() + (player.getHealthScale() / 70));
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "최고급 회복 물약을 섭취하였습니다.");
                        }
                        if (i.getDisplayName().contains("하급")) {
                            player.setHealth(player.getHealth() + (player.getHealthScale() / 10));
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "하급 회복 물약을 섭취하였습니다.");
                        }
                        ItemStack air = new ItemStack(Material.AIR);
                        player.getInventory().setItemInMainHand(air);
                    }
                }
            }
        }
        if (player.getInventory().getItemInMainHand().getType().equals(Material.STICK)) {
            if (action == Action.LEFT_CLICK_AIR) {
                if (!player.isSneaking()) {
                    if (player.getAttackCooldown() < 1.0F) {
                        event.setCancelled(true);
                        int r = Random(1, 4);
                        switch (r) {
                            case 1 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "공격이 너무 성급합니다!");
                            case 2 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "공격이 준비되지 않았습니다!");
                            case 3 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "팔이 헛돌았습니다!");
                            case 4 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "집중이 흐트러졌습니다!");
                        }
                    } else {
                        if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                            event.setCancelled(true);
                            String s = String.valueOf(i.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                player.performCommand("cast " + skill);
                            }
                        }
                        if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                            event.setCancelled(true);
                            String s = String.valueOf(l.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                player.performCommand("cast " + skill);
                            }
                        }
                    }
                } else if (player.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                        event.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                        event.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                }
            } else if (action == Action.RIGHT_CLICK_AIR) {
                if (!player.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                } else if (player.isSneaking()){
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                }
            }
            if (action == Action.LEFT_CLICK_BLOCK) {
                if (!player.isSneaking()) {
                    if (player.getAttackCooldown() < 1.0F) {
                        event.setCancelled(true);
                        int r = Random(1, 4);
                        switch (r) {
                            case 1 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "공격이 너무 성급합니다!");
                            case 2 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "공격이 준비되지 않았습니다!");
                            case 3 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "팔이 헛돌았습니다!");
                            case 4 -> player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "집중이 흐트러졌습니다!");
                        }
                    } else {
                        if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                            event.setCancelled(true);
                            String s = String.valueOf(i.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                player.performCommand("cast " + skill);
                            }
                        }
                        if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                            event.setCancelled(true);
                            String s = String.valueOf(l.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                player.performCommand("cast " + skill);
                            }
                        }
                    }
                } else if (player.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                        event.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                        event.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                }
            } else if (action == Action.RIGHT_CLICK_BLOCK) {
                if (!player.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                } else if (player.isSneaking()){
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        event.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            player.performCommand("cast " + skill);
                        }
                    }
                }
            }
        }
    }


    @EventHandler
    public void PlayerDeath(PlayerDeathEvent event){

    LivingEntity killer = null;

    if (event.getEntity().getLastDamageCause() instanceof LivingEntity) {
        killer = (LivingEntity) event.getEntity().getLastDamageCause().getEntity();
    }
    Player death = event.getEntity();
    event.setDroppedExp(death.getLevel() * 5);
    if (board.getEntryTeam(death.getName()).getName().contains("레드팀")){
        if (killer == null){
            event.setDeathMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "레드팀의 " +death.getName() + "유저가 사망하여, 블루팀에게 300 페린이 지급됩니다! - 공헌자 : 없음");
        }
        else {
            event.setDeathMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "레드팀의 " +death.getName() + "유저가 사망하여, 블루팀에게 300 페린이 지급됩니다! - 공헌자 : " + killer.getName());
        }
        AddPerin("blue",300);
    }
        if (board.getEntryTeam(death.getName()).getName().contains("블루팀")){
            if (killer == null){
                event.setDeathMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "블루팀의 " +death.getName() + "유저가 사망하여, 레드팀에게 300 페린이 지급됩니다! - 공헌자 : 없음");
            }
            else {
                event.setDeathMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "블루팀의 " +death.getName() + "유저가 사망하여, 레드팀에게 300 페린이 지급됩니다! - 공헌자 : " + killer.getName());
            }
            AddPerin("red",300);
        }
    }

    @EventHandler
    public void Kill(EntityDeathEvent event){

        LivingEntity killer = null;

        if (event.getEntity().getLastDamageCause() instanceof LivingEntity) {
            killer = (LivingEntity) event.getEntity().getLastDamageCause().getEntity();
        }

        LivingEntity death = event.getEntity();
        if (board.getEntryTeam(killer.getName()).getName().contains("레드팀")){
            if (death.getName().contains("포탑")){
                AddPerin("red",750);
                Bukkit.broadcastMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "블루팀의 포탑이 파괴되어 레드팀에게 750 페린이 주어집니다!");
            }
            if (death.getName().contains("넥서스")){
                win.put("win","red");
                Bukkit.broadcastMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "블루팀의 넥서스가 파괴되었습니다!");
            }
            if (death.getName().contains("에르")){
                fillChest("red",GUI.GuiTool(Material.DIAMOND,ChatColor.DARK_GRAY+"에르 광물",
                        Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"일반적으로 채광하여 사용하는 기본적인 광물이다."),10000));
            }
            if (death.getName().contains("킨")){
                fillChest("red",GUI.GuiTool(Material.EMERALD,ChatColor.GREEN+"킨 광물",
                        Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"희귀하게 발견되어 비싸게 팔리는 광물이다."),10000));
            }
        }
        if (board.getEntryTeam(killer.getName()).getName().contains("블루팀")){
            if (death.getName().contains("포탑")){
                AddPerin("blue",750);
                Bukkit.broadcastMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "레드팀의 포탑이 파괴되어 블루팀에게 750 페린이 주어집니다!");
            }
            if (death.getName().contains("넥서스")){
                win.put("win","blue");
                Bukkit.broadcastMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "레드팀의 넥서스가 파괴되었습니다!");
            }
            if (death.getName().contains("에르")){
                fillChest("blue",GUI.GuiTool(Material.DIAMOND,ChatColor.DARK_GRAY+"에르 광물",
                        Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"일반적으로 채광하여 사용하는 기본적인 광물이다."),10000));
            }
            if (death.getName().contains("킨")){
                fillChest("blue",GUI.GuiTool(Material.EMERALD,ChatColor.GREEN+"킨 광물",
                        Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"희귀하게 발견되어 비싸게 팔리는 광물이다."),10000));
            }
        }

    }

    @EventHandler
    public void EntityHit(EntityDamageByEntityEvent e){
        LivingEntity entity = (LivingEntity) e.getEntity();
        LivingEntity damager = (LivingEntity) e.getDamager();
        if (damager instanceof Player){
            Player player = (Player) e.getDamager();
            String name = player.getName();
            double Damage = e.getDamage();
            Damage = Critical(player, (int) Damage);
            e.setDamage(Damage);
            double Drain = Damage / weapon.get(name+"drain");
            player.setHealth(Double.parseDouble(String.format("%.2f",player.getHealth() + Drain)));
        }
        if (board.getEntryTeam(entity.getName()).getName().equals("레드팀")){
            if (board.getEntryTeam(damager.getName()).getName().equals("레드팀")){
                e.setCancelled(true);
            }
        }
        if (board.getEntryTeam(entity.getName()).getName().equals("블루팀")){
            if (board.getEntryTeam(damager.getName()).getName().equals("블루팀")){
                e.setCancelled(true);
            }
        }
        entity.setNoDamageTicks(0);
    }
}
