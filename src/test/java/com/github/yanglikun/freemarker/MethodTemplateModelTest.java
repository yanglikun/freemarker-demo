package com.github.yanglikun.freemarker;

import com.github.yanglikun.freemarker.datamodel.method.NowDateMethod;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MethodTemplateModelTest {

    @Test
    public void test() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        URL templatesURL = ClassLoader.getSystemResource("templates");
        File templateDirectory = new File(templatesURL.getFile());
        cfg.setDirectoryForTemplateLoading(templateDirectory);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        Template temp = cfg.getTemplate("method.ftl");
        Writer out = new OutputStreamWriter(System.out);

        Map<String, Object> root = new HashMap<>();
        root.put("nowDate", new NowDateMethod());

        temp.process(root, out);
    }

}
