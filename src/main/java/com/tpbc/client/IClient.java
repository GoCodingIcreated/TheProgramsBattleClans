package com.tpbc.client;

public interface IClient {
    void init(String name);

    void prepare();

    boolean checkIsAlive();

    void removeHP(int HPChange);
    int getHP();
}
