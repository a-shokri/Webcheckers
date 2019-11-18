package com.webcheckers.appl;

import com.webcheckers.model.Game;
import com.webcheckers.model.GameView;
import com.webcheckers.model.Player;
import com.webcheckers.model.Tournament;

import java.util.Map;

public class GameCenter {
    public void registerUser(Map<String, String> registrationInfo) throws RegistrationException{
        validateRegistrationInfo( registrationInfo );
        createUser( registrationInfo );
    }

    protected void validateRegistrationInfo(Map<String, String> registrationInfo) throws RegistrationException{
        throw new RegistrationException( "This method is not implemented yet!" );
    }

    protected void createUser( Map<String, String> registrationInfo ) throws RegistrationException {
        throw new RegistrationException("This method is not implemented yet!");
    }

    public String login( Map<String, String> loginInfo ) throws LoginException {
        validateUser( loginInfo );
        // TODO: create a session id and pass it for the future interactions
        return null;
    }

    protected void validateUser(Map<String, String> loginInfo) throws LoginException{
        throw new LoginException( "This method is not implemented yet!" );
    }

    public long startGame(Player player, Map<String, String> newGameInfo) throws GameException{
        validateNewGameInfo( newGameInfo );
        long gameId = createOrFindAGameForPlayer( player, newGameInfo );
        return gameId;
    }

    protected void validateNewGameInfo( Map<String, String> newGameInfo ) throws GameException{
        throw new GameException( "This method is not implemented yet!" );
    }

    protected long createOrFindAGameForPlayer( Player player, Map<String, String> newGameInfo ) throws GameException{
        throw new GameException( "This method is not implemented yet!" );
    }

    public long startTournament(Player organizer, Map<String, String> newTournamentInfo) throws TournamentException{
        validateNewTournamentInfo( newTournamentInfo );
        long gameId = createTournament( organizer, newTournamentInfo );
        return gameId;
    }

    protected void validateNewTournamentInfo( Map<String, String> newTournamentInfo ) throws TournamentException{
        throw new TournamentException( "This method is not implemented yet!" );
    }

    protected long createTournament( Player organizer, Map<String, String> newGameInfo ) throws TournamentException{
        throw new TournamentException( "This method is not implemented yet!" );
    }

    public void enrollInTournament(Player player, Tournament tournament) throws TournamentException {
        validateTournamentEnrollment( player, tournament );
        //TODO: add the player to the tournament
    }

    protected void validateTournamentEnrollment(Player player, Tournament tournament) throws TournamentException{
        throw new TournamentException( "This method is not implemented yet!" );
    }

    public void registerPlayerAsViewer(Player player, Game game) throws GameException{
        validateGameView( player, game );
        //TODO: find the corresponding game and call subscribe( player )
    }

    protected void validateGameView( Player player, Game game ) throws GameException{
        throw new GameException( "This method is not implemented yet!" );
    }


}
