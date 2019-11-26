package com.webcheckers.appl.auxiliary;

import java.util.ArrayList;
import java.util.List;

public class BoardViewUtils {
    public static BoardView createMockBoardView(long playerId, long gameId ) throws Exception {
        List<Row> rowList = new ArrayList<Row>();
        // Initializing board
        for(  int i = 0; i < 8; i++ ){
            List<Space> spaceList = new ArrayList<>();
            for( int j = 0; j < 8; j++ ){
                Space.SpaceColor spaceColor = Space.SpaceColor.DARK;
                if( (i % 2 == 0 && j % 2 == 0) || (i%2 == 1 && j%2 == 1) )
                    spaceColor = Space.SpaceColor.WHITE;
                spaceList.add( new Space( spaceColor ) );
            }
            Row row = new Row( i, spaceList );
            rowList.add( row );
        }

        // Creating and adding pieces to Spaces

        rowList.forEach( row -> {
            if( row.getIndex() < 2 )
                row.getSpaceList().forEach( space -> {
                    space.setPiece( new Piece( Piece.PieceColor.WHITE, Piece.PieceType.SINGLE ) );
                } );
            else if( row.getIndex() > 5 )
                row.getSpaceList().forEach( space -> {
                    space.setPiece( new Piece( Piece.PieceColor.RED, Piece.PieceType.SINGLE ) );
                } );
        } );
        return new BoardView( rowList );
    }
}
