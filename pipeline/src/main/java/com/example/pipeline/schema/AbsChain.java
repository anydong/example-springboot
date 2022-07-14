package com.example.pipeline.schema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
public abstract class AbsChain<I extends AbsInput, C extends AbsContext, O extends AbsOutput> implements ChainI<I, C, O> {
    @Getter
    private AbsChain<I, C, O> next;

    /**
     * 逻辑处理
     */
    protected abstract void handler(I input, C context, O output);

    /**
     * 是否继续执行下一个 chain
     */
    protected abstract boolean continuable(I input, C context, O output);

    @Override
    public void executor(@NonNull I input, @NonNull C context, @NonNull O output) {
        handler(input, context, output);
        if (Objects.nonNull(next) && continuable(input, context, output)) {
            next.executor(input, context, output);
        }
    }

    public AbsChain<I, C, O> setNext(AbsChain<I, C, O> next) {
        this.next = next;
        return next;
    }
}
