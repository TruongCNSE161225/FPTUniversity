
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCar implements Icar{
//fl: Return the whole part of average rate of all cars (e.g. the whole part of 3.7 is 3).//
    @Override
    public int f1(List<Car> t) {
        double sum = 0;
        int carCount = t.size();
        for (int i = 0; i < carCount; i++) {
            sum += t.get(i).getRate();
        }
        return (int) sum / carCount;
    }
//f2 Find the first max and min rates in the list and swap their positions.//
    @Override
    public void f2(List<Car> t) {
        // tìm vị trí thằng nhỏ nhất đầu tiên
        int indexMin = getIndexMinRate(t);
        // tìm vị trí thằng lớn nhất đầu tiên
        int indexMax = getIndexMaxRate(t);
        // đổi chỗ 2 thằng cho nhau
        Car carTemp = t.get(indexMin);
        t.set(indexMin, t.get(indexMax));
        t.set(indexMax, carTemp);
    }
//f3 Sort the list by maker alphabetically, in case makers are the same, sort them descendingly by rate.//
    //  7 9 8 5 
    @Override
    public void f3(List<Car> t) {
        Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car t, Car t1) {
                int alphabe = t.getMaker().compareTo(t1.getMaker());

                if (alphabe == 0) {
                    if (t.getRate() > t1.getRate()) {
                        return -1;
                    } else if (t.getRate() == t1.getRate()) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return alphabe;
                }
            }
        };
        Collections.sort(t, comparator);
    }
//f2 continued//
    private int getIndexMinRate(List<Car> t) {
        int valueMin = t.get(0).getRate();
        int indexMin = 0;
        for (int i = 1; i < t.size(); i++) {
            if (t.get(i).getRate() < valueMin) {
                valueMin = t.get(i).getRate();
                indexMin = i;
            }
        }
        return indexMin;
    }

    private int getIndexMaxRate(List<Car> t) {
        int valueMax = t.get(0).getRate();
        int indexMax = 0;
        for (int i = 1; i < t.size(); i++) {
            if (t.get(i).getRate() > valueMax) {
                valueMax = t.get(i).getRate();
                indexMax = i;
            }
        }
        return indexMax;
    }

}


