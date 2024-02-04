package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.sqllines.SqlLine;

public class FieldLine implements SqlLine {
    private final String fieldName;

    public FieldLine(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String lineText() {
        return fieldName;
    }
}
