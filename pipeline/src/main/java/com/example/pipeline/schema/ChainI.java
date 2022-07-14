package com.example.pipeline.schema;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
public interface ChainI<I, C, O> {
    void executor(I input, C context, O output);
}
