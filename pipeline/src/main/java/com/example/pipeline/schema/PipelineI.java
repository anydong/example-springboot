package com.example.pipeline.schema;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
public interface PipelineI<I, C, O> {
    void run(I input, C context, O output);
}
