package com.tpbc.battlefield;

import com.tpbc.client.IClient;

public interface IBattleField {
    void init(IClient fighter1, IClient fighter2);
    IBattleResult fight();
}
