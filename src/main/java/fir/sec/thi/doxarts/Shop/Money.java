package fir.sec.thi.doxarts.Shop;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static fir.sec.thi.doxarts.Game.Teams.board;
import static fir.sec.thi.doxarts.Variable.money;

public class Money implements Listener {

    public static void  PerinActionBar(Player player){
        if (board.getEntryTeam(player.getName()).getName().contains("레드팀")){
            player.sendMessage(ChatMessageType.ACTION_BAR+"페린 소지량 : " + money.get("red"));
        }
        if (board.getEntryTeam(player.getName()).getName().contains("블루팀")){
            player.sendMessage(ChatMessageType.ACTION_BAR+"페린 소지량 : " + money.get("blue"));
        }
    }
    public static void AddPerin(String team, int add){
        if (team.equals("red")){
            int haveMoney = money.get("red");
            money.put("red",haveMoney + add);
        }
        if (team.equals("blue")){
            int haveMoney = money.get("blue");
            money.put("blue",haveMoney + add);
        }
    }

    public static void RemovePerin(String team, int remove){
        if (team.equals("red")){
            int haveMoney = money.get("red");
            money.put("red",haveMoney - remove);
        }
        if (team.equals("blue")){
            int haveMoney = money.get("blue");
            money.put("blue",haveMoney - remove);
        }
    }

    public static void SetPerin(String team, int set){
        if (team.equals("red")){
            money.put("red",set);
        }
        if (team.equals("blue")){
            money.put("blue",set);
        }
    }

}
