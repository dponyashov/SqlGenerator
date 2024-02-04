package ru.dponyashov.impl;

import ru.dponyashov.SqlGenerator;
import ru.dponyashov.sqlquery.SqlQuery;

public class SqlGeneratorImpl implements SqlGenerator {
    private final SqlQuery select;
    private final SqlQuery insert;
    private final SqlQuery update;
    private final SqlQuery delete;

    public SqlGeneratorImpl(SqlQuery select, SqlQuery insert, SqlQuery update, SqlQuery delete) {
        this.select = select;
        this.insert = insert;
        this.update = update;
        this.delete = delete;
    }

    @Override
    public String selectText() {
        if (select == null){
            return "";
        }
        return select.queryText();
    }

    @Override
    public String insertText() {
        if (insert == null){
            return "";
        }
        return insert.queryText();
    }

    @Override
    public String updateText() {
        if (update == null){
            return "";
        }
        return update.queryText();
    }

    @Override
    public String deleteText() {
        if (delete == null){
            return "";
        }
        return delete.queryText();
    }
}
