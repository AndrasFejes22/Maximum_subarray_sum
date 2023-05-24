import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(3L);
        list.add(3L);
        list.add(9L);
        list.add(9L);
        list.add(5L);
        //System.out.println("ArrayList : " + list.toString());

        int sum = list.stream().mapToInt(Long::intValue).sum();
        int max = list.stream().mapToInt(Long::intValue).max().orElseThrow();

        //System.out.println("max(list): "+sum(list));
        System.out.println("divideBySub: " );
        //divideBySub(7,6);
        System.out.println(21%7);
        System.out.println(divideBySub(21,7));
        System.out.println("---------------------------");

        //System.out.println("sum : " + sum);
        //System.out.println("max : " + max);
        //System.out.println("subLists : " + subLists(list, 7));
        List<Long> list2 = new ArrayList<Long>();
        list2.add(1L);
        list2.add(5L);
        list2.add(9L);
        System.out.println("subLists : " + subLists(list, 7));

    }

    public static long subLists(List<Long> inputList, long m){
        List<List<Long>> partitions = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i+1; j <=inputList.size(); j++) {
                partitions.add(inputList.subList(i,j));
            }
        }

        long max = 0;
        for (int i = 0; i < partitions.size(); i++) {

            /*
            if((sum(partitions.get(i)) % m) > max){
                max =(sum(partitions.get(i))) % m;
            }
            */
            long temp = divideBySub((sum(partitions.get(i))), m);
            if(temp > max){
                max = temp;
            }
        }

        return max;
    }

    public static long sum(List<Long> integerList){
        long sumValue = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sumValue += integerList.get(i);
        }
        return sumValue;
    }

    public static long divideBySub(long a, long b){
        //int count=0;
        while(a>=b){
            a-=b;
            //++count;
        }

        //System.out.println("remainder: "+a); // remainder
        //System.out.println("quotient: "+count);//quotient

        return a;

    }
}
