package com.adobe.prj.client;

import com.adobe.prj.util.Computation;

public class InterfaceClient {
    public static void main(String[] args) {
        // Anonymous class
        Computation<Integer> add = new Computation<Integer>() {
            @Override
            public Integer compute(Integer firstArg, Integer secondArg) {
                return firstArg.intValue() + secondArg.intValue();
            }
        };

        System.out.println(add.compute(4,5));

        // lambda Expression
        Computation<Double> subtract = (Double firstArg, Double secondArg) -> {
            return firstArg - secondArg;
        };

        System.out.println(subtract.compute(55.5,1.11));
        // lambda type inference
        Computation<Long> divide = (firstArg, secondArg) -> firstArg * secondArg;
        System.out.println(divide.compute(5l, 2l));

    }
}
