import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
//        Collection<String> collection = new ArrayList<>();
//        System.out.println(collection.size());
//
//        System.out.println(collection.isEmpty());
//
//        Map<String , String> map = new HashMap<>();
//        map.put("1","南南");
//        map.put("3","嘉嘉");
//        map.put("2","洛洛");
//        System.out.println(map.isEmpty());
//        System.out.println(map.size());
//        System.out.println(map.get("1"));
//        System.out.println(map.getOrDefault("4","光光"));
//        map.remove("2");
//        for(Map.Entry<String , String> entry : map.entrySet()){
//            System.out.println(entry.getKey() +" : "+ entry.getValue());
//        }

    }

    //杨辉三角
    //输入numRows 输出杨辉三角前unmRows行
    public List<List<Integer>> generate(int numRows){
        //第一行固定一个1 第二行固定两个1
        //第i行首尾都是1
        //第i行有i个元素
        //对于第i行，第j列的值是i-1行的j-1列的值加上j列的值

        if(numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }
        //第i行有i列
        //第j列的值是i-1行的j-1列的值加上j列的值
        //(i,j) = (i-1,j-1) + (i-1,j)
        //第i行首尾都是1
        //行数从1开始的转换成下标要减1
        for(int row = 3;row <= numRows;row++){
            List<Integer> prevLine = result.get(numRows - 2);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for(int col = 2; col < row; col++){
                int curNum = prevLine.get(col-1) + prevLine.get(col-2);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
