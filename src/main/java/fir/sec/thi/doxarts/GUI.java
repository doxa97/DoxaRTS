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

import static fir.sec.thi.doxarts.Item.*;

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
            Select.setItem(2 ,NormalWeaponSetting(3,"끝 없는 광기","광기에 물든 어느 한 광전사가 사용했던, 이제는 주인 없는 검.",12, 0,0.6,0,3,"대검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(4 ,NormalWeaponSetting(4,"길 잃은 영혼의 인도자","보랗게 빛나는 빛은 길 잃은 영혼들의 안식처일 것이다.",16, 8,0.3,0,6,"대검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(6 ,NormalWeaponSetting(5,"심연의 송곳니","찢어질 듯한 고통이 울부짖는다.",9,5,0.65,0,4,"대검 기본 공격","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("swordsman")){
            Select.setItem(2 ,NormalWeaponSetting(6,"잠식된 어둠","어둠에 굴복한 검.",6,9,0.9,3,2,"직검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(4 ,NormalWeaponSetting(7,"혼돈 속의 찬란함","찬란한 빛은 아직 혼돈에게 저항 중이다.",8,3,0.85,2,3,"직검 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(6 ,NormalWeaponSetting(8,"은하를 담은 도신","운석으로 제작한 은하를 담은 검.",7,7,0.8,5,3,"직검 기본 공격","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("archer")){
            Select.setItem(3 ,NormalWeaponSetting(9,"성스러운 신자의 유품","사용된 적이 없어 제대로 작동할 지 모르지만, 보장된 품질.",7,6,0.4,4,1,"장궁 기본 공격","기본 공격 피해량 : 0"));
            Select.setItem(6 ,NormalWeaponSetting(10,"꿰뚫는 눈","푸르게 빛나는 이 활은 상대를 꿰뚫는데 특화되어있다.",11,4,0.28,6,0,"장궁 기본 공격","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("assassin")){
            Select.setItem(1 ,NormalWeaponSetting(1,"현상금 사냥","현상금에 미친 어느 한 사냥꾼의 금으로 만든 단검.",3,2,1.1,7,2,"[ 단검 기본 공격 ]","기본 공격 피해량 : 0"));
            Select.setItem(3 ,NormalWeaponSetting(2,"파도 속 고요함","시끄러이 울려 퍼질 파도 속의 고요함. 베인 자도 고요해질까.",4,1,0.95,8,2,"[ 단검 기본 공격 ]","기본 공격 피해량 : 0"));
            Select.setItem(5 ,NormalWeaponSetting(13,"현상금 사냥","현상금에 미친 어느 한 사냥꾼의 금으로 만든 단검.",3,2,1,10,2,"[ 역수 단검 기본 공격 ]","기본 공격 피해량 : 0"));
            Select.setItem(7 ,NormalWeaponSetting(14,"파도 속 고요함","시끄러이 울려 퍼질 파도 속의 고요함. 베인 자도 고요해질까.",4,1,0.85,11,2,"[ 역수 단검 기본 공격 ]","기본 공격 피해량 : 0"));
        }
        if (player.getScoreboardTags().contains("magician")){
            Select.setItem(3 ,MagicianWeaponSetting(11,"고통의 신음","고통에 몸부림치는 비명소리가 귀에 들려온다.",6,11,0.6,2,0));
            Select.setItem(6 ,MagicianWeaponSetting(12,"정화의 손길","들고 있으면 소유자가 교화될 정도로 맑은 기운을 가졌다.",4,14,0.75,2,0));
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
        Inventory shop = Bukkit.createInventory(null, 63,"[ 상점 ]");

        shop.setItem(10 ,ShopNormalWeaponSetting(1,"현상금 사냥","현상금에 미친 어느 한 사냥꾼의 금으로 만든 단검.",3,2,1.1,7,2,"[ 단검 기본 공격 ]","기본 공격 피해량 : 0",1));
        shop.setItem(11 ,ShopNormalWeaponSetting(2,"파도 속 고요함","시끄러이 울려 퍼질 파도 속의 고요함. 베인 자도 고요해질까.",4,1,0.95,8,2,"[ 단검 기본 공격 ]","기본 공격 피해량 : 0",1));
        shop.setItem(12 ,ShopNormalWeaponSetting(13,"현상금 사냥","현상금에 미친 어느 한 사냥꾼의 금으로 만든 단검.",3,2,1,10,2,"[ 역수 단검 기본 공격 ]","기본 공격 피해량 : 0",1));
        shop.setItem(13 ,ShopNormalWeaponSetting(14,"파도 속 고요함","시끄러이 울려 퍼질 파도 속의 고요함. 베인 자도 고요해질까.",4,1,0.85,11,2,"[ 역수 단검 기본 공격 ]","기본 공격 피해량 : 0",1));

        shop.setItem(19,ShopAccessorySetting(1,"여행자의 첫걸음","세상 곳곳을 여행했다던 한 여행자의 첫 신발이다."+"\r\n"+"낡고 허름하지만, 그의 기운은 무시할 수 없다.",0,0,10,3,7,1));
        shop.setItem(20,ShopAccessorySetting(1,"순수한 마력의 요동","보랗게 물든 수정이 빛을 발하는 특이한 반지."+"\r\n"+"금방이라도 기운이 뿜어져 나올 것 같다.",5,0,0,12,0,1));
        shop.setItem(21,ShopAccessorySetting(1,"우두머리의 증표","북부 최강 우두머리의 증표이다."+"\r\n"+"사납기로 유명한 북부의 늑대들의 이빨을 꿰어 만든 목걸이이다.",10,7,0,0,3,1));
        shop.setItem(22,ShopAccessorySetting(1,"버려진 신의 신자","예전에는 세상을 평정했지만 지금은 잊혀진 존재의 증표."+"\r\n"+"꺼질 듯 희미하지만, 아직 자신을 증명하는 기운은 믿을 만 하다.",7,3,5,3,3,1));
        shop.setItem(23,ShopAccessorySetting(1,"모략의 증거","가장 현명한 현자의 모략."+"\r\n"+"달달한 말에 금방이라도 속아 이 반지를 끼지 말지어다.",2,6,4,6,4,1));
        shop.setItem(24,ShopAccessorySetting(1,"탐욕의 최후","탐욕의 끝."+"\r\n"+"세상 모든 것을 가졌지만, 세상 모든 것을 잃을 것 같은 기분이 든다.",13,5,0,0,2,1));
        shop.setItem(25,ShopAccessorySetting(1,"악순환의 굴레","붉게 물든 티아라는 악을 응축하여 담고있다."+"\r\n"+"언젠간 이 악몽을 끝낼 존재가 나올까.",0,15,0,0,0,1));
        shop.setItem(28,ShopAccessorySetting(1,"화신의 깃","세상의 가장 추운 지방에서 기리는 화신의 등판."+"\r\n"+"작은 깃 한 털 조차도 주변을 얼린다.",1,3,7,5,12,1));

        shop.setItem(46,ShopItemSetting(Material.DIAMOND,10000,ChatColor.DARK_GRAY+"에르 광물","material",ChatColor.GRAY+"일반적으로 채광하여 사용하는 기본적인 광물이다.",75,17));
        shop.setItem(47,ShopItemSetting(Material.EMERALD,10000,ChatColor.GREEN+"킨 광물","material",ChatColor.GRAY+"희귀하게 발견되어 비싸게 팔리는 광물이다.",180,40));
        shop.setItem(48,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"핏빛 늑대의 송곳니","material",ChatColor.GRAY+"핏빛 늑대의 날카로운 송곳니이다.",0,24));
        shop.setItem(49,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"점토 골렘의 부서진 벽돌","material",ChatColor.GRAY+"부서지긴 했어도 단단한 건축 재료다.",0,30));
        shop.setItem(50,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"하피의 깃털","material",ChatColor.GRAY+"가벼워서 옷으로 자주 쓰이는 하피의 깃털이다.",0,18));
        shop.setItem(51,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"무너진 해골의 흔적","material",ChatColor.GRAY+"마력을 잃어 무너져 내린 해골의 유해다.",0,22));
        shop.setItem(52,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"뜯어진 살점","material",ChatColor.GRAY+"좀비에게서 떨어져 나온 살점이다.",0,11));
        shop.setItem(55,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"거미의 질긴 실","material",ChatColor.GRAY+"거미의 분비액이 굳어 거미줄이 되었다.",0,13));
        shop.setItem(56,ShopItemSetting(Material.IRON_INGOT,10000,ChatColor.GREEN+"응축된 힘의 결정체","material",ChatColor.GRAY+"감히 가늠이 되지 않는 마력이 담긴 정수다.",0,150));

        shop.setItem(4, GuiTool(Material.BOOK, ChatColor.LIGHT_PURPLE+"[ 기술 관련 구매 ]", Arrays.asList(ChatColor.GRAY+"기술 관련 물건을 구매 가능합니다.",ChatColor.GRAY+"누르면 기술 관련 상점으로 이동합니다."),1));

        player.openInventory(shop);

    }

    public static void SkillShop(Player player){
        Inventory shop = Bukkit.createInventory(null, 54,"[ 상점 ]");

        shop.setItem(10, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"올려 베기","skill","물리 계열"+"\r\n"+"돌진 후 대상을 올려 베어 피해를 입히는 기술이다.",700,300));
        shop.setItem(11, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"십자 베기","skill","물리 계열"+"\r\n"+"십자로 전방을 베어 피해를 입히는 기술이다.",700,300));
        shop.setItem(12, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"연격","skill","물리 계열"+"\r\n"+"연속해서 전방을 베어 피해를 입히는 기술이다.",700,300));
        shop.setItem(13, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"참격","skill","물리 + 마법 계열"+"\r\n"+"전방으로 검기를 내보내어 피해를 입히는 기술이다.",700,300));
        shop.setItem(14, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"포효","skill","물리 + 마법 계열"+"\r\n"+"포효를 내질러 상대에게 일시적인 기절을 부여하는 기술이다.",700,300));
        shop.setItem(15, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"일섬","skill","물리 계열"+"\r\n"+"순간적으로 빠르게 이동하여 상대를 베는 기술이다.",700,300));
        shop.setItem(16, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"출혈","skill","물리 계열"+"\r\n"+"사용 시 첫 타에 한하여 상대에게 지속적인 출혈 상태를 입히는 기술이다.",700,300));
        shop.setItem(19, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"목 긋기","skill","물리 + 마법 계열"+"\r\n"+"상대의 목을 그어 침묵 상태로 만드는 기술이다.",700,300));
        shop.setItem(20, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"난도","skill","물리 계열"+"\r\n"+"전방을 난도질 하여 연속적으로 피해를 입히는 기술이다.",700,300));
        shop.setItem(21, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"곡예","skill","물리 계열"+"\r\n"+"잠시 뒤로 후퇴하며 수리검을 날리고, 맞은 대상에게 순간이동 하는 기술이다.",700,300));
        shop.setItem(22, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"후퇴","skill","물리 계열"+"\r\n"+"뒤로 크게 도약하여 전방으로 투사체를 발사하는 기술이다.",700,300));
        shop.setItem(23, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"선풍","skill","마법 계열"+"\r\n"+"전방의 적을 뒤로 날려 보내는 바람을 일으키는 기술이다.",700,300));
        shop.setItem(24, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"관통","skill","물리 계열"+"\r\n"+"궁수만 구매 가능합니다."+"\r\n"+"잠시동안 화살이 적을 관통하는 기술이다.",700,300));
        shop.setItem(25, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"속사","skill","물리 계열"+"\r\n"+"궁수만 구매 가능합니다."+"\r\n"+"잠시동안 화살을 2발을 추가로 발사하는 기술이다.",700,300));
        shop.setItem(28, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"추격","skill","물리 + 마법 계열"+"\r\n"+"궁수만 구매 가능합니다."+"\r\n"+"잠시동안 화살이 상대를 추격한다.",700,300));
        shop.setItem(29, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"고통의 대지","skill","마법 계열"+"\r\n"+"일정 시간동안 지속 피해를 받는 장판을 생성하는 기술이다.",700,300));
        shop.setItem(30, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"속죄","skill","마법 계열"+"\r\n"+"투사체에 맞은 대상을 일시적으로 속박하는 기술이다.",700,300));
        shop.setItem(31, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"검은 손짓","skill","마법 계열"+"\r\n"+"투사체에 맞은 대상을 앞으로 끌고오는 기술이다.",700,300));
        shop.setItem(32, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"순간이동","skill","마법 계열"+"\r\n"+"가까운 거리를 순간이동 하는 기술이다.",700,300));
        shop.setItem(33, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"서릿발","skill","마법 계열"+"\r\n"+"냉기를 발산하여 주변의 적에게 피해를 입히며 잠시 둔화를 거는 기술이다.",700,300));
        shop.setItem(34, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"화염","skill","마법 계열"+"\r\n"+"앞으로 불을 뿜어 시전시간 동안 지속적인 피해를 입히는 기술이다.",700,300));
        shop.setItem(37, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"서리 지대","skill","마법 계열"+"\r\n"+"잠시동안 둔화를 거는 지대를 생성하여 지속적인 피해를 입히는 기술이다.",700,300));
        shop.setItem(38, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"폭발","skill","마법 계열"+"\r\n"+"폭발하는 화염을 던져 맞춘 대상에게 피해를 주는 기술이다.",700,300));
        shop.setItem(39, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"치유","skill","마법 계열"+"\r\n"+"바라본 대상을 대폭 치유하는 기술이다.",700,300));
        shop.setItem(40, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"기도","skill","마법 계열"+"\r\n"+"주변 아군들을 소폭 치유하는 기술이다.",700,300));
        shop.setItem(50, ShopItemSetting(Material.BOOK,1,ChatColor.GRAY+"기술 제거 수정","delete","기술을 제거할 수 있는 수정이다."+"\r\n"+"대장간에서 원하는 기술을 제거할 수 있다.",1000,450));



        shop.setItem(4, GuiTool(Material.BOOK, ChatColor.LIGHT_PURPLE+"[ 재료 및 무기 구매 ]", Arrays.asList(ChatColor.GRAY+"재료 및 무기를 구매 가능합니다.",ChatColor.GRAY+"누르면 재료와 무기 관련 상점으로 이동합니다."),1));

        player.openInventory(shop);

    }

}




























