package lesson8.generics.domain;

import java.util.Comparator;
import java.util.List;

public class JewBox<T extends Jewelry> {
    private List<Jewelry> boxOfJew;

    public JewBox() {
    }

    public List<Jewelry> getBoxOfJew() {
        return boxOfJew;
    }

    public void setBoxOfJew(List<Jewelry> boxOfJew) {
        this.boxOfJew = boxOfJew;
    }

    public void boxSort(List<? extends Jewelry> boxOfJew){
        boxOfJew.sort(new Comparator1());
    }


    public class Comparator1 implements Comparator<Jewelry>{
        @Override
        public int compare(Jewelry o1, Jewelry o2) {
            String str1 = o1.getArticle();
            String str2 = o2.getArticle();
            int result = str1.compareToIgnoreCase(str2);
            if (result < 0){
                return 1;
            }else if (result > 0 ){
                return -1;
            }
            return 0;
        }
    }
}
