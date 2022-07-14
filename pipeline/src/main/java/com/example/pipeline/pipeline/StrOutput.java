package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StrOutput extends AbsOutput {
    private String result;
}
