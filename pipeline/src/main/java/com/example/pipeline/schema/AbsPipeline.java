package com.example.pipeline.schema;

import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
public abstract class AbsPipeline<I extends AbsInput, C extends AbsContext, O extends AbsOutput> implements PipelineI<I, C, O> {
    @Getter
    private List<AbsChain<I, C, O>> chains;

    public void addChains(AbsChain<I, C, O> chain) {
        if (Objects.isNull(chains)) {
            chains = new ArrayList<>();
        }
        chains.add(chain);
    }

    @Override
    public void run(@NonNull I input, @NonNull C context, @NonNull O output) {
        if (Objects.nonNull(chains)) {
            chains.forEach(chain -> chain.executor(input, context, output));
        }
    }
}
