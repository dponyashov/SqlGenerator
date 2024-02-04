package ru.dponyashov.sqlquery.impl;

import ru.dponyashov.sqlquery.SqlQuery;
import ru.dponyashov.sqlquery.sqlblock.SqlBlock;

public class InsertQuery implements SqlQuery {
    private final String tableName;
    private final SqlBlock insert;
    private final SqlBlock values;

    public InsertQuery(String tableName, SqlBlock insert, SqlBlock values) {
        this.tableName = tableName;
        this.insert = insert;
        this.values = values;
    }
    @Override
    public String queryText() {
        return "INSERT INTO " +
                tableName +
                insert.blockText() +
                "\n" +
                " VALUES" +
                values.blockText();
    }
}
