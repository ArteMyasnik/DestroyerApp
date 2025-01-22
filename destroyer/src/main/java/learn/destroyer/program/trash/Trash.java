package learn.destroyer.program.trash;

import learn.destroyer.program.interfaces.functionals.MyFunc;
import learn.destroyer.program.item.Item;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Trash {
    MyFunc sum = Integer::sum;
    MyFunc sub = (a, b) -> a - b;

    Function<Integer, Integer> squareNumber = num -> num * num;

    Predicate<String> isInteger = number -> {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    BiFunction<Integer, Integer, Integer> remainderOfDivision = (num1, num2) -> num1 % num2;

    private void trashMethods() {
        System.out.println(sum.apply(5, 3));
        System.out.println(sub.apply(5, 3));
        System.out.println(squareNumber.apply(12));
        System.out.println(isInteger.test("123"));
        System.out.println(remainderOfDivision.apply(12,5));
        Supplier<Item> item1 = () -> Item.create("Chair");
        var chair = item1.get();
    }
}
