public class JumpFloor {

    public int JumpFloor1 (int num){
        if(num <= 0){
            return 0;
        }
        int ret = 1;
        for (int i = 2; i <= num; i++) {
            ret *= 2;
        }
        return ret;
    }

    public int JumpFloor2 (int num){
        return num <= 0 ? 0 : 1 << (num - 1);
    }
}
