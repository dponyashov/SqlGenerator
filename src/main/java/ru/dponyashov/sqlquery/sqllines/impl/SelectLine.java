package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.option.Agregate;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

public class SelectLine implements SqlLine {
    private final Agregate function;
    private final String fieldName;

    public SelectLine(Agregate function, String fieldName) {
        this.function = function;
        this.fieldName = fieldName;
    }

    @Override
    public String lineText() {
        return agregateText();
    }

    private String agregateText() {
        if(function == Agregate.EMPTY){
            return fieldName;
        }
        return function.text() + "(" + fieldName + ") as " + function.text() + "_" + fieldName;
    }
}
