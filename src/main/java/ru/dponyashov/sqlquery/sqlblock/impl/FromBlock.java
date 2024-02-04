package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class FromBlock implements SqlBlock {
    private final String table;
    private final List<SqlLine> fromLines;

    public FromBlock(String table, List<SqlLine> fromLines) {
        this.table = table;
        this.fromLines = fromLines;
    }

    @Override
    public String blockText() {
        StringBuilder sb = new StringBuilder();
        sb.append("FROM");
        sb.append(" ");
        sb.append(table);
        sb.append(" ");
        fromLines.forEach(sqlLine -> sb.append(sqlLine.lineText()));
        return sb.toString();
    }
}
