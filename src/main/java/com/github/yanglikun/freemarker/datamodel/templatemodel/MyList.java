package com.github.yanglikun.freemarker.datamodel.templatemodel;

import freemarker.template.TemplateModel;

import java.awt.List;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class MyList extends ArrayList<String> implements TemplateModel {


    public String getString() {
        return this.stream().collect(Collectors.joining("-"));
    }

}
