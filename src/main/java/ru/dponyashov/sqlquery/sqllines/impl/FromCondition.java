package ru.dponyashov.sqlquery.sqllines.impl;

import ru.dponyashov.sqlquery.option.Operation;
import ru.dponyashov.sqlquery.option.Prefix;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

public class FromCondition implements SqlLine {
    private final Prefix prefix;
    private final String table;
    private final String secondTable;
    private final String keyField;
    private final String secondKeyField;

    public FromCondition(Prefix prefix, String table, String secondTable, String keyField, String secondKeyField) {
        this.prefix = prefix;
        this.table = table;
        this.secondTable = secondTable;
        this.keyField = keyField;
        this.secondKeyField = secondKeyField;
    }

    @Override
    public String lineText() {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix.text());
        sb.append(" ");
        sb.append(table);
        String fieldTableSeparator = "-";
        sb.append(fieldTableSeparator);
        sb.append(keyField);
        sb.append(" ");
        sb.append(Operation.EQ.text());
        sb.append(" ");
        sb.append(secondTable);
        sb.append(fieldTableSeparator);
        sb.append(secondKeyField);
        sb.append(" ");
        return sb.toString();
    }
}
