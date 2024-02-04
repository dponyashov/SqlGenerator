package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.option.ValueType;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

public class SetLine implements SqlLine {
    private String replaceChar = "1";
    private final String fieldName;
    private final ValueType fieldType;

    public SetLine(String fieldName, ValueType fieldType) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }
    @Override
    public String lineText() {
        return fieldName +
                " = " +
                valueText();
    }

    private String valueText(){
        if(fieldName.isEmpty()){
            return "";
        }
        String valueText = replaceChar;
        if(fieldType == ValueType.CHAR){
            valueText = "\"" + valueText + "\"";
        }
        if(fieldType == ValueType.DATA){
            valueText = "\"" + valueText + "\"";
        }
        return valueText;
    }
}
