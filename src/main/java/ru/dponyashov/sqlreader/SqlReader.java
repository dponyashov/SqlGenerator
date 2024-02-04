package ru.dponyashov.sqlreader;

import ru.dponyashov.sqlquery.SqlQuery;

public interface SqlReader {
    SqlQuery readSelect();
    SqlQuery readInsert();
    SqlQuery readUpdate();
    SqlQuery readDelete();
}
