import java.util.Scanner;

public class Java {
//    public static void main(String[] args) {
////        String str = "google";
////      int num = FirstNotRepeatingChar(str);
////      System.out.println(num);
//
//    }
//    public static int FirstNotRepeatingChar(String str) {
//        for(int i = 0; i < str.length()-1; i++){
//            for (int j = i + 1; j < str.length(); j++) {
//                if(str.charAt(i) != str.charAt(j)){
//                    if(j == str.length() -1){
//                        return i+1;
//                    }
//                }else{
//                    break;
//                }
//            }
//        }
//        return -1;
//    }
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
//    while (in.hasNext()) {
//        String str1 = in.nextLine();
//        String str2 = in.nextLine();
//        int count = paint(str1,str2);
//        System.out.println(count);
//    }
while(in.hasNext()){
    int num = in.nextInt();
    String str = in.nextLine();
    cycle(num,str);
}
}
    public static int  paint(String str1,String str2){
            char[] ret = str2.toCharArray();
            int count = 0;
            for (int i = 0; i <str1.length() ; i++) {
                for (int j = 0; j < ret.length; j++) {
                    if(str1.charAt(i) == ret[j]){
                        ret[j] = '0';
                        count++;
                        break;
                    }
                }
            }
            return count;
    }

        public static void cycle(int num,String str){
         if(num == 1){
            System.out.println("Yes");
             return;
         }
         int[] ret = new int[num];
            for (int i = 0; i < num*3 -3 ; i+=3) {
                for (int j = i + 3; j < num*3 ; j+=3) {
                    String str1 = null;
                    str1 = str.substring(i,i + 3);
                    String str2 = null;
                    str2 = str.substring(j,j + 3);
                    int k = 0;
                     ret[k] = paint(str1,str2);
                     k++;
                }

            }
            for (int i = 0; i < ret.length; i++) {
                if(ret[i] < 2){
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
}

}
