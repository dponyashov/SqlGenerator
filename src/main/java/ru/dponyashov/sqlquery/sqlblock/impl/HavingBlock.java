package ru.dponyashov.sqlquery.sqlblock.impl;

import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqllines.SqlLine;

import java.util.List;

public class HavingBlock implements SqlBlock{
    private final List<SqlLine> havingFields;

    public HavingBlock(List<SqlLine> havingFields) {
        this.havingFields = havingFields;
    }

    @Override
    public String blockText() {
        String commandText = "HAVING";
        return commandText +
                " " +
                textFields();
    }

    private String textFields() {
        if(havingFields.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        havingFields.forEach(sqlLine -> {
            sb.append(sqlLine.lineText());
        });
        return sb.toString();
    }
}
