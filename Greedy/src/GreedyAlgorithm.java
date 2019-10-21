import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 *
 * 每次选择最优解,但得到的结果不一定是最优的结果,但都是相对近似的最优
 *
 * 使用贪婪算法可以得到非常接近的解,并且效率高,选择策略上,因为要覆盖全部地区的最小集合:
 * 1.遍历所有的广播电台,找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区,但没有关系)
 * 2.将这个电台加入到一个集合中(比如ArrayList),想办法把该电台覆盖的地区在下次比较时去掉
 * 3.重复第1步直到覆盖了全部地区
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts中
        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5=new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        //allAreas放所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList,存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合,存放在遍历过程中allAreas和k1的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义给maxKey,保存在一次遍历过程中,能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey不为null,则会加入到selects
        String maxKey=null;
        while(allAreas.size()!=0){ //如果allAreas不为0,则表示还没有覆盖到所有的地区
            //每进行一次while,都要把maxKey置空
            maxKey=null;
            //遍历broadcasts,取出对应的key
            for(String key:broadcasts.keySet()){
                //每进行一次for
                tempSet.clear();
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集,赋给tempSet
                tempSet.retainAll(allAreas);

                //如果当前这个集合包含的未覆盖地区的数量比maxKey指向的集合地区还多,就需要重置maxKey
                //这步提现出贪婪算法的特点,每次选择最优
                if(tempSet.size()>0 &&
                        (maxKey == null || tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey=key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区,从allArea去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }

        System.out.println("得到的选择结果是"+selects);
    }
}
