
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String str = in.next();
       int k = in.nextInt();
        if(str.length() != 8 || k > 7){
            System.out.println("error");
            return;
        }
            String out = str.substring(0, k) + str.substring(k + 1);
            System.out.println(out);
    }
}
