package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Component
public class StringFilterPipeline extends AbsPipeline<StrInput, StrContext, StrOutput> {
    @Autowired
    public StringFilterPipeline(ChainOne chainOne, ChainTwo chainTwo) {
        this.addChains(chainOne);
        this.addChains(chainTwo);
    }
}
