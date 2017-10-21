package com.github.yanglikun.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    @Test
    public void testList() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        URL templatesURL = ClassLoader.getSystemResource("templates");
        File templateDirectory = new File(templatesURL.getFile());
        cfg.setDirectoryForTemplateLoading(templateDirectory);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        Template temp = cfg.getTemplate("list.ftl");
        Writer out = new OutputStreamWriter(System.out);

        Map<String, Object> root = new HashMap<>();
        root.put("fruits", Stream.of("apple", "orange").collect(Collectors.toList()));
        root.put("nullFruits", null);
        root.put("emptyFruits", new ArrayList<>());

        temp.process(root, out);
    }
}
