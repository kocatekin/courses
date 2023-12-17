import java.util.*;
public class Main {


    static HashMap<Integer, Integer> cache;
    public static void main(String[] args) {
        //System.out.print("hello world");
        cache = new HashMap<>();
        System.out.println(square(5));
        System.out.println(square(4));
        System.out.println(square(5));
        
    }

    public static int square(int num){
        if(!cache.containsKey(num)) {
            System.out.println("writing to cache");
            cache.put(num, num*num);
            
        }
        return cache.get(num);
    }
}
