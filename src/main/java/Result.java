import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {


    public static void subLists(List<Long> a){
        List<Long> list = new ArrayList<>();
        Set<List<Long>> set = new HashSet<List<Long>>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < i; j++) {
                list.add(a.get(i));
            }
            set.add(list);
        }
    }
}
