package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class SelectBlock implements SqlBlock {
    private final List<SqlLine> selectFields;

    public SelectBlock(List<SqlLine> selectFields) {
        this.selectFields = selectFields;
    }

    @Override
    public String blockText() {
        return "SELECT " +
                textFields();
    }

    private String textFields() {
        if(selectFields.isEmpty()) {
            return "*";
        }
        StringBuilder sb = new StringBuilder();
        selectFields.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
            if(selectFields.indexOf(sqlLine) < selectFields.size() - 1){
                sb.append(", ");
            }
        });
        return sb.toString();
    }
}
