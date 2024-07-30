package com.adobe.prj.util;

public interface Computation <T extends Number> {
    T compute(T firstArg, T secondArg);
}
