package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.option.ValueType;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

public class ValueLine implements SqlLine {
    private final String fieldValue;
    private final ValueType valueType;

    public ValueLine(String fieldValue, ValueType valueType) {
        this.fieldValue = fieldValue;
        this.valueType = valueType;
    }

    @Override
    public String lineText() {
        switch (valueType){
            case CHAR -> {
                return "\"" +
                        fieldValue +
                        "\"";
            }
            default -> {
                return fieldValue;
            }
        }
    }
}
