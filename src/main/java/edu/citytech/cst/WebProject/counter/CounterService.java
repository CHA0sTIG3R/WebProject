package edu.citytech.cst.WebProject.counter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@Service
public class CounterService {

    Function<Integer, Counter> fAbc = e -> new Counter((char)e.intValue()+"", e);
    Function<Integer, Counter> f123 = e -> new Counter(e+"", e);
    Function<Counter, Counter> fEven = e -> {
       String evenStatus = e.getValue().intValue() % 2 == 0? "isEven" : "";
       e.setClassName("numbers "+evenStatus);
       return e;
    };
    public List<Counter> count(CounterEnumerator eCounter, int... range){

        int default_range [] = {65,90, 1};

        Function<Integer, Counter> func = f123;
        Predicate<Integer> filter = e -> true;

        if (eCounter == CounterEnumerator.ABC || eCounter == CounterEnumerator.CBA){
            func = fAbc;
        }
        else {

            if (range.length > 1) {
                default_range[0] = range[0];
                default_range[1] = range[1];
                filter = e -> e <= default_range[1];
            }
            if (range.length > 2) {
                default_range[2] = range[2];
            }
        }

        var list = IntStream.rangeClosed(default_range[0], default_range[1])
                .mapToObj(e -> e * default_range[2])
                .filter(filter)
                .map(func)
                .map(fEven)
                .toList();

        if (eCounter == CounterEnumerator.N321 || eCounter == CounterEnumerator.CBA){
            List<Counter> modifiableList = new ArrayList<>(list);
            Collections.reverse(modifiableList);
            return modifiableList;
        }

        return list;
    }

    public static void main(String[] args) {

        System.out.println("Hamza, Olowu " + new Date());

        CounterService s = new CounterService();
        s.count(CounterEnumerator.N321, 1,20,4)
                .forEach(System.out::println);

        s.count(CounterEnumerator.CBA).stream()
                .map(Counter::getDisplayValue)
                .forEach(System.out::print);

    }
}
