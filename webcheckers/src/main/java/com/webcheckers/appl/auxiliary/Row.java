package com.webcheckers.appl.auxiliary;

import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Space> {
    int index;
    List<Space> spaceList;

    public Row( int index, List<Space> spaceList ) throws Exception {
        setSpaceList( spaceList );
        setIndex( index );
    }

    public List<Space> getSpaceList() {
        return spaceList;
    }

    public void setSpaceList(List<Space> spaceList) throws Exception {
        if( spaceList == null || spaceList.size() != 8 )
            throw new Exception("Number of spaces of in a row should be 8!");
        this.spaceList = spaceList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) throws Exception {
        if( index < 0 || index > 7 )
            throw new Exception("Index of a row should be between 0 and 7!");
        this.index = index;
    }

    @Override
    public Iterator<Space> iterator() {
        return getSpaceList().iterator();
    }
}
