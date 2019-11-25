package com.webcheckers.appl;

public class GameCenterFactory {
    static IGameCenter gameCenter = null;
    static public IGameCenter getGameCenter(){
        if( gameCenter == null )
            gameCenter = new GameCenter();
        return gameCenter;
    }

}
