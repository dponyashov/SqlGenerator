package ru.dponyashov;

import ru.dponyashov.sqlquery.SqlQuery;
import ru.dponyashov.sqlreader.SqlReader;
import ru.dponyashov.sqlreader.impl.SqlReaderImpl;

public class SqlGeneratorTest {
    public static void main(String[] args) {
        SqlReader sqlReader = new SqlReaderImpl();

        SqlQuery select = sqlReader.readSelect();
        SqlQuery update = sqlReader.readUpdate();
        SqlQuery insert = sqlReader.readInsert();
        SqlQuery delete = sqlReader.readDelete();

        System.out.println("\n" + update.queryText());
        System.out.println("\n" + delete.queryText());
        System.out.println("\n" + insert.queryText());
        System.out.println("\n" + select.queryText());
    }
}