package com.webcheckers.appl.auxiliary;

public class Piece {
    public enum PieceType{SINGLE, KING}
    public enum PieceColor{RED, WHITE}

    PieceType type;
    PieceColor color;

    public Piece( PieceColor pieceColor, PieceType pieceType ){
        setColor( pieceColor );
        setType( pieceType );
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }
}
