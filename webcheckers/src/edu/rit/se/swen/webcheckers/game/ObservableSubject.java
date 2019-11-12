package edu.rit.se.swen.webcheckers.game;

import edu.rit.se.swen.webcheckers.player.GameViewer;

public interface ObservableSubject {
    public void subscribeGameViewer(GameViewer gameViewer);
    public void unsubscribeGameViewer(GameViewer gameViewer);
    public void notifyUpdate();
}
