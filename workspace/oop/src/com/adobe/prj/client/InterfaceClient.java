package com.adobe.prj.client;

import com.adobe.prj.util.Computation;

public class InterfaceClient {
    public static void main(String[] args) {
        // Anonymous class
        Computation add = new Computation() {
            @Override
            public int compute(int firstArg, int secondArg) {
                return firstArg + secondArg;
            }

        };
        System.out.println(add.compute(4,5));

        // lambda Expression
        Computation subtract = (int firstArg, int secondArg) -> {
            return firstArg - secondArg;
        };

        System.out.println(subtract.compute(55,1));
        // lambda type inference
        Computation divide = (firstArg, secondArg) -> firstArg * secondArg;
        System.out.println(divide.compute(5, 2));

    }
}
