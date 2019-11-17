package com.webcheckers.game;

import com.webcheckers.player.Player;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GAME")
public abstract class Game implements ObservableSubject{
    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    @Column(name = "date")
    Date date;

    @Column(name = "level")
    GameLevel level;

    @JoinColumn(name = "winner_id", unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    Player winner;

    @JoinColumn(name = "first_player_id", unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    Player firstPlayer;

    @JoinColumn(name = "second_player_id", unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    Player secondPlayer;

    public abstract void addPlayer( Player player );
    public void sendMessageToPlayer( Player player, Message message ){
        // TODO: implementation needed
    }
    public abstract void startTheGame();
    protected void startTheTimerForPlayer( Player player ){
        // TODO: implementation needed
    }
    public void requestMoveThePiece( Piece piece, Square square ){
        // TODO: implementation needed
    }
    protected void validatePieceMove( Piece piece, Square square ) throws PieceMoveException{
        // TODO: implementation needed
    }
    protected void moveTheBoardPiece( Piece piece, Square square ) throws PieceMoveException{
        // TODO: implementation needed
    }
    protected void endTheGame(){
        // TODO: implementation needed
    }
    public void resign( Player player ) throws GameActionException {
        if( !( player.equals( getFirstPlayer() ) || player.equals( getSecondPlayer() ) ) )
            throw new GameActionException( "The specified player is not a player of this game!" );
        if( player.equals( getFirstPlayer() ) )
            setWinner( getSecondPlayer() );
        else setWinner( getFirstPlayer() );
        endTheGame();
    }
    public GameView getGameView(){
        // TODO: implementation needed
        return null;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GameLevel getLevel() {
        return level;
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
