package ru.dponyashov.sqlreader.impl;

import ru.dponyashov.sqlquery.SqlQuery;
import ru.dponyashov.sqlquery.impl.DeleteQuery;
import ru.dponyashov.sqlquery.impl.InsertQuery;
import ru.dponyashov.sqlquery.impl.SelectQuery;
import ru.dponyashov.sqlquery.impl.UpdateQuery;
import ru.dponyashov.sqlreader.SqlReader;

public class SqlReaderImpl implements SqlReader {
    @Override
    public SqlQuery readSelect() {
        SqlBlockReader blockReader = new SqlBlockReader();
        return new SelectQuery(blockReader.SqlSelect(), blockReader.SqlFrom(), blockReader.SqlWhere(),
                blockReader.SqlGroupBy(), blockReader.SqlHaving(), blockReader.SqlOrderBy());
    }
    @Override
    public SqlQuery readInsert() {
        SqlBlockReader blockReader = new SqlBlockReader();
        return new InsertQuery("table_for_insert", blockReader.SqlInsert(), blockReader.SqlValues());
    }
    @Override
    public SqlQuery readUpdate() {
        SqlBlockReader blockReader = new SqlBlockReader();
        return new UpdateQuery("table_upd", blockReader.SqlSet(), blockReader.SqlWhere());
    }
    @Override
    public SqlQuery readDelete() {
        SqlBlockReader blockReader = new SqlBlockReader();
        return new DeleteQuery("table_del", blockReader.SqlWhere());
    }
}