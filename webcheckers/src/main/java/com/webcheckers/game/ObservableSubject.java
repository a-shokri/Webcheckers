package com.webcheckers.game;

import com.webcheckers.player.GameViewer;

public interface ObservableSubject {
    public void subscribeGameViewer(GameViewer gameViewer);
    public void unsubscribeGameViewer(GameViewer gameViewer);
    public void notifyUpdate();
}
