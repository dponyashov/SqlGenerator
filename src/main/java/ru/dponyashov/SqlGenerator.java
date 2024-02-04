package ru.dponyashov;

import ru.dponyashov.sqlquery.SqlQuery;

public class SqlGenerator {
    private final SqlQuery sqlQuery;

    public SqlGenerator(SqlQuery sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String textSelect() {
        return sqlQuery.queryText();
    }
}
