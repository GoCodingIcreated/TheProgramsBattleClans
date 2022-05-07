package com.tpbc.battlefield;

import com.tpbc.client.IClient;

public interface IBattleResult {
    String showResult();
    IClient getWinner();
    IClient getLooser();
    void setWinner(IClient winner);
    void setLooser(IClient looser);
}
