package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.option.*;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

public class HavingLine implements SqlLine {
    private String replaceChar = "1";
    private Parenthesis parenthesis;
    private Prefix prefix;
    private Agregate function;
    private String fieldName;
    private Operation operation;
    private ValueType valueType;
    private int valueCount = 0;

    public HavingLine(Parenthesis parenthesis, Prefix prefix, Agregate function, String fieldName,
                      Operation operation, ValueType valueType) {
        initLine(parenthesis, prefix, function, fieldName, operation, valueType, 0);
    }

    public HavingLine(Parenthesis parenthesis, Prefix prefix, Agregate function,String fieldName,
                      Operation operation, ValueType valueType,
                     int valueCount) {
        initLine(parenthesis, prefix, function, fieldName, operation, valueType, valueCount);
    }

    @Override
    public String lineText() {
        return prefixText() +
                openParenthesisText() +
                fieldNameText() +
                operationText() +
                valueText() +
                closeParenthesisText();
    }
    private String fieldNameText() {
        if(function == Agregate.EMPTY){
            return "";
        }
        if(fieldName.isEmpty()){
            return "";
        }
        return " " + function.text() + "(" + fieldName + ")";
    }

    private String operationText() {
        if(operation == Operation.EMPTY){
            return "";
        }
        return " " + operation.text();
    }

    private String prefixText() {
        if(prefix == Prefix.EMPTY){
            return "";
        }
        return " " + prefix.text();
    }

    private String closeParenthesisText() {
        if(parenthesis == Parenthesis.CLOSE){
            return parenthesis.text();
        }
        return Parenthesis.EMPTY.text();
    }

    private String valueText() {
        if(fieldName.isEmpty()){
            return "";
        }
        String valueText = replaceChar;
        if(valueType == ValueType.CHAR){
            valueText = "\"" + valueText + "\"";
        }
        if(valueType == ValueType.DATA){
            valueText = "\"" + valueText + "\"";
        }

        if(operation == Operation.BT){
            return String.format(" %s AND %s", valueText, valueText);
        }

        if(operation == Operation.IN){
            StringBuilder value = new StringBuilder();
            for(int count = 0; count < valueCount; count++) {
                value.append(valueText);
                if(count < valueCount - 1){
                    value.append(", ");
                }
            }
            return String.format(" (%s)", value);
        }
        return " " + valueText;
    }

    private String openParenthesisText() {
        if(parenthesis == Parenthesis.OPEN){
            return " " + parenthesis.text();
        }
        return Parenthesis.EMPTY.text();
    }

    private void initLine(Parenthesis parenthesis, Prefix prefix, Agregate function, String fieldName, Operation operation,
                          ValueType valueType, int valueCount) {
        this.parenthesis = parenthesis;
        this.prefix = prefix;
        this.function = function;
        this.fieldName = fieldName;
        this.operation = operation;
        this.valueType = valueType;
        this.valueCount = valueCount;
    }
}
