import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(3L);
        list.add(3L);
        list.add(9L);
        list.add(9L);
        list.add(5L);
        System.out.println("ArrayList : " + list.toString());

        int sum = list.stream().mapToInt(Long::intValue).sum();
        int max = list.stream().mapToInt(Long::intValue).max().orElseThrow();

        System.out.println("sum : " + sum);
        System.out.println("max : " + max);
        //System.out.println("subLists : " + subLists(list, 7));
        List<Long> list2 = new ArrayList<Long>();
        list2.add(1L);
        list2.add(5L);
        list2.add(9L);
        System.out.println("subLists : " + subLists(list2, 5));

    }

    public static long subLists(List<Long> inputList, long m){
        List<List<Long>> partitions = new ArrayList<>();
        List<Long> sumList = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            List<Long> list = new ArrayList<>(inputList);
            for (int j = i+1; j <=inputList.size(); j++) {
                partitions.add(list.subList(i,j));
            }
        }
        for (int i = 0; i < partitions.size(); i++) {
            //long sum = partitions.get(i).stream().mapToLong(Long::longValue).sum();
            long temp = (partitions.get(i).stream().mapToLong(Long::longValue).sum()) % m;
            sumList.add(temp);
            //System.out.println("sum "+sum);
            //
            //System.out.println("sum%m: "+sum%m);
        }
        long max = Collections.max(sumList);
        System.out.println("partitions: " + partitions);
        System.out.println("max: " + max);
        System.out.println("inputList : " + inputList);
        return max;
    }
}
