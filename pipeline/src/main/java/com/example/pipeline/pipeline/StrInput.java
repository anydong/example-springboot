package com.example.pipeline.pipeline;

import com.example.pipeline.schema.AbsInput;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StrInput extends AbsInput {
    private String input;
}
