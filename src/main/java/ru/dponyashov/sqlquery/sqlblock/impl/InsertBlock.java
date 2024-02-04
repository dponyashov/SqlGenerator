package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class InsertBlock implements SqlBlock {
    private final List<SqlLine> insertFields;

    public InsertBlock(List<SqlLine> insertFields) {
        this.insertFields = insertFields;
    }
    @Override
    public String blockText() {
        return "("+
                textFields()+
                ")";
    }

    private String textFields() {
        if(insertFields.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        insertFields.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
            if(insertFields.indexOf(sqlLine) < insertFields.size() - 1){
                sb.append(", ");
            }
        });
        return sb.toString();
    }
}
