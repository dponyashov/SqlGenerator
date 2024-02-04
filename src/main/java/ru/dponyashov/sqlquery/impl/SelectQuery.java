package ru.dponyashov.sqlquery.impl;

import ru.dponyashov.sqlquery.SqlQuery;
import ru.dponyashov.sqlquery.sqlblock.SqlBlock;

public class SelectQuery implements SqlQuery {
    private final SqlBlock select;
    private final SqlBlock from;
    private final SqlBlock where;
    private final SqlBlock groupBy;
    private final SqlBlock having;
    private final SqlBlock orderBy;

    public SelectQuery(SqlBlock select, SqlBlock from, SqlBlock where, SqlBlock groupBy,
                       SqlBlock having, SqlBlock orderBy) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.having = having;
        this.orderBy = orderBy;
    }
    @Override
    public String queryText() {
        return selectText() +
                "\n" +
                fromText() +
                "\n" +
                whereText() +
                "\n" +
                groupbyText() +
                "\n" +
                havingText() +
                "\n" +
                orderByText();
    }

    private String selectText() {
        if(select == null) {
            return "";
        }
        return select.blockText();
    }

    private String whereText() {
        if(where == null){
            return "";
        }
        return where.blockText();
    }

    private String fromText() {
        if(from == null){
            return "";
        }
        return from.blockText();
    }

    private String groupbyText() {
        if(groupBy == null){
            return "";
        }
        return groupBy.blockText();
    }

    private String havingText() {
        if(having == null) {
            return "";
        }
        return having.blockText();
    }

    private String orderByText() {
        if(orderBy == null) {
            return "";
        }
        return orderBy.blockText();
    }
}
