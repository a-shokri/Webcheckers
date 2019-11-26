package com.webcheckers.appl;

import com.webcheckers.appl.auxiliary.BoardView;
import com.webcheckers.model.GameView;
import com.webcheckers.appl.auxiliary.BoardViewUtils;
import com.webcheckers.model.*;
import com.webcheckers.model.db.DBManagerFactory;
import com.webcheckers.model.db.IDataManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCenter implements IGameCenter {
    IDataManager dataManager;
    public GameCenter(){
        dataManager = DBManagerFactory.getDataManager();
    }
    public void registerUser(Map<String, String> registrationInfo) throws RegistrationException{
        HumanPlayer humanPlayer = fromMapToHumanPlayer( registrationInfo );
        validateRegistrationInfo( humanPlayer );
        createUser( humanPlayer );
    }

    protected HumanPlayer fromMapToHumanPlayer( Map<String, String> registrationInfo ){
        HumanPlayer humanPlayer = new HumanPlayer();
        humanPlayer.setUsername( registrationInfo.get(HumanPlayer.ATTRIB_USERNAME) );
        humanPlayer.setPassword( registrationInfo.get(HumanPlayer.ATTRIB_PASSWORD) );
        humanPlayer.setEmail( registrationInfo.get(HumanPlayer.ATTRIB_EMAIL) );
        return humanPlayer;
    }

    protected void validateRegistrationInfo(HumanPlayer humanPlayer) throws RegistrationException{
        if( humanPlayer.getUsername() == null || humanPlayer.getUsername().trim().isEmpty() ||
                humanPlayer.getPassword() == null || humanPlayer.getPassword().isEmpty() ||
                humanPlayer.getEmail() == null || humanPlayer.getEmail().trim().isEmpty()
        )
            throw new RegistrationException("Registration information is not complete! Please fill the form correctly!");
    }

    protected HumanPlayer createUser( HumanPlayer humanPlayer ) throws RegistrationException {
        Integer id = dataManager.save( humanPlayer );
        return (HumanPlayer) dataManager.findById( HumanPlayer.class, id );
    }

    public HumanPlayer login(Map<String, String> loginInfo ) throws LoginException {
        HumanPlayer user = validateUser( loginInfo );
        return user;
    }

    protected HumanPlayer validateUser(Map<String, String> loginInfo) throws LoginException{
        Map<String, Object> searchParam = new HashMap<>();
        searchParam.putAll( loginInfo );
        List<Object> foundUsers = dataManager.find( HumanPlayer.class, searchParam );
        if( foundUsers == null || foundUsers.size() != 1 )
            throw new LoginException( "Provided user information is not correct!" );
        return (HumanPlayer) foundUsers.get(0);
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

    public BoardView getBoardView(long playerId, long gameId ) throws Exception {
        return BoardViewUtils.createMockBoardView( playerId, gameId );
    }


}
