package com.flickerflics.interfaces;

/**
 * @Author rahulravindran
 */
public interface MapperBaseType<IN, OUT> {
    OUT to(final IN value);

    IN from(final OUT value);
}
