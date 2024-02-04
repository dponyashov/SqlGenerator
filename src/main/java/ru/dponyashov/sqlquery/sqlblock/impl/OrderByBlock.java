package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class OrderByBlock implements SqlBlock{
    private final List<SqlLine> groupByFields;

    public OrderByBlock(List<SqlLine> groupByFields) {
        this.groupByFields = groupByFields;
    }

    @Override
    public String blockText() {
        return "ORDER BY " +
                textFields();
    }

    private String textFields() {
        if(groupByFields.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        groupByFields.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
            if(groupByFields.indexOf(sqlLine) < groupByFields.size() - 1){
                sb.append(", ");
            }
        });
        return sb.toString();
    }
}
