package fir.sec.thi.doxarts;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static fir.sec.thi.doxarts.GUI.SelectWeapon;
import static fir.sec.thi.doxarts.Teams.*;
import static fir.sec.thi.doxarts.Variable.money;

public class Command implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.isOp()){
                if (command.getName().equals("게임시작")){
                    for (Player online : Bukkit.getOnlinePlayers()){
                        long[] stat = Stats.getStat(online.getUniqueId().toString());
                        stat[0] = 1; stat[1] = 0; stat[2] = 7; stat[3] = 0; stat[4] = 0;stat[5] = 0; stat[6] = 0;
                        stat[7] = 0; stat[8] = 0; stat[9] = 0;stat[10] = 0;stat[11] = 0; stat[12] = 0; stat[13] = 0;
                        Stats.setStat(player.getUniqueId().toString(), stat);
                        for (int i = 0; i <= online.getInventory().getSize(); i++){
                            ItemStack air = new ItemStack(Material.AIR);
                            online.getInventory().setItem(i, air);
                            online.updateInventory();
                        }
                        online.sendTitle("5","잠시 후, 게임이 시작됩니다.",10,20,20);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        online.sendTitle("4","잠시 후, 게임이 시작됩니다.",10,20,20);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        online.sendTitle("3","잠시 후, 게임이 시작됩니다.",10,20,20);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        online.sendTitle("2","잠시 후, 게임이 시작됩니다.",10,20,20);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        online.sendTitle("1","잠시 후, 게임이 시작됩니다.",10,20,20);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        online.sendTitle("0","게임이 시작됩니다.",10,20,20);
                        if (online.getScoreboard().getTeams().equals("레드팀") || online.getScoreboard().getTeams().equals("블루팀")){
                            online.setHealth(0);
                        }
                        for (Entity entity : online.getWorld().getEntities()) {
                            if (!(entity instanceof Player)) {
                                entity.remove();
                            }
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (online.getScoreboard().getTeams().equals("블루팀") || online.getScoreboard().getTeams().equals("레드팀")){
                            SelectWeapon(online);
                            online.setGameMode(GameMode.ADVENTURE);
                        }
                        else {
                            online.setGameMode(GameMode.SPECTATOR);
                        }
                    }
                }
                if (command.getName().equals("초기화")){
                    for (Player online : Bukkit.getOnlinePlayers()){
                        long[] stat = Stats.getStat(online.getUniqueId().toString());
                        stat[0] = 1; stat[1] = 0; stat[2] = 7; stat[3] = 0; stat[4] = 0;stat[5] = 0; stat[6] = 0;
                        stat[7] = 0; stat[8] = 0; stat[9] = 0;stat[10] = 0;stat[11] = 0; stat[12] = 0; stat[13] = 0;
                        Stats.setStat(player.getUniqueId().toString(),stat);
                        for (int i = 0; i <= online.getInventory().getSize(); i++){
                            ItemStack air = new ItemStack(Material.AIR);
                            online.getInventory().setItem(i, air);
                            online.updateInventory();
                        }
                        money.put("red",0);
                        money.put("blue",0);
                        player.removeScoreboardTag("worrier");
                        player.removeScoreboardTag("assassin");
                        player.removeScoreboardTag("archer");
                        player.removeScoreboardTag("magician");
                        player.removeScoreboardTag("swordsman");
                        Bukkit.getWorld("world").setGameRule(GameRule.KEEP_INVENTORY,true);
                        Bukkit.getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE,false);
                        Bukkit.getWorld("world").setGameRule(GameRule.DO_TILE_DROPS,false);
                        Bukkit.getWorld("world").setGameRule(GameRule.RANDOM_TICK_SPEED,0);
                        Bukkit.getWorld("world").setGameRule(GameRule.FALL_DAMAGE,false);
                        Bukkit.getWorld("world").setGameRule(GameRule.DO_IMMEDIATE_RESPAWN,true);
                        Bukkit.getWorld("world").setGameRule(GameRule.COMMAND_BLOCK_OUTPUT,false);
                        Bukkit.getWorld("world").setGameRule(GameRule.DISABLE_RAIDS,true);
                        Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE,false);
                        Bukkit.getWorld("world").setGameRule(GameRule.DO_TRADER_SPAWNING,false);
                        Bukkit.getWorld("world").setGameRule(GameRule.DO_PATROL_SPAWNING,false);
                    }
                }
            }
            if (command.getName().equals("참가")){
                if (args.length == 0){
                    player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "===================="
                    +"\r\n"+ChatColor.WHITE+"/참가 레드" +ChatColor.RED+" 레드"+ChatColor.GRAY+" 팀에 참가합니다."
                    +"\r\n"+ChatColor.WHITE+"/참가 블루" +ChatColor.AQUA+" 레드"+ChatColor.GRAY+" 팀에 참가합니다."
                    +"\r\n"+ChatColor.WHITE+"/참가 관전" +ChatColor.DARK_GRAY+" 관전"+ChatColor.GRAY+" 팀에 참가합니다."
                    +"\r\n"+ChatColor.GRAY+ "==================================================");
                }
                else {
                    if (args[0].equals("레드")){
                        if (player.getScoreboard().getTeams().equals("레드팀")){
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.RED + "레드" + ChatColor.GRAY + "팀에 이미 소속되어 있습니다.");
                        } else {
                            Teams.RedTeamJoin(player);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.RED + "레드" + ChatColor.WHITE + "팀에 참가하였습니다.");
                        }
                    }
                    if (args[0].equals("블루")){
                        if (player.getScoreboard().getTeams().equals("블루팀")){
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.AQUA + "블루" + ChatColor.GRAY + "팀에 이미 소속되어 있습니다.");
                        } else {
                            Teams.BlueTeamJoin(player);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.AQUA + "블루" + ChatColor.WHITE + "팀에 참가하였습니다.");
                        }
                    }
                    if (args[0].equals("관전")){
                        TeamLeave(player);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]" + ChatColor.GRAY + "모든 팀에서 나왔습니다.");
                    }
                }
            }
            if (command.getName().equals("직업")){
                if (args.length == 0){
                    player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "===================="
                            +"\r\n"+ChatColor.WHITE+"/직업 전사" +ChatColor.DARK_GRAY+" 전사"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.WHITE+"/직업 검사" +ChatColor.DARK_RED+" 검사"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.WHITE+"/직업 도적" +ChatColor.GOLD+" 도적"+ChatColor.GRAY+"으로 전직합니다."
                            +"\r\n"+ChatColor.WHITE+"/직업 궁수" +ChatColor.GREEN+" 궁수"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.WHITE+"/직업 마법사" +ChatColor.LIGHT_PURPLE+" 마법사"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.GRAY+ "==================================================");
                }
                else {
                    if (args[0].equals("전사")){
                        player.addScoreboardTag("worrier");
                        player.removeScoreboardTag("assassin");
                        player.removeScoreboardTag("magician");
                        player.removeScoreboardTag("archer");
                        player.removeScoreboardTag("swordsman");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" +ChatColor.DARK_GRAY+" 전사"+ChatColor.GRAY+"로 전직했습니다!");
                    }
                    if (args[0].equals("검사")){
                        player.addScoreboardTag("swordsman");
                        player.removeScoreboardTag("worrier");
                        player.removeScoreboardTag("assassin");
                        player.removeScoreboardTag("magician");
                        player.removeScoreboardTag("archer");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" +ChatColor.DARK_GRAY+" 전사"+ChatColor.GRAY+"로 전직했습니다!");
                    }
                    if (args[0].equals("도적")){
                        player.removeScoreboardTag("worrier");
                        player.addScoreboardTag("assassin");
                        player.removeScoreboardTag("magician");
                        player.removeScoreboardTag("archer");
                        player.removeScoreboardTag("swordsman");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" +ChatColor.GOLD+" 도적"+ChatColor.GRAY+"으로 전직했습니다!");
                    }
                    if (args[0].equals("궁수")){
                        player.removeScoreboardTag("worrier");
                        player.removeScoreboardTag("assassin");
                        player.removeScoreboardTag("magician");
                        player.addScoreboardTag("archer");
                        player.removeScoreboardTag("swordsman");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" +ChatColor.GREEN+" 궁수"+ChatColor.GRAY+"로 전직했습니다!");
                    }
                    if (args[0].equals("마법사")){
                        player.removeScoreboardTag("worrier");
                        player.removeScoreboardTag("assassin");
                        player.addScoreboardTag("magician");
                        player.removeScoreboardTag("archer");
                        player.removeScoreboardTag("swordsman");
                        player.sendMessage(ChatColor.AQUA+"[ DOXRTS ]" +ChatColor.LIGHT_PURPLE+" 마법사"+ChatColor.GRAY+"로 전직했습니다!");
                    }

                }
            }
            if (command.getName().equals("스탯")){
                GUI.Status(player);
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.isOp()){
                if (args.length == 0){
                    return Arrays.asList("게임시작","초기화");
                }
            }
            if (args.length == 0){
                return Arrays.asList("참가","스탯");
            }
            else {
                if (args.length == 1){
                    if (command.getName().equals("참가")) {
                        return Arrays.asList("레드", "블루", "관전");
                    }
                }
            }
        }
        return null;
    }
}
