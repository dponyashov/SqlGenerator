package ru.dponyashov.sqlreader.impl;

import ru.dponyashov.sqlquery.option.*;
import ru.dponyashov.sqlquery.sqlblock.SqlBlock;
import ru.dponyashov.sqlquery.sqlblock.impl.*;
import ru.dponyashov.sqlquery.sqllines.SqlLine;
import ru.dponyashov.sqlquery.sqllines.impl.*;

import java.util.ArrayList;
import java.util.List;

public class SqlBlockReader {
    SqlBlock SqlFrom(){
        List<SqlLine> fromLines = new ArrayList<>();
        String table = "table1";
        String secondTable = "table2";
        List<SqlLine> fromConditions = new ArrayList<>();
        fromConditions.add(new FromCondition(Prefix.EMPTY, table, secondTable, "id11", "id21"));
        fromConditions.add(new FromCondition(Prefix.AND, table, secondTable, "id12", "id22"));
        fromLines.add(new FromLine(JoinType.INNER_JOIN, secondTable, fromConditions));

        List<SqlLine> fromConditions2 = new ArrayList<>();
        secondTable = "table3";
        fromConditions2.add(new FromCondition(Prefix.EMPTY, table, secondTable, "id11", "id31"));
        fromLines.add(new FromLine(JoinType.INNER_JOIN, secondTable, fromConditions2));
        return new FromBlock(table, fromLines);
    }
    SqlBlock SqlGroupBy(){
        List<SqlLine> groupbyFields = new ArrayList<>();
        groupbyFields.add(new FieldLine("name"));
        groupbyFields.add(new FieldLine("birthdate"));
        groupbyFields.add(new FieldLine("phone"));
        return new GroupByBlock(groupbyFields);

    }
    SqlBlock SqlHaving(){
        List<SqlLine> havingFields = new ArrayList<>();
        havingFields.add(new HavingLine(Parenthesis.EMPTY, Prefix.EMPTY, Agregate.COUNT, "name", Operation.EQ, ValueType.CHAR));
        havingFields.add(new HavingLine(Parenthesis.EMPTY,Prefix.AND, Agregate.MAX, "age", Operation.GT, ValueType.DIGIT));
        return new HavingBlock(havingFields);
    }
    SqlBlock SqlOrderBy(){
        List<SqlLine> orderByFields = new ArrayList<>();
        orderByFields.add(new FieldLine("name"));
        orderByFields.add(new FieldLine("birthdate"));
        orderByFields.add(new FieldLine("phone"));
        return new OrderByBlock(orderByFields);
    }
    SqlBlock SqlSelect(){
        List<SqlLine> selectFields = new ArrayList<>();
        selectFields.add(new SelectLine(Agregate.EMPTY, "name"));
        selectFields.add(new SelectLine(Agregate.EMPTY, "birthdate"));
        selectFields.add(new SelectLine(Agregate.EMPTY, "phone"));
        selectFields.add(new SelectLine(Agregate.SUM, "age"));
        return new SelectBlock(selectFields);
    }
    SqlBlock SqlSet(){
        List< SqlLine > setLines = new ArrayList<>();
        setLines.add(new SetLine("name", ValueType.CHAR));
        setLines.add(new SetLine("birthdate", ValueType.DATA));
        setLines.add(new SetLine("phone", ValueType.DIGIT));
        return  new SetBlock(setLines);
    }
    SqlBlock SqlWhere(){
        List<SqlLine> whereLines = new ArrayList<>();
        whereLines.add(new WhereLine(Parenthesis.EMPTY, Prefix.EMPTY, "field11", Operation.IN, ValueType.DIGIT, 3));
        whereLines.add(new WhereLine(Parenthesis.OPEN, Prefix.AND, "", Operation.EMPTY, ValueType.EMPTY));
        whereLines.add(new WhereLine(Parenthesis.OPEN, Prefix.EMPTY, "field21", Operation.EQ, ValueType.DATA));
        whereLines.add(new WhereLine(Parenthesis.CLOSE, Prefix.OR, "field22", Operation.EQ, ValueType.DIGIT));
        whereLines.add(new WhereLine(Parenthesis.EMPTY, Prefix.AND, "field31", Operation.BT, ValueType.CHAR));
        whereLines.add(new WhereLine(Parenthesis.CLOSE, Prefix.EMPTY, "", Operation.EMPTY, ValueType.EMPTY));
        return new WhereBlock(whereLines);
    }
    SqlBlock SqlInsert(){
        List<SqlLine> insertFields = new ArrayList<>();
        insertFields.add(new FieldLine("name"));
        insertFields.add(new FieldLine("birthdate"));
        insertFields.add(new FieldLine("phone"));
        return new InsertBlock(insertFields);
    }
    SqlBlock SqlValues(){
        List<SqlLine> values = new ArrayList<>();
        values.add(new ValueLine("name", ValueType.CHAR));
        values.add(new ValueLine("birthdate", ValueType.DATA));
        values.add(new ValueLine("phone", ValueType.CHAR));
        return new ValuesBlock(values);
    }
}
