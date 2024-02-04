package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class SetBlock implements SqlBlock {

    private final List<SqlLine> setFields;

    public SetBlock(List<SqlLine> setFields) {
        this.setFields = setFields;
    }

    @Override
    public String blockText() {
        return "SET " +
                textFields();
    }

    private String textFields() {
        if(setFields.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        setFields.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
            if(setFields.indexOf(sqlLine) < setFields.size() - 1){
                sb.append(", ");
            }
        });
        return sb.toString();
    }
}
