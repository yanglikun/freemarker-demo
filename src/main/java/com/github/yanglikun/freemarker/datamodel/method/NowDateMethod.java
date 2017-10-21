package com.github.yanglikun.freemarker.datamodel.method;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.List;

public class NowDateMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        String parameterPattern = getParameterPattern(arguments);
        return DateTime.now()
                .toString(StringUtils.isEmpty(parameterPattern) ? "yyyy-MM-dd HH:mm:ss" : parameterPattern);
    }

    private String getParameterPattern(List arguments) {
        if (arguments == null || arguments.isEmpty()) {
            return null;
        }
        Object o = arguments.get(0);
        if (!(o instanceof SimpleScalar)) {
            return null;
        }
        return ((SimpleScalar) o).getAsString();
    }

}
