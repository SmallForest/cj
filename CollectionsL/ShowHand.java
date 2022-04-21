package CollectionsL;


import java.util.*;

public class ShowHand {
    //玩家数量
    private final int PLAY_NUM = 5;
    //定义扑克牌的所有花色和值
    private String[] types = {"方块", "梅花", "红桃", "黑桃"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    //cards是一局游戏中剩下的扑克牌
    private List<String> cards = new LinkedList<>();
    //定义所有玩家
    private String[] players = new String[PLAY_NUM];
    //所有玩家手上的扑克牌？
    private List<String>[] playersCards = new List[PLAY_NUM];

    /**
     * 初始化扑克牌，52张扑克牌（没大小鬼）
     * shuffle进行洗牌
     */
    public void initCards() {
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家，为玩家分配姓名
     */
    public void initPlayer(String... names) {
        if (names.length > PLAY_NUM || names.length < 2) {
            //数量不合适
            System.out.println("玩家数量需要是2-" + PLAY_NUM + "。");
            return;
        } else {
            for (int i = 0; i < names.length; i++) {
                players[i] = names[i];
            }
        }
    }

    /**
     * 初始化玩家手中的扑克牌，开始时玩家手上的扑克牌为空
     * 程序初始化一个长度=0的LinkedList表示
     */
    public void initPlayerCards() {
        for (int i = 0; i < players.length; i++) {
            //用户不为null，名字不是空字符串
            if (players[i] != null && !players[i].equals("")) {
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    //输出全部扑克牌
    public void showAllCards() {
        for (var card : cards) {
            System.out.print(card);
        }
        System.out.println("");
    }

    public int search(String first) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i].equals(first)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 派发扑克牌
     *
     * @param first 最先派发给谁
     */
    public void deliverCard(String first) {
        //调用search
        int firstPos = search(first);
        if (firstPos < 0) {
            System.out.println("未寻找到：" + first+"，结束发牌");
            return;
        }
        //依次给位于该指定位置之后的玩家派发扑克牌
        for (int i = firstPos; i < PLAY_NUM; i++) {
            if (players[i] != null) {
                //TODO 此处，可以利用 pollFirst()优化
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
        //给位于指定玩家之前的玩家派发扑克牌
        for (int i = 0; i < firstPos; i++) {
            if (players[i] != null) {
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
    }

    /**
     * 输出玩家手上的扑克牌
     */
    public void showPlayerCards() {
        for (int i = 0; i < PLAY_NUM; i++) {
            //当 玩家不为null
            if (players[i] != null) {
                //输出玩家
                System.out.print(players[i] + ": ");
                //遍历输出
                for (var card : playersCards[i]) {
                    System.out.print(card + "\t");
                }
                System.out.print("\n");
            }

        }
    }

    public static void main(String[] args) {
        var sh = new ShowHand();
        sh.initPlayer("电脑玩家", "smallForest");
        sh.initCards();
        sh.initPlayerCards();
        //测试
        sh.showAllCards();
        System.out.println("--------测试结束，正式开始--------");
        sh.deliverCard("smallForest");
        sh.showPlayerCards();
        //从电脑开始派发扑克牌
        sh.deliverCard("电脑玩家");
        sh.showPlayerCards();
    }
}
