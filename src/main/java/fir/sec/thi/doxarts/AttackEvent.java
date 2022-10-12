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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class AttackEvent implements Listener {

    public int Critical(Player player, Long LUK, int damage){
        long[] stat;
        stat = Stats.getStat(player.getUniqueId().toString());
        int critical = (int)(LUK/100);
        if (critical > 100) critical = 100;
        if (critical < 0) critical = 0;
        stat[16] = critical;
        Stats.setStat(player.getUniqueId().toString(), stat);
        int chance = Random(0, 100);
        if (chance <= stat[16]){
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
        if (!p.getInventory().getItemInMainHand().getType().equals(Material.BOW)) {
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
                            String skill = s.replace("첫번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                            p.performCommand("cast " + skill);
                        }
                    }
                } else if (p.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")) {
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("세번째 슬롯"));
                        String skill = s.replace("세번째 슬롯 : ", "").replace("[ ","").replace(" ]","");
                        p.performCommand("cast " + skill);
                    }
                }
            } else if (a == Action.RIGHT_CLICK_AIR) {
                if (!p.isSneaking()) {
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("두번째 슬롯"));
                        String skill = s.replace("두번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                        p.performCommand("cast " + skill);
                    }
                } else if (p.isSneaking()){
                    if (Objects.requireNonNull(Objects.requireNonNull(i).getLore()).contains("[ 무기 ]")){
                        e.setCancelled(true);
                        String s = String.valueOf(i.getLore().contains("네번째 슬롯"));
                        String skill = s.replace("네번째 슬롯 : ","").replace("[ ","").replace(" ]","");
                        p.performCommand("cast " + skill);
                    }
                }
            }
        }

    }

    @EventHandler
    public void EntityHit(EntityDamageByEntityEvent e){
        LivingEntity entity = (LivingEntity) e.getEntity();
        entity.setNoDamageTicks(0);
        entity.setMaximumNoDamageTicks(0);
        if (e.getDamager() instanceof Player){
            Player player = (Player) e.getDamager();
            double Damage = e.getDamage();
            long[] Stat = Stats.getStat(e.getDamager().getUniqueId().toString());
            Damage = Critical(player, Stat[11], (int) Damage);
            e.setDamage(Damage);
        }
        if (((LivingEntity) e.getEntity()).getHealth() <= e.getDamage()){
            LivingEntity damager = (LivingEntity) e.getDamager();
            if (damager.getName().contains("블루")){
                if (entity.getName().contains("에르")){
                    ItemStack item = new ItemStack(Material.DIAMOND, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("에르");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(0, -60, 0, "world", item);
                }
                else if (entity.getName().contains("킨")){
                    ItemStack item = new ItemStack(Material.EMERALD, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("킨");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(0, -60, 0, "world", item);
                }
            } else if (damager.getName().contains("레드")){
                if (entity.getName().contains("에르")){
                    ItemStack item = new ItemStack(Material.DIAMOND, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("에르");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(2, -60, 0, "world", item);
                }
                else if (entity.getName().contains("킨")){
                    ItemStack item = new ItemStack(Material.EMERALD, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("킨");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(2, -60, 0, "world", item);
                }
            }
        }
    }

    /*@EventHandler
    public void EntityDead(EntityDeathEvent e){
        if (e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e.getEntity().getLastDamageCause();
            if (event.getDamager().getName().contains("블루")){
                if (e.getEntity().getName().contains("에르")){
                    ItemStack item = new ItemStack(Material.DIAMOND, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("에르");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(0, -60, 0, "world", item);
                }
                if (e.getEntity().getName().contains("킨")){
                    ItemStack item = new ItemStack(Material.EMERALD, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("킨");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(0, -60, 0, "world", item);
                }
            }
            if (event.getDamager().getName().contains("레드")){
                if (e.getEntity().getName().contains("에르")){
                    ItemStack item = new ItemStack(Material.DIAMOND, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("에르");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(2, -60, 0, "world", item);
                }
                if (e.getEntity().getName().contains("킨")){
                    ItemStack item = new ItemStack(Material.EMERALD, 1);
                    ItemMeta meta = item.getItemMeta();
                    Objects.requireNonNull(meta).setDisplayName("킨");
                    meta.setLore(Arrays.asList("test1", "test2" + "test3"));
                    item.setItemMeta(meta);
                    fillChest(2, -60, 0, "world", item);
                }
            }
        }
    }*/

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
