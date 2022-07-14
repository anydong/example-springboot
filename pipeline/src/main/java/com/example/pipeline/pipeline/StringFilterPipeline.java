package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsPipeline;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Component
public class StringFilterPipeline extends AbsPipeline<StrInput, StrContext, StrOutput> implements InitializingBean {
    private final ChainOne chainOne;
    private final ChainOneChildOne chainOneChildOne;
    private final ChainTwo chainTwo;

    @Autowired
    public StringFilterPipeline(ChainOne chainOne, ChainOneChildOne chainOneChildOne, ChainTwo chainTwo) {
        this.chainOne = chainOne;
        this.chainOneChildOne = chainOneChildOne;
        this.chainTwo = chainTwo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        chainOne.setNext(chainOneChildOne)
                .setNext(chainTwo);

        this.addChains(chainOne);
        this.addChains(chainTwo);
    }
}
