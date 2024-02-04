package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class GroupByBlock implements SqlBlock {
    private final List<SqlLine> groupLines;

    public GroupByBlock(List<SqlLine> groupLines) {
        this.groupLines = groupLines;
    }

    @Override
    public String blockText() {
        return  "GROUP BY" +
                " " +
                textFields();
    }

    private String textFields() {
        if(groupLines.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        groupLines.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
            if(groupLines.indexOf(sqlLine) < groupLines.size() - 1){
                sb.append(", ");
            }
        });
        return sb.toString();
    }
}
