package com.webcheckers.model;

public interface ObservableSubject {
    public void subscribeGameViewer(GameViewer gameViewer);
    public void unsubscribeGameViewer(GameViewer gameViewer);
    public void notifyUpdate();
}
