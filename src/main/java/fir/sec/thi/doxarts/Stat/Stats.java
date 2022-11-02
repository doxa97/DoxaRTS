package fir.sec.thi.doxarts.Stat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static fir.sec.thi.doxarts.Gui.GUI.RunSound;

public class Stats implements Listener {

    /*

    활력 1 = 초당 체력 재생 3 체력 증가 25
    근력 1 = 물리 공격력 6 체력 10
    민첩 1 = 이동 속도 0.05 치명타 확률 3 공격 속도 0.05
    지력 1 = 마법 공격력 10
    손재주 1 = 물리 공격력 3 마법 공격력 3 치명타 확률 1

     */

    public static void CreateNewStat(Player player) {
        File filename = new File("plugins/RTS/Stat/" + player.getName() + ".yml");
        File folder_Location1 = new File("plugins/RTS/");
        File folder_Location2 = new File("plugins/RTS/Stat");
        try {
            if (!filename.exists()) {
                folder_Location1.mkdir();
                folder_Location2.mkdir();
                filename.createNewFile();
            }
            BufferedWriter w = new BufferedWriter(new FileWriter(filename));
            w.append("레벨:1"+"\r\n"+"여유스탯:0"+"\r\n"+"최대경험치:7"+"\r\n"+"현재경험치:0"+"\r\n"+"활력:0"+"\r\n"+"근력:0"+"\r\n"+"민첩:0"
                    +"\r\n"+"지력:0"+"\r\n"+"손재주:0"+"\r\n"+"총 활력:0"+"\r\n"+"총 근력:0"+"\r\n"+"총 민첩:0"
                    +"\r\n"+"총 지력:0"+"\r\n"+"총 손재주:0");
            w.flush();
            w.close();
        } catch (IOException ignored) {
        }
    }

    public static long[] getStat(Player player) {
        File filename = new File("plugins/RTS/Stat/" + player.getName() + ".yml");
        File folder_Location1 = new File("plugins/RTS/");
        File folder_Location2 = new File("plugins/RTS/Stat");
        long[] stat = new long[14];
        try {
            if (!filename.exists()) {
                folder_Location1.mkdir();
                folder_Location2.mkdir();
                filename.createNewFile();
            }
            BufferedReader R = new BufferedReader(new FileReader(filename));
            List list = new ArrayList();
            String s;
            while ((s = R.readLine()) != null) {
                list.add(Cutter(s));
            }
            R.close();
            for (int count = 0; count < 13; count++) {
                stat[count] = (Long) list.get(count);
            }
            return stat;
        } catch (IOException ignored) {
        }
        return stat;
    }

    public static long Cutter(String line) {
        String[] cut = line.split(":");
        return Long.parseLong(cut[1]);
    }

    public static void setStat(Player player, long[] stat) {
        File filename = new File("plugins/RTS/Stat/" + player.getName() + ".yml");
        File folder_Location1 = new File("plugins/RTS/");
        File folder_Location2 = new File("plugins/RTS/Stat");
        try {
            if (!filename.exists()) {
                folder_Location1.mkdir();
                folder_Location2.mkdir();
                filename.createNewFile();
            }
            BufferedWriter W = new BufferedWriter(new FileWriter(filename));
            W.append("레벨:"+stat[0]+"\r\n"+"여유스탯:"+stat[1]+"\r\n"+"최대경험치:"+stat[2]+"\r\n"+"현재경험치:"+stat[3]+"\r\n"+"활력:"+stat[4]+"\r\n"+"근력:"+stat[5]+"\r\n"+"민첩:"+stat[6]
                    +"\r\n"+"지력:"+stat[7]+"\r\n"+"손재주:"+stat[8]+"\r\n"+"총 활력:"+stat[9]+"\r\n"+"총 근력:"+stat[10]+"\r\n"+"총 민첩:"+stat[11]
                    +"\r\n"+"총 지력:"+stat[12]+"\r\n"+"총 손재주:"+stat[13]);
            W.flush();
            W.close();
        } catch (IOException ignored) {
        }
    }

    public static void StatUp(long[] stat, Player player, int num) {
        if (stat[1] > 0) {
            stat[num] = stat[num] + 1;
            stat[1] = stat[1] - 1;
            setStat(player, stat);
            RunSound(player,"gui",70,1);
        } else {
            player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "잔여 스탯이 부족합니다.");
            RunSound(player,"no",70,1);
        }
    }

    public static void LevelUP(long[] stat, Player player) {
        for (; ; ) {
            if (stat[2] < stat[3]) {
                break;
            } else {
                stat[3] = stat[3] - stat[2];
                stat[0] = stat[0] + 1;
                stat[2] = (stat[0] * 2) + stat[3];
                stat[1] = stat[1] + 3;
                player.sendMessage(ChatColor.AQUA + "[ DOXRTS ]"+ ChatColor.GRAY + "Level Up! 더욱 강해지는 것이 느껴집니다..!");
                RunSound(player,"levelup",70,1);
                setStat(player, stat);
            }
        }
    }

}
