package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.option.JoinType;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class FromLine implements SqlLine {
    private final JoinType joinType;
    private final String table;
    private final List<SqlLine> fromConditions;

    public FromLine(JoinType joinType, String table, List<SqlLine> fromConditions) {
        this.joinType = joinType;
        this.table = table;
        this.fromConditions = fromConditions;
    }

    @Override
    public String lineText() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(joinType.text());
        sb.append(" ");
        sb.append(table);
        sb.append(" ");
        sb.append("ON");
        fromConditions.forEach(sqlLine -> sb.append(sqlLine.lineText()));
        return sb.toString();
    }
}
