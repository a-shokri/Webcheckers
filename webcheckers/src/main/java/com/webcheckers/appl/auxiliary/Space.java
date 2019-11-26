package com.webcheckers.appl.auxiliary;

public class Space {

    public enum SpaceColor {DARK, WHITE};
    int cellIndex;
    Piece piece;
    SpaceColor spaceColor;


    public Space( SpaceColor spaceColor ){
        setSpaceColor( spaceColor );
    }

    public int getCellIndex() {
        return cellIndex;
    }

    public void setCellIndex(int cellIndex) throws Exception {
        if( cellIndex < 0 || cellIndex > 7 )
            throw new Exception("A cellIndex should be between 0 and 7!");
        this.cellIndex = cellIndex;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isValid(){
        return getPiece() == null && getSpaceColor().equals( SpaceColor.DARK ) ;
    }

    public SpaceColor getSpaceColor() {
        return spaceColor;
    }

    public void setSpaceColor(SpaceColor spaceColor) {
        this.spaceColor = spaceColor;
    }
}
