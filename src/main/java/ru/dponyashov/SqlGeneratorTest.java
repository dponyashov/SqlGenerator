package ru.dponyashov;

import ru.dponyashov.impl.SqlGeneratorImpl;
import ru.dponyashov.sqlreader.SqlReader;
import ru.dponyashov.sqlreader.impl.SqlReaderImpl;

public class SqlGeneratorTest {
    public static void main(String[] args) {
        SqlReader sqlReader = new SqlReaderImpl();

        SqlGenerator generator = new SqlGeneratorImpl(sqlReader.readSelect(),
                sqlReader.readInsert(),
                sqlReader.readUpdate(),
                sqlReader.readDelete());

        System.out.println("\n" + generator.insertText());
        System.out.println("\n" + generator.updateText());
        System.out.println("\n" + generator.deleteText());
        System.out.println("\n" + generator.selectText());
    }
}