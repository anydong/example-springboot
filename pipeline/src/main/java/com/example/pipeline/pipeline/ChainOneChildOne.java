package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Component
@Slf4j
public class ChainOneChildOne extends AbsChain<StrInput, StrContext, StrOutput> {

    @Override
    protected void handler(StrInput input, StrContext context, StrOutput output) {
        log.info("one-one");
    }

    @Override
    protected boolean continuable(StrInput input, StrContext context, StrOutput output) {
        return false;
    }
}
