import java.lang.reflect.Field;

public class myString {

    public static void main(String[] args) {
        String str = "hehe";
        for (int i = 0; i <str.length() ; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        //字符串转换成字符数组
        char[] ret = str.toCharArray();
        for (int i = 0; i <ret.length ; i++) {
            System.out.print(ret[i]);
        }
        System.out.println();
        //字符数组转换成字符串
        char[] array = {'a','b','c'};
        String data = new String(array);
        System.out.println(data);

        System.out.println(isNumber("1234"));
        System.out.println(isNumber("abcd"));

        //字符串转字节
        byte[] bytes = str.getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.print(bytes[i]);
        }
        System.out.println();

        //比较大小
        String str1 = "haha";
        String str2 = "HAHA";
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        //判断字符串子串

        String str3 = "hello wordwo";
        String str4 = "wol";
        System.out.println(str3.contains(str4));
        //字串位置 如果是子串返回结果是子字符串中第一次出现的下标 如果不是返回-1
        //例如实现文本查找
        System.out.println(str3.indexOf(str4));
        //是字串返回最后一次出现的下标
        System.out.println(str3.lastIndexOf(str4));

        System.out.println(str3.startsWith("he"));
        System.out.println(str3.endsWith("wo"));

        //替换没有修改原字符串 生成了新的字符串（String是不可变的）
        System.out.println(str3.replaceAll("o","0"));

       // 字符串切分
        //java中不会合并分隔符
        String myStr = "192.168.1.0";
        //| + * 也需要转义
        String[] result = myStr.split("//.");
        for (String x : result
             ) {
            System.out.print(x);
        }
        System.out.println();

        //大小写转换
        System.out.println(str1.toUpperCase());
        System.out.println(str1.toLowerCase());

        String result1 = str1.substring(0,1).toUpperCase()+str1.substring(1).toLowerCase();
        System.out.println(result1);
        //StringBuilderS是可变对象
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("xx");
        stringBuilder.append("ss");
        stringBuilder.append("s").append("s").append("s");
        System.out.println(stringBuilder);
        //逆置
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        //插入
        stringBuilder.insert(1,"hhh");
        System.out.println(stringBuilder);
        //删除
        stringBuilder.delete(1,2);
        System.out.println(stringBuilder);
    }
    //判断字符串是否是数字
    public static boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if(a <'0' || a >'9'){
                return false;
            }
        }
        return true;
    }
}
