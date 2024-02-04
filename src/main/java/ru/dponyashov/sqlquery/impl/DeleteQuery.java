package ru.dponyashov.sqlquery.impl;

import ru.dponyashov.sqlquery.SqlQuery;
import ru.dponyashov.sqlquery.sqlblock.SqlBlock;

public class DeleteQuery implements SqlQuery {
    private final String tableName;
    private final SqlBlock where;

    public DeleteQuery(String tableName, SqlBlock where) {
        this.tableName = tableName;
        this.where = where;
    }

    @Override
    public String queryText() {
        return "DELETE FROM " +
                tableName +
                "\n" +
                whereText();
    }

    private String whereText() {
        if(where == null){
            return "";
        }
        return where.blockText();
    }
}
