package fir.sec.thi.doxarts;

import org.bukkit.event.Listener;

import static fir.sec.thi.doxarts.Variable.money;

public class Money implements Listener {

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

}
