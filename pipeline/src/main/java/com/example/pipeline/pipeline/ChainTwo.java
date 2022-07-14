package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Component
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ChainTwo extends AbsChain<StrInput, StrContext, StrOutput> {
    @Override
    protected void handler(StrInput input, StrContext context, StrOutput output) {
        log.info("two");
    }

    @Override
    protected boolean continuable(StrInput input, StrContext context, StrOutput output) {
        return false;
    }
}
