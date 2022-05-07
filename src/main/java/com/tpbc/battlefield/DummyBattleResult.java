package com.tpbc.battlefield;

import com.tpbc.client.IClient;

public class DummyBattleResult implements IBattleResult {
    IClient winner;
    IClient looser;

    @Override
    public String showResult() {
        return "{" + "Winner: " + winner + ",\n" +
                "Looser: " + looser + "}";
    }

    @Override
    public IClient getWinner() {
        return winner;
    }

    @Override
    public IClient getLooser() {
        return looser;
    }

    @Override
    public void setWinner(IClient winner) {
        this.winner = winner;
    }

    @Override
    public void setLooser(IClient looser) {
        this.looser = looser;
    }

    @Override
    public String toString() {
        return showResult();
    }

}
