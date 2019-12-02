package com.webcheckers.appl.auxiliary;


import com.webcheckers.appl.auxiliary.Row;

import java.util.Iterator;
import java.util.List;

public class BoardView implements Iterable<Row> {
    List<Row> rowList;

    public BoardView( List<Row> rowList ) throws Exception {
        setRowList( rowList );
    }

    @Override
    public Iterator<Row> iterator() {
        return getRowList().iterator();
    }

    public List<Row> getRowList() {
        return rowList;
    }

    public void setRowList(List<Row> rowList) throws Exception {
        if( rowList == null || rowList.size() != 8 )
            throw new Exception("Number of rows in a board should be 8!");
        this.rowList = rowList;
    }
}
