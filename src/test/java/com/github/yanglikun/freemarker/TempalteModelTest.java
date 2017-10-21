package com.github.yanglikun.freemarker;

import com.github.yanglikun.freemarker.datamodel.templatemodel.MyList;
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

public class TempalteModelTest {

    @Test
    public void testList() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        URL templatesURL = ClassLoader.getSystemResource("templates");
        File templateDirectory = new File(templatesURL.getFile());
        cfg.setDirectoryForTemplateLoading(templateDirectory);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        Template temp = cfg.getTemplate("templatemode.ftl");
        Writer out = new OutputStreamWriter(System.out);

        Map<String, Object> root = new HashMap<>();
        MyList myList = new MyList();
        myList.add("a");
        myList.add("d");
        myList.add("b");
        root.put("myList", myList);

        temp.process(root, out);
    }

}
