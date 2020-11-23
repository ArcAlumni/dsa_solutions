import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public void pascalsTriangle() {
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(1, 1));
        
        for(int i=2;i<10;i++){
            List<Integer> prev = list.get(i - 1);
            List<Integer> li = new ArrayList<>();
            li.add(1);
            for(int j=0;j<prev.size()-1;j++){
                li.add(prev.get(j) + prev.get(j + 1));
            }
            li.add(1);
            list.add(li);
        }
        
        System.out.println(list);
        
    }
    
}
