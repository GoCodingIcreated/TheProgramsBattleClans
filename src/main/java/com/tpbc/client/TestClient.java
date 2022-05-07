package com.tpbc.client;

public class TestClient implements IClient {
    private String name;
    int HP;

    @Override
    public void init(String name) {
        this.name = name;
        this.HP = 3;
    }

    @Override
    public void prepare() {

    }

    @Override
    public boolean checkIsAlive() {
        return HP > 0;
    }

    @Override
    public void removeHP(int HPChange) {
        HP -= HPChange;
    }

    @Override
    public int getHP() {
        return HP;
    }

    public TestClient() {
        this.name = "Test name";
    }

    public TestClient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + "Name: " + name + "}";
    }
}