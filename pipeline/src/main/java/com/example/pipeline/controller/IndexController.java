package com.example.pipeline.controller;

import com.example.pipeline.pipeline.StrContext;
import com.example.pipeline.pipeline.StrInput;
import com.example.pipeline.pipeline.StrOutput;
import com.example.pipeline.pipeline.StringFilterPipeline;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Where.LIU
 * @since 2022/7/14
 */
@RestController
public class IndexController {
    private final StringFilterPipeline stringFilterPipeline;

    @Autowired
    public IndexController(StringFilterPipeline stringFilterPipeline) {
        this.stringFilterPipeline = stringFilterPipeline;
    }

    @GetMapping(value = "/")
    public String index(@Nullable @RequestParam("str") String str) {
        if (StringUtils.isEmpty(str)) {
            return "empty";
        }
        StrInput strInput = new StrInput();
        strInput.setInput(str);

        StrContext strContext = new StrContext();

        StrOutput strOutput = new StrOutput();

        stringFilterPipeline.run(strInput, strContext, strOutput);

        return strOutput.getResult();
    }
}
