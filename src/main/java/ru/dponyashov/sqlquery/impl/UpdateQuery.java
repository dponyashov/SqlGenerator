package ru.dponyashov.sqlquery.impl;

import ru.dponyashov.sqlquery.SqlQuery;
import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqlblock.impl.SetBlock;
import ru.dponyashov.sqlquery.sqlblock.impl.WhereBlock;

public class UpdateQuery implements SqlQuery {
    private final String tableName;
    private final SqlBlock set;
    private final SqlBlock where;

    public UpdateQuery(String tableName, SqlBlock set, SqlBlock where) {
        this.tableName = tableName;
        this.set = set;
        this.where = where;
    }


    @Override
    public String queryText() {
        return "UPDATE " +
                tableName +
                "\n" +
                setText() +
                "\n" +
                whereText();
    }

    private String setText() {
        if(set == null){
            return "";
        }
        return set.blockText();
    }

    private String whereText() {
        if(where == null){
            return "";
        }
        return where.blockText();
    }
}
