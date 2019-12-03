package com.webcheckers.appl;

import com.webcheckers.appl.auxiliary.BoardView;
import com.webcheckers.model.Game;
import com.webcheckers.model.HumanPlayer;
import com.webcheckers.model.Player;
import com.webcheckers.model.Tournament;

import java.util.Map;

public interface IGameCenter {
    public void registerUser(Map<String, String> registrationInfo) throws RegistrationException;

    public HumanPlayer login(Map<String, String> loginInfo ) throws LoginException;

    public long startGame(Player player, Map<String, String> newGameInfo) throws GameException;

    public long startTournament(Player organizer, Map<String, String> newTournamentInfo) throws TournamentException;

    public void enrollInTournament(Player player, Tournament tournament) throws TournamentException;

    public void registerPlayerAsViewer(Player player, Game game) throws GameException;

    public BoardView getBoardView(long playerId, long gameId ) throws Exception;


    }
