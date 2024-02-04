package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class ValuesBlock implements SqlBlock {
    private final List<SqlLine> values;

    public ValuesBlock(List<SqlLine> values) {
        this.values = values;
    }
    @Override
    public String blockText() {
        return "("+
                textFields()+
                ")";
    }
    private String textFields() {
        if(values.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        values.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
            if(values.indexOf(sqlLine) < values.size() - 1){
                sb.append(", ");
            }
        });
        return sb.toString();
    }
}
