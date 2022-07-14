package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsChain;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Component
@Slf4j
public class ChainOne extends AbsChain<StrInput, StrContext, StrOutput> {

    @Autowired
    public ChainOne(ChainOneChildOne chainOneChildOne) {
        this.next = chainOneChildOne;
    }

    @Override
    protected void handler(StrInput input, StrContext context, StrOutput output) {
        log.info("one");
        if (StringUtils.isNotEmpty(input.getInput())) {
            output.setResult(input.getInput().trim());
        }
    }

    @Override
    protected boolean continuable(StrInput input, StrContext context, StrOutput output) {
        return true;
    }
}
