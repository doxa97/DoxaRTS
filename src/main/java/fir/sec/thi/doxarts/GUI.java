package fir.sec.thi.doxarts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fir.sec.thi.doxarts.Item.MagicianWeaponSetting;
import static fir.sec.thi.doxarts.Item.NormalWeaponSetting;

public class GUI implements Listener {

    public static ItemStack GuiTool(Material material, String DisplayName, List<String> Lore, int CustomModelData){
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(DisplayName);
        meta.setLore(Lore);
        meta.setCustomModelData(CustomModelData);
        meta.setUnbreakable(true);
        stack.setItemMeta(meta);
        return stack;
    }

    public static void Status(Player player){
        Inventory status = Bukkit.createInventory(null, 9,"[ S T A T U S ]");

        status.setItem(0, GuiTool(Material.COOKED_BEEF, ChatColor.RED+ "[ 활력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(2, GuiTool(Material.IRON_SWORD, ChatColor.DARK_RED + "[ 근력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(4, GuiTool(Material.LEATHER_BOOTS,  ChatColor.AQUA+ "[ 민첩 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(6, GuiTool(Material.KNOWLEDGE_BOOK, ChatColor.DARK_PURPLE + "[ 지력 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));
        status.setItem(8, GuiTool(Material.BOW,  ChatColor.GOLD+ "[ 손재주 ]", Arrays.asList(ChatColor.GRAY+"dsa","asd"), 10000));

        player.openInventory(status);

    }

    public static void SelectWeapon(Player player){
        Inventory Select = Bukkit.createInventory(null, 9, "[ 무기 선택 ]");

        if (player.getScoreboardTags().contains("worrier")){
            Select.setItem(2 ,NormalWeaponSetting(player, 3,"끝 없는 광기","광기에 물든 어느 한 광전사가 사용했던, 이제는 주인 없는 검.",12,0.6,0,3,"대검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(4 ,NormalWeaponSetting(player, 4,"길 잃은 영혼의 인도자","보랗게 빛나는 빛은 길 잃은 영혼들의 안식처일 것이다.",16,0.3,0,6,"대검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(6 ,NormalWeaponSetting(player, 5,"심연의 송곳니","찢어질 듯한 고통이 울부짖는다.",9,0.65,0,4,"대검 기본 공격","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("swordsman")){
            Select.setItem(2 ,NormalWeaponSetting(player, 6,"잠식된 어둠","어둠에 굴복한 검.",7,0.9,3,2,"직검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(4 ,NormalWeaponSetting(player, 7,"혼돈 속의 찬란함","찬란한 빛은 아직 혼돈에게 저항 중이다.",8,0.85,2,3,"직검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(6 ,NormalWeaponSetting(player, 8,"은하를 담은 도신","운석으로 제작한 은하를 담은 검.",6,0.8,5,3,"직검 기본 공격","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("archer")){
            Select.setItem(3 ,NormalWeaponSetting(player, 9,"성스러운 신자의 유품","사용된 적이 없어 제대로 작동할 지 모르지만, 보장된 품질.",7,0.4,4,1,"장궁 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(6 ,NormalWeaponSetting(player, 10,"꿰뚫는 눈","푸르게 빛나는 이 활은 상대를 꿰뚫는데 특화되어있다.",9,0.28,6,0,"장궁 기본 공격","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("assassin")){
            Select.setItem(1 ,NormalWeaponSetting(player, 1,"현상금 사냥","현상금에 미친 어느 한 사냥꾼의 금으로 만든 단검.",3,1.1,7,2,"[ 단검 기본 공격 ]","기본 공격 피해량 : 0"));
            Select.setItem(3 ,NormalWeaponSetting(player, 2,"파도 속 고요함","시끄러이 울려 퍼질 파도 속의 고요함. 베인 자도 고요해질까.",4,0.95,8,2,"[ 단검 기본 공격 ]","기본 공격 피해량 : 0"));
            Select.setItem(5 ,NormalWeaponSetting(player, 13,"현상금 사냥","현상금에 미친 어느 한 사냥꾼의 금으로 만든 단검.",3,1,10,2,"[ 역수 단검 기본 공격 ]","기본 공격 피해량 : 0"));
            Select.setItem(7 ,NormalWeaponSetting(player, 14,"파도 속 고요함","시끄러이 울려 퍼질 파도 속의 고요함. 베인 자도 고요해질까.",4,0.85,11,2,"[ 역수 단검 기본 공격 ]","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("magician")){
            Select.setItem(3 ,MagicianWeaponSetting(player, 11,"고통의 신음","고통에 몸부림치는 비명소리가 귀에 들려온다.",6,0.6,2,0));
            Select.setItem(6 ,MagicianWeaponSetting(player, 12,"정화의 손길","들고 있으면 소유자가 교화될 정도로 맑은 기운을 가졌다.",4,0.75,2,0));
        }

    }

    public static void Smith(Player player){
        Inventory smith = Bukkit.createInventory(null, 9,"[ 대장간 ]");

        smith.setItem(2, GuiTool(Material.BARRIER,ChatColor.GOLD+ "[ 장비 강화 ]", Arrays.asList(ChatColor.GRAY+"장비를 강화할 수 있습니다.","누르면 장비 강화로 넘어갑니다."), 10000));
        smith.setItem(6, GuiTool(Material.BARRIER,ChatColor.LIGHT_PURPLE+ "[ 무기 기술 ]", Arrays.asList(ChatColor.GRAY+"무기에 기술을 장착하거나 해제할 수 있습니다.","누르면 무기 기술로 넘어갑니다."), 10000));

        player.openInventory(smith);

    }

    public static void Upgrade(Player player){
        Inventory upgrade = Bukkit.createInventory(null, 9,"[ 장비 강화 ]");

        upgrade.setItem(0,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
        upgrade.setItem(2,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));

        upgrade.setItem(3,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 재료를 놓아주세요."),10000));
        upgrade.setItem(6,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 재료를 놓아주세요."),10000));

        upgrade.setItem(7,GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+"[ 강화 ]",Arrays.asList(ChatColor.GRAY+"누르면 장비 강화를 시도합니다.","필요 킨 광물 : 0","필요 에르 광물 : 0"),10000));
        upgrade.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));

        player.openInventory(upgrade);

    }

    public static void Skill(Player player){
        Inventory skill = Bukkit.createInventory(null, 18,"[ 무기 기술 ]");

        if (player.getScoreboardTags().equals("magician")){
            skill.setItem(3,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
            skill.setItem(5,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
            skill.setItem(9,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(11,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(13,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(15,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(17,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));
            skill.setItem(0, GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+ "[ 등록 및 제거 ]", Arrays.asList(ChatColor.GRAY+"기술을 등록 또는 제거합니다."), 10000));
        }
        else {
            skill.setItem(3,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
            skill.setItem(5,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 장비를 놓아주세요."),10000));
            skill.setItem(9,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(10,GuiTool(Material.BARRIER,ChatColor.RED+"X",Arrays.asList("마법사 계열이 아니라면 제거가 불가능합니다."),10000));
            skill.setItem(11,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(13,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(15,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←→",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(17,GuiTool(Material.GRAY_STAINED_GLASS_PANE,ChatColor.GRAY+"←",Arrays.asList("이 옆에 기술 또는 제거제를 놓아주세요."),10000));
            skill.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));
            skill.setItem(0, GuiTool(Material.GREEN_STAINED_GLASS_PANE,ChatColor.GREEN+ "[ 등록 및 제거 ]", Arrays.asList(ChatColor.GRAY+"기술을 등록 또는 제거합니다."), 10000));
        }

        player.openInventory(skill);

    }

    public static void Shop(Player player){
        Inventory shop = Bukkit.createInventory(null, 9,"[ 상점 ]");

        shop.setItem(8, GuiTool(Material.BARRIER,ChatColor.RED+ "[ 뒤로 가기 ]", Arrays.asList(ChatColor.GRAY+"해당 작업을 벗어납니다.","누르면 대장간으로 돌아갑니다."), 10000));

        player.openInventory(shop);

    }

}
