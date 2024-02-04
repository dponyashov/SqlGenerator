package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class WhereBlock implements SqlBlock {
    private final List<SqlLine> lines;

    public WhereBlock(List<SqlLine> lines) {
        this.lines = lines;
    }

    @Override
    public String blockText() {
        StringBuilder sb = new StringBuilder();
        sb.append("WHERE");
        lines.forEach(sqlLine -> sb.append(sqlLine.lineText()));
        return sb.toString();
    }
}
