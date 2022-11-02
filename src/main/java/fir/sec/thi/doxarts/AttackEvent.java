package fir.sec.thi.doxarts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static fir.sec.thi.doxarts.Money.AddPerin;
import static fir.sec.thi.doxarts.Teams.board;
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
    public void Interact(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();
        ItemMeta i = p.getInventory().getItemInMainHand().getItemMeta();
        ItemMeta l = p.getInventory().getItemInOffHand().getItemMeta();
        if (p.getInventory().getItemInMainHand().getType().equals(Material.STICK)) {
            if (a == Action.LEFT_CLICK_AIR) {
                if (!p.isSneaking()) {
                    if (p.getAttackCooldown() < 1.0F) {
                        e.setCancelled(true);
                        int r = Random(1, 4);
                        switch (r) {
                            case 1:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "공격이 너무 성급합니다!");
                            case 2:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "공격이 준비되지 않았습니다!");
                            case 3:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "팔이 헛돌았습니다!");
                            case 4:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "집중이 흐트러졌습니다!");
                        }
                    } else {
                        if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                            e.setCancelled(true);
                            String s = String.valueOf(i.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                p.performCommand("cast " + skill);
                            }
                        }
                        if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                            e.setCancelled(true);
                            String s = String.valueOf(l.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                p.performCommand("cast " + skill);
                            }
                        }
                    }
                } else if (p.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                        e.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                }
            } else if (a == Action.RIGHT_CLICK_AIR) {
                if (!p.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                } else if (p.isSneaking()){
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                }
            }
            if (a == Action.LEFT_CLICK_BLOCK) {
                if (!p.isSneaking()) {
                    if (p.getAttackCooldown() < 1.0F) {
                        e.setCancelled(true);
                        int r = Random(1, 4);
                        switch (r) {
                            case 1:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "공격이 너무 성급합니다!");
                            case 2:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "공격이 준비되지 않았습니다!");
                            case 3:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "팔이 헛돌았습니다!");
                            case 4:
                                p.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "집중이 흐트러졌습니다!");
                        }
                    } else {
                        if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                            e.setCancelled(true);
                            String s = String.valueOf(i.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                p.performCommand("cast " + skill);
                            }
                        }
                        if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                            e.setCancelled(true);
                            String s = String.valueOf(l.getLore().contains("첫번째 슬롯"));
                            if (!s.contains("비어 있음")){
                                String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                                p.performCommand("cast " + skill);
                            }
                        }
                    }
                } else if (p.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")) {
                        e.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("세번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                }
            } else if (a == Action.RIGHT_CLICK_BLOCK) {
                if (!p.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("두번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                } else if (p.isSneaking()){
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                    if (Objects.requireNonNull(Objects.requireNonNull(l).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(l.getLore().contains("네번째 슬롯"));
                        if (!s.contains("비어 있음")){
                            String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void Kill(EntityDeathEvent event){

        LivingEntity killer = (LivingEntity) event.getEntity().getLastDamageCause().getEntity();
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
        if (e.getEntity().isDead()){
            if (damager.getName().contains("블루")){
                if (entity.getName().contains("에르")){
                    fillChest(0,60,0,"world",GUI.GuiTool(Material.DIAMOND,ChatColor.DARK_GRAY+"에르 광물",
                            Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"일반적으로 채광하여 사용하는 기본적인 광물이다."),10000));
                }
                if (entity.getName().contains("킨")){
                    fillChest(0,60,0,"world",GUI.GuiTool(Material.EMERALD,ChatColor.GREEN+"킨 광물",
                            Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"희귀하게 발견되어 비싸게 팔리는 광물이다."),10000));
                }
            }
            if (damager.getName().contains("레드")){
                if (entity.getName().contains("에르")){
                    fillChest(3,60,3,"world",GUI.GuiTool(Material.DIAMOND,ChatColor.DARK_GRAY+"에르 광물",
                            Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"일반적으로 채광하여 사용하는 기본적인 광물이다."),10000));
                }
                if (entity.getName().contains("킨")){
                    fillChest(3,60,3,"world",GUI.GuiTool(Material.EMERALD,ChatColor.GREEN+"킨 광물",
                            Arrays.asList(ChatColor.GOLD+"[ 재료 ]",ChatColor.GRAY+"희귀하게 발견되어 비싸게 팔리는 광물이다."),10000));
                }
            }
        }
        entity.setNoDamageTicks(0);
    }

    public void fillChest(int xPos, int yPos, int zPos, String world, ItemStack... items){
        try {
            World w = Bukkit.getWorld(world);
            Block b = Objects.requireNonNull(w).getBlockAt(xPos, yPos, zPos);
            Chest c = (Chest) b.getState();
            Inventory i = c.getInventory();
            i.addItem(items);
        } catch (Exception e){
            Bukkit.getConsoleSender().sendMessage("상자 채우기 실패");
        }
    }

}
