package fir.sec.thi.doxarts.Game;

import fir.sec.thi.doxarts.Gui.GUI;
import fir.sec.thi.doxarts.Shop.Money;
import fir.sec.thi.doxarts.Stat.Stats;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static fir.sec.thi.doxarts.Game.Teams.*;
import static fir.sec.thi.doxarts.Gui.GUI.*;
import static fir.sec.thi.doxarts.Shop.Money.RemovePerin;
import static fir.sec.thi.doxarts.Shop.Money.SetPerin;
import static fir.sec.thi.doxarts.Variable.money;
import static fir.sec.thi.doxarts.Variable.win;
import static org.bukkit.Bukkit.getServer;

public class Command implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.isOp()){
                if (command.getName().equals("게임시작")){
                    if (win.get("game").equals("ing")){
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "게임 도중에는 팀에 참가하실 수 없습니다.");
                    }
                    else {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            long[] stat = Stats.getStat(online);
                            stat[0] = 1;
                            stat[1] = 0;
                            stat[2] = 7;
                            stat[3] = 0;
                            stat[4] = 0;
                            stat[5] = 0;
                            stat[6] = 0;
                            stat[7] = 0;
                            stat[8] = 0;
                            stat[9] = 0;
                            stat[10] = 0;
                            stat[11] = 0;
                            stat[12] = 0;
                            stat[13] = 0;
                            Stats.setStat(online, stat);
                            for (int i = 0; i <= online.getInventory().getSize(); i++) {
                                ItemStack air = new ItemStack(Material.AIR);
                                online.getInventory().setItem(i, air);
                                online.updateInventory();
                            }
                            online.sendTitle("5", "잠시 후, 게임이 시작됩니다.", 10, 20, 20);
                            RunSound(player, "ready", 70, 1);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            online.sendTitle("4", "잠시 후, 게임이 시작됩니다.", 10, 20, 20);
                            RunSound(player, "ready", 70, 1);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            online.sendTitle("3", "잠시 후, 게임이 시작됩니다.", 10, 20, 20);
                            RunSound(player, "ready", 70, 1);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            online.sendTitle("2", "잠시 후, 게임이 시작됩니다.", 10, 20, 20);
                            RunSound(player, "ready", 70, 1);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            online.sendTitle("1", "잠시 후, 게임이 시작됩니다.", 10, 20, 20);
                            RunSound(player, "ready", 70, 1);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            online.sendTitle("0", "게임이 시작됩니다.", 10, 20, 20);
                            RunSound(player, "start", 70, 1);
                            win.put("game", "ing");
                            if (board.getEntryTeam(online.getName()).getName().equals("레드팀") || board.getEntryTeam(online.getName()).getName().equals("블루팀")) {
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
                            if (board.getEntryTeam(online.getName()).getName().equals("블루팀") || board.getEntryTeam(online.getName()).getName().equals("레드팀")) {
                                SelectWeapon(online);
                                online.setGameMode(GameMode.ADVENTURE);
                            } else {
                                online.setGameMode(GameMode.SPECTATOR);
                            }
                        }
                    }
                }
                if (command.getName().equals("초기화")){
                    for (Player online : Bukkit.getOnlinePlayers()){
                        long[] stat = Stats.getStat(online);
                        stat[0] = 1; stat[1] = 0; stat[2] = 7; stat[3] = 0; stat[4] = 0;stat[5] = 0; stat[6] = 0;
                        stat[7] = 0; stat[8] = 0; stat[9] = 0;stat[10] = 0;stat[11] = 0; stat[12] = 0; stat[13] = 0;
                        Stats.setStat(online,stat);
                        for (int i = 0; i <= online.getInventory().getSize(); i++){
                            ItemStack air = new ItemStack(Material.AIR);
                            online.getInventory().setItem(i, air);
                            online.updateInventory();
                        }
                        money.put("red",0);
                        money.put("blue",0);
                        win.remove("win");
                        win.remove("game");

                        board.getEntryTeam(online.getName()).removeEntry(online.getName());

                        online.setHealth(0);

                        online.performCommand("clear @s");
                        online.removeScoreboardTag("worrier");
                        online.removeScoreboardTag("assassin");
                        online.removeScoreboardTag("archer");
                        online.removeScoreboardTag("magician");
                        online.removeScoreboardTag("swordsman");
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
                if (command.getName().equals("무기선택")){
                    if (args.length == 0){
                        player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "===================="
                                +"\r\n"+ChatColor.GRAY+"/무기선택 [대상] " +ChatColor.GRAY+"대상에게 무기 선택 창을 다시 띄워줍니다."
                                +"\r\n"+ChatColor.GRAY+ "==================================================");
                    }
                    else {
                        String selectPlayerName = args[1];
                        Player selectPlayer = getServer().getPlayer(selectPlayerName);
                        SelectWeapon(selectPlayer);
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ChatColor.GRAY + "정상적으로 해당 대상에게 무기 선택 창을 띄웠습니다.");
                    }
                }
                if (command.getName().equals("기술선택")){
                    if (args.length == 0){
                        player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "===================="
                                +"\r\n"+ChatColor.GRAY+"/기술선택 [대상] " +ChatColor.GRAY+"대상에게 기술 선택 창을 다시 띄워줍니다."
                                +"\r\n"+ChatColor.GRAY+ "==================================================");
                    }
                    else {
                        String selectPlayerName = args[1];
                        Player selectPlayer = getServer().getPlayer(selectPlayerName);
                        if (selectPlayer.getScoreboardTags().contains("magician")){
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ChatColor.GRAY + "대상의 직업이 마법사가 아닙니다.");
                        }
                        else {
                            SelectMagicianSkill(selectPlayer);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] "+ChatColor.GRAY + "정상적으로 해당 대상에게 기술 선택 창을 띄웠습니다.");
                        }
                    }
                }
            }
            if (command.getName().equals("참가")){
                if (args.length == 0){
                    player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "===================="
                    +"\r\n"+ChatColor.GRAY+"/참가 레드" +ChatColor.RED+" 레드"+ChatColor.GRAY+" 팀에 참가합니다."
                    +"\r\n"+ChatColor.GRAY+"/참가 블루" +ChatColor.AQUA+" 레드"+ChatColor.GRAY+" 팀에 참가합니다."
                    +"\r\n"+ChatColor.GRAY+"/참가 관전" +ChatColor.DARK_GRAY+" 관전"+ChatColor.GRAY+" 팀에 참가합니다."
                    +"\r\n"+ChatColor.GRAY+ "==================================================");
                }

                else {
                    if (win.get("game").equals("ing")){
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "게임 도중에는 팀에 참가하실 수 없습니다.");
                    }
                    else {
                        if (args[0].equals("레드")) {
                            if (player.getScoreboard().getTeams().equals("레드팀")) {
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.RED + "레드" + ChatColor.GRAY + "팀에 이미 소속되어 있습니다.");
                            } else {
                                RedTeamJoin(player);
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.RED + "레드" + ChatColor.GRAY + "팀에 참가하였습니다.");
                            }
                        }
                        if (args[0].equals("블루")) {
                            if (player.getScoreboard().getTeams().equals("블루팀")) {
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.AQUA + "블루" + ChatColor.GRAY + "팀에 이미 소속되어 있습니다.");
                            } else {
                                BlueTeamJoin(player);
                                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.AQUA + "블루" + ChatColor.GRAY + "팀에 참가하였습니다.");
                            }
                        }
                        if (args[0].equals("관전")) {
                            TeamLeave(player);
                            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "모든 팀에서 나왔습니다.");
                        }
                    }
                }
            }
            if (command.getName().equals("직업")){
                if (args.length == 0){
                    player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "===================="
                            +"\r\n"+ChatColor.GRAY+"/직업 전사" +ChatColor.DARK_GRAY+" 전사"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.GRAY+"/직업 검사" +ChatColor.DARK_RED+" 검사"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.GRAY+"/직업 도적" +ChatColor.GOLD+" 도적"+ChatColor.GRAY+"으로 전직합니다."
                            +"\r\n"+ChatColor.GRAY+"/직업 궁수" +ChatColor.GREEN+" 궁수"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.GRAY+"/직업 마법사" +ChatColor.LIGHT_PURPLE+" 마법사"+ChatColor.GRAY+"로 전직합니다."
                            +"\r\n"+ChatColor.GRAY+ "==================================================");
                }
                else {
                    if (win.get("game").equals("ing")){
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "게임 도중에는 직업을 바꾸실 수 없습니다.");
                    }
                    else {
                        if (args[0].equals("전사")){
                            player.addScoreboardTag("worrier");
                            player.removeScoreboardTag("assassin");
                            player.removeScoreboardTag("magician");
                            player.removeScoreboardTag("archer");
                            player.removeScoreboardTag("swordsman");
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ] " +ChatColor.DARK_GRAY+" 전사"+ChatColor.GRAY+"로 전직했습니다!");
                        }
                        if (args[0].equals("검사")){
                            player.addScoreboardTag("swordsman");
                            player.removeScoreboardTag("worrier");
                            player.removeScoreboardTag("assassin");
                            player.removeScoreboardTag("magician");
                            player.removeScoreboardTag("archer");
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ] " +ChatColor.DARK_GRAY+" 전사"+ChatColor.GRAY+"로 전직했습니다!");
                        }
                        if (args[0].equals("도적")){
                            player.removeScoreboardTag("worrier");
                            player.addScoreboardTag("assassin");
                            player.removeScoreboardTag("magician");
                            player.removeScoreboardTag("archer");
                            player.removeScoreboardTag("swordsman");
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ] " +ChatColor.GOLD+" 도적"+ChatColor.GRAY+"으로 전직했습니다!");
                        }
                        if (args[0].equals("궁수")){
                            player.removeScoreboardTag("worrier");
                            player.removeScoreboardTag("assassin");
                            player.removeScoreboardTag("magician");
                            player.addScoreboardTag("archer");
                            player.removeScoreboardTag("swordsman");
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ] " +ChatColor.GREEN+" 궁수"+ChatColor.GRAY+"로 전직했습니다!");
                        }
                        if (args[0].equals("마법사")){
                            player.removeScoreboardTag("worrier");
                            player.removeScoreboardTag("assassin");
                            player.addScoreboardTag("magician");
                            player.removeScoreboardTag("archer");
                            player.removeScoreboardTag("swordsman");
                            player.sendMessage(ChatColor.AQUA+"[ DOXRTS ] " +ChatColor.LIGHT_PURPLE+" 마법사"+ChatColor.GRAY+"로 전직했습니다!");
                        }
                    }
                }
            }
            if (command.getName().equals("스탯")){
                GUI.Status(player);
            }
            if (command.getName().equals("페린")){
                if (args.length == 0){
                    if (player.isOp()){
                        player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "===================="
                                +"\r\n"+ChatColor.GRAY+"/페린 [금액] [개수] " +ChatColor.GRAY+"페린을 꺼내는 명령어입니다."
                                +"\r\n"+ChatColor.GRAY+"/페린 설정 [팀] [금액] " +ChatColor.GRAY+"대상 팀의 페린을 설정할 수 있습니다."
                                +"\r\n"+ChatColor.GRAY+ "==================================================");
                    }
                    else {
                        player.sendMessage(ChatColor.GRAY+ "===================="+ ChatColor.AQUA + "[ DOXRTS ] "+ ChatColor.GRAY + "===================="
                                +"\r\n"+ChatColor.GRAY+"/페린 [금액] [개수] " +ChatColor.GRAY+"페린을 꺼내는 명령어입니다."
                                +"\r\n"+ChatColor.GRAY+ "==================================================");
                    }
                }

                else {
                    if (!win.get("game").equals("ing")){
                        player.sendMessage(ChatColor.AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "게임이 진행 중일때만 사용 가능합니다.");
                    }
                    else {
                        if (args[0].equals("설정")) {
                            if (args[1].equals("red")) {
                                SetPerin("red", Integer.parseInt(args[2]));
                            }
                            if (args[1].equals("blue")) {
                                SetPerin("blue", Integer.parseInt(args[2]));
                            }
                        }
                        else {
                            if (args.length == 1) {

                                int perin = 0;

                                try {
                                    perin = Integer.parseInt(args[0]);
                                } catch (Exception e) {
                                    player.sendMessage("Error");
                                }
                                if (perin <= 0) {
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "음수 및 0은 제공되지 않습니다 고객님 ^^7");
                                } else {
                                    if (board.getEntryTeam(player.getName()).getName().contains("레드팀")) {
                                        if (money.get("red") > perin) {
                                            ItemStack paper = new ItemStack(Material.PAPER);
                                            ItemMeta im = paper.getItemMeta();
                                            assert im != null;
                                            im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + args[0] + " 페린");
                                            im.setLore(Arrays.asList(ChatColor.GOLD + "[ 재화 ]", ChatColor.GRAY + "전 지역에서 활발하게 사용되는 화폐이다.", ChatColor.GRAY + "재질은 아르킨 제국의 하프의 털로 만들어져 부드럽다."));
                                            im.setCustomModelData(1);
                                            paper.setItemMeta(im);
                                            player.getInventory().addItem(paper);
                                            RemovePerin("red", perin);
                                        } else {
                                            player.sendMessage(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "돈이 부족합니다.");
                                        }
                                    }
                                    if (board.getEntryTeam(player.getName()).getName().contains("블루팀")) {
                                        if (money.get("blue") > perin) {
                                            ItemStack paper = new ItemStack(Material.PAPER);
                                            ItemMeta im = paper.getItemMeta();
                                            assert im != null;
                                            im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + args[0] + " 페린");
                                            im.setLore(Arrays.asList(ChatColor.GOLD + "[ 재화 ]", ChatColor.GRAY + "전 지역에서 활발하게 사용되는 화폐이다.", ChatColor.GRAY + "재질은 아르킨 제국의 하프의 털로 만들어져 부드럽다."));
                                            im.setCustomModelData(1);
                                            paper.setItemMeta(im);
                                            player.getInventory().addItem(paper);
                                            RemovePerin("blue", perin);
                                        } else {
                                            player.sendMessage(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "돈이 부족합니다.");
                                        }
                                    }
                                }
                            }
                            if (args.length == 2) {
                                int perin = 0;
                                int num = 0;
                                try {
                                    perin = Integer.parseInt(args[0]);
                                    num = Integer.parseInt(args[1]);
                                } catch (Exception e) {
                                    player.sendMessage("Error");
                                }
                                if (perin < 0) {
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "음수 및 0은 제공되지 않습니다 고객님 ^^7");
                                } else {
                                    if (board.getEntryTeam(player.getName()).getName().contains("레드팀")) {
                                        if (perin < money.get("red")) {
                                            ItemStack paper = new ItemStack(Material.PAPER);
                                            ItemMeta im = paper.getItemMeta();
                                            assert im != null;
                                            im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + args[0] + " 페린");
                                            im.setLore(Arrays.asList(ChatColor.GOLD + "[ 재화 ]", ChatColor.GRAY + "전 지역에서 활발하게 사용되는 화폐이다.", ChatColor.GRAY + "재질은 아르킨 제국의 히프의 털로 만들어져 부드럽다."));
                                            im.setCustomModelData(1);
                                            paper.setItemMeta(im);
                                            for (int i = 0; i < num; i++) {
                                                player.getInventory().addItem(paper);
                                            }
                                            RemovePerin("red", perin * num);
                                        } else {
                                            player.sendMessage(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "돈이 부족합니다.");
                                        }
                                    }
                                    if (board.getEntryTeam(player.getName()).getName().contains("블루팀")) {
                                        if (perin < money.get("blue")) {
                                            ItemStack paper = new ItemStack(Material.PAPER);
                                            ItemMeta im = paper.getItemMeta();
                                            assert im != null;
                                            im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + args[0] + " 페린");
                                            im.setLore(Arrays.asList(ChatColor.GOLD + "[ 재화 ]", ChatColor.GRAY + "전 지역에서 활발하게 사용되는 화폐이다.", ChatColor.GRAY + "재질은 아르킨 제국의 히프의 털로 만들어져 부드럽다."));
                                            im.setCustomModelData(1);
                                            paper.setItemMeta(im);
                                            for (int i = 0; i < num; i++) {
                                                player.getInventory().addItem(paper);
                                            }
                                            RemovePerin("blue", perin * num);
                                        } else {
                                            player.sendMessage(ChatColor.DARK_AQUA + "[ DOXRTS ] " + ChatColor.GRAY + "돈이 부족합니다.");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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
                    return Arrays.asList("게임시작","초기화","무기선택","기술선택");
                }
            }
            if (args.length == 0){
                return Arrays.asList("참가","스탯","직업","페린");
            }
            else {
                if (args.length == 1){
                    if (command.getName().equals("참가")) {
                        return Arrays.asList("레드", "블루", "관전");
                    }
                    if (command.getName().equals("직업")) {
                        return Arrays.asList("전사","검사","도적","궁수","마법사");
                    }
                    if (command.getName().equals("페린")) {
                        if (player.isOp()){
                            return List.of("설정");
                        }
                        return List.of("< 금액 >");
                    }
                }
                if (command.getName().equals("에르")){
                    if (args.length == 2) {
                        if (args[1].equals("설정")){
                            if (player.isOp()){
                                return List.of("< 대상 팀 >");
                            }
                        }
                        return List.of("< 수량 >");
                    }
                    if (args.length == 3) {
                        if (args[1].equals("설정")){
                            if (player.isOp()){
                                return List.of("< 금액 >");
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
