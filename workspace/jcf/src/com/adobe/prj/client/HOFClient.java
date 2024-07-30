package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class HOFClient {
    // HOF --> OCP
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
            for(T item : list) {
                if(predicate.test(item)) {
                    result.add(item);
                }
            }
        return result;
    }

    //HOF to transform

    private  static <T,R> List<R> map(List<T> list, Function<T,R> transform) {
        List<R> output = new ArrayList<>();
        for(T item : list) {
            output.add(transform.apply(item));
        }
        return output;
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,6,2,1,9,3,11,17);
        List<Integer> evens = filter(numbers, no -> no % 2 ==0);
        System.out.println(evens);

        List<Integer> doubles = map(numbers, no -> no * 2);
        System.out.println(doubles);

        List<Product> products = new ArrayList<>();
        products.add(new Product(34, "iPhone 15", 89_000.00, "mobile"));
        products.add(new Product(45, "Onida Thunder", 4000.00, "tv"));
        products.add(new Product(561, "Sony Bravia", 2_45_000.00, "tv"));
        products.add(new Product(12, "Nokia", 4500.00, "mobile"));
        products.add(new Product(89, "Wacom", 5200.00, "computer"));

        List<Product> mobiles = filter(products, p -> p.getCategory().equals("mobile"));

        for(Product p : mobiles) {
            System.out.println(p);
        }

        List<String> names = map(products, p -> p.getName());
        System.out.println(names);

        List<Double> prices = map(products, p -> p.getPrice());
        System.out.println(prices);
    }
}
