package 测试.游戏; /**
 * 2020/10/27
 *
 * @author cqmfx(阡陌飞絮)
 */
import java.util.*;
class HeroGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入英雄的名字：");
        String heroName = scanner.next();
        System.out.println("请输入英雄的血量：");
        int heroBoold = scanner.nextInt();
        System.out.println("请输入英雄的攻击力");
        int heroAttack = scanner.nextInt();
        System.out.println("请输入英雄的防御力：");
        int heroDefense = scanner.nextInt();

        String bossName = "魔王";
        int bossBlood = 1000;
        int bossAttack = 50;
        int bossDefense = 30;

        System.out.println("开始战斗！！！");

        for (int i = 1;heroBoold > 0 && bossBlood > 0;i++){
            System.out.println();
            sleep(800);
            System.out.println("第" + i + "回合");
            sleep(800);
            System.out.println();
            System.out.println(heroName + "打了" + bossName + "一下，" + bossName + "受到了" + (heroAttack - bossDefense) + "点伤害，血量剩余" + (heroBoold-(heroAttack - bossDefense)) + "点");
            sleep(800);
            System.out.println();
            System.out.println(bossName + "打了" + heroName + "一下，" + heroName + "受到了" + (bossAttack - heroDefense) + "点伤害，血量剩余" + (bossBlood-(heroAttack - bossDefense)) + "点");
            // 掉血
            heroBoold -= (bossAttack - heroDefense);
            bossBlood -= (heroAttack - bossDefense);
        }

        if (heroBoold <= 0){
            System.out.println();
            System.out.println("真菜！");
            System.out.println();
            System.out.println("你被"+bossName+"打死了！");
        }
        if (bossBlood <= 0){
            System.out.println();
            System.out.println("好强！");
            System.out.println();
            System.out.println(bossName+"被你打死了！");
        }
    }
    
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
