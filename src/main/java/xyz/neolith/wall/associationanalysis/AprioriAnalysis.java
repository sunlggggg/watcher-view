package xyz.neolith.wall.associationanalysis;

import java.util.*;

/**
 * Apriori算法实现 最大模式挖掘，涉及到支持度，但没有置信度计算
 * <p>
 * AssociationRulesMining()函数实现置信度计算和关联规则挖掘
 */
public class AprioriAnalysis {

    private static int times = 0;//迭代次数
    private static double MIN_SUPPROT = 0.02;//最小支持度百分比
    private static double MIN_CONFIDENCE = 0.6;//最小置信度
    private static boolean endTag = false;//循环状态，迭代标识
    private static List<List<String>> record = new ArrayList<>();//数据集
    private static List<List<String>> frequentItemSet = new ArrayList<>();//存储所有的频繁项集
    private static List<AprioriSet> map = new ArrayList<>();//存放频繁项集和对应的支持度技术

    public AprioriAnalysis() {
    }


    public void analysis(IRecordReader recordReader) {
        System.out.println("请输入最小支持度（如0.05）和最小置信度（如0.6）");
        Scanner in = new Scanner(System.in);
        MIN_SUPPROT = in.nextDouble();
        MIN_CONFIDENCE = in.nextDouble();
        System.out.println("开始读取记录");
        //读取记录
        record = recordReader.read();
        System.out.println("读取记录完毕");
        ShowData(record);
        Apriori();//调用Apriori算法获得频繁项集
        System.out.println("频繁模式挖掘完毕");
        System.out.println("进行关联度挖掘");
        System.out.println("最小支持度百分比为：" + MIN_SUPPROT);
        System.out.println(" 最小置信度为：" + MIN_CONFIDENCE);
        //挖掘关联规则
        AssociationRulesMining();

    }

    //apriori算法入口
    private static void Apriori() {
        //获取候选1项集
        System.out.println("第一次扫描后的1级 备选集CandidateItemSet");
        List<List<String>> CandidateItemSet = findFirstCandidate();
        ShowData(CandidateItemSet);
        //获取频繁1项集
        System.out.println("第一次扫描后的1级 频繁集FrequentItemSet");
        List<List<String>> FrequentItemSet = getSupprotedItemSet(CandidateItemSet);
        AddToFrequentItem(FrequentItemSet);//添加到所有的频繁项集中
        //控制台输出1项频繁集
        ShowData(FrequentItemSet);


        //迭代过程
        times = 2;
        while (!endTag) {

            System.out.println("第" + times + "次扫描后备选集");
            //连接操作 获取候选times项集
            List<List<String>> nextCandidateItemSet = getNextCandidate(FrequentItemSet);
            //输出所有的候选项集
            ShowData(nextCandidateItemSet);

            //计数操作  由候选k项集选择出频繁k项集
            System.out.println("第" + times + "次扫描后频繁集");
            List<List<String>> nextFrequentItemSet = getSupprotedItemSet(nextCandidateItemSet);
            AddToFrequentItem(nextFrequentItemSet);//添加到所有的频繁项集中
            //输出所有的频繁项集
            ShowData(nextFrequentItemSet);


            //如果循环结束，输出最大模式
            if (endTag) {
                System.out.println("\n\n\nApriori算法--->最大频繁集");
                ShowData(FrequentItemSet);
            }
            //下一次循环初值
            FrequentItemSet = nextFrequentItemSet;
            times++;//迭代次数加一
        }
    }

    //关联规则挖掘
    private static void AssociationRulesMining() {
        for (List<String> tem : frequentItemSet) {
            if (tem.size() > 1) {
                List<String> temClone = new ArrayList<>(tem);
                List<List<String>> AllSubset = getSubSet(temClone);//得到频繁项集tem的所有子集
                for (List<String> s1 : AllSubset) {
                    List<String> s2 = gets2set(tem, s1);
                    double conf = isAssociationRules(s1, s2, tem);
                    if (conf > 0)
                        System.out.println("置信度为：" + conf);
                }
            }

        }
    }


    //判断是否为关联规则
    private static double isAssociationRules(List<String> s1, List<String> s2, List<String> tem) {
        double confidence;
        int counts1;
        int countTem;
        if (s1.size() != 0 && tem.size() != 0) {
            counts1 = getCount(s1);
            countTem = getCount(tem);
            confidence = countTem * 1.0 / counts1;

            if (MIN_CONFIDENCE <= confidence) {
                System.out.print("关联规则：" + s1.toString() + "=>>" + s2.toString() + "   ");
                return confidence;
            } else
                return 0;

        } else
            return 0;

    }

    //根据频繁项集得到其支持度计数
    private static int getCount(List<String> in) {
        int rt = 0;
        for (AprioriSet tem : map) {
            if (tem.isListEqual(in)) {
                rt = tem.getCount();
                return rt;
            }
        }
        return rt;

    }

    //计算tem减去s1后的集合即为s2
    private static List<String> gets2set(List<String> tem, List<String> s1) {
        List<String> result = new ArrayList<>();

        for (String t : tem) {
            if (!s1.contains(t))
                result.add(t);
        }
        return result;
    }


    private static List<List<String>> getSubSet(List<String> set) {
        List<List<String>> result = new ArrayList<>(); //用来存放子集的集合，如{{},{1},{2},{1,2}}
        int length = set.size();
        int num = length == 0 ? 0 : 1 << (length); //2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.

        //从0到2^n-1（[00...00]到[11...11]）
        for (int i = 1; i < num - 1; i++) {
            List<String> subSet = new ArrayList<>();

            int index = i;
            for (String aSet : set) {
                if ((index & 1) == 1) {     //每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
                    subSet.add(aSet);
                }
                index >>= 1;      //右移一位
            }

            result.add(subSet);       //把子集存储起来
        }
        return result;
    }


    private static void AddToFrequentItem(List<List<String>> fre) {
        frequentItemSet.addAll(fre);
    }

    //显示出candidateitem中的所有的项集
    private static void ShowData(List<List<String>> CandidateItemSet) {
        for (List<String> aCandidateItemSet : CandidateItemSet) {
            List<String> list = new ArrayList<>(aCandidateItemSet);
            for (String aList : list) {
                System.out.print(aList + " ");
            }
            System.out.println();
        }
    }


    /**
     * 有当前频繁项集自连接求下一次候选集
     */
    @SuppressWarnings("unchecked")
    private static List<List<String>> getNextCandidate(List<List<String>> FrequentItemset) {
        List<List<String>> nextCandidateItemSet = new ArrayList<>();

        for (int i = 0; i < FrequentItemset.size(); i++) {
            HashSet<String> hsSetTemp;
            //获得频繁集第i行
            HashSet<String> hsSet = new HashSet<>(FrequentItemset.get(i));
            int hsLength_before = hsSet.size();//添加前长度
            hsSetTemp = (HashSet<String>) hsSet.clone();
            for (int h = i + 1; h < FrequentItemset.size(); h++) {//频繁集第i行与第j行(j>i)连接   每次添加且添加一个元素组成    新的频繁项集的某一行，
                hsSet = (HashSet<String>) hsSetTemp.clone();//！！！做连接的hasSet保持不变
                hsSet.addAll(FrequentItemset.get(h));
                int hsLength_after = hsSet.size();
                if (hsLength_before + 1 == hsLength_after && isNotHave(hsSet, nextCandidateItemSet)) {
                    //如果不相等，表示添加了1个新的元素       同时判断其不是候选集中已经存在的一项
                    Iterator<String> itr = hsSet.iterator();
                    List<String> tempList = new ArrayList<>();
                    while (itr.hasNext()) {
                        String Item = itr.next();
                        tempList.add(Item);
                    }
                    nextCandidateItemSet.add(tempList);
                }

            }

        }
        return nextCandidateItemSet;
    }


    /**
     * 判断新添加元素形成的候选集是否在新的候选集中
     */
    private static boolean isNotHave(HashSet<String> hsSet, List<List<String>> nextCandidateItemset) {//判断hsset是不是candidateitemset中的一项
        List<String> tempList = new ArrayList<>(hsSet);
        for (List<String> aNextCandidateItemSet : nextCandidateItemset)
            if (tempList.equals(aNextCandidateItemSet))
                return false;
        return true;
    }

    /**
     * 由k项候选集剪枝得到k项频繁集
     */
    private static List<List<String>> getSupprotedItemSet(List<List<String>> CandidateItemSet) { //对所有的商品进行支持度计数
        boolean end = true;
        List<List<String>> supportedItemSet = new ArrayList<>();

        for (List<String> aCandidateItemSet : CandidateItemSet) {

            int count = countFrequent1(aCandidateItemSet);//统计记录数

            if (count >= MIN_SUPPROT * (record.size() - 1)) {
                supportedItemSet.add(aCandidateItemSet);
                map.add(new AprioriSet(aCandidateItemSet, count));//存储当前频繁项集以及它的支持度计数
                end = false;
            }
        }
        endTag = end;//存在频繁项集则不会结束
        if (endTag)
            System.out.println("无满足支持度的" + times + "项集,结束连接");
        return supportedItemSet;
    }


    /**
     * 统计record中出现list集合的个数
     */
    private static int countFrequent1(List<String> list) {//遍历所有数据集record，对单个候选集进行支持度计数

        int count = 0;
        for (List<String> aRecord : record) {
            boolean flag = true;
            for (String t : list) {
                if (!aRecord.contains(t)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;//支持数加一
        }
        return count;//返回支持度计数
    }

    //获得一项候选集
    private static List<List<String>> findFirstCandidate() {
        List<List<String>> tableList = new ArrayList<>();
        //新建一个hash表，存放所有的不同的一维数据
        HashSet<String> hs = new HashSet<>();
        //遍历所有的数据集，找出所有的不同的商品存放到hs中
        for (int i = 1; i < record.size(); i++) {
            for (int j = 1; j < record.get(i).size(); j++) {
                hs.add(record.get(i).get(j));
            }
        }
        for (String h : hs) {
            List<String> tempList = new ArrayList<>();
            tempList.add(h);   //将每一种商品存放到一个List<String>中
            tableList.add(tempList);//所有的list<String>存放到一个大的list中
        }
        //返回所有的商品
        return tableList;
    }
}


/**
 * 一个对象存放一个频繁项集以及其支持度计数
 */
class AprioriSet {
    private List<String> li;
    private int count;//支持数，可用于计算支持度

    AprioriSet(List<String> l, int c) {
        li = l;
        count = c;
    }

    //返回得到当前频繁项集的支持度计数
    public int getCount() {
        return count;
    }

    //判断传入的频繁项集是否和本频繁项集相同
    public boolean isListEqual(List<String> in) {
        //先判断大小是否相同
        if (in.size() != li.size()) {
            return false;
        } else {
            for (String anIn : in) {
                if (!li.contains(anIn))
                    return false;
            }
        }
        return true;
    }
}