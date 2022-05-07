package com.tpbc.pitboss;

import com.tpbc.client.IClient;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DummyPitBoss implements IPitBoss {

    @Override
    public List<Pair<IClient, IClient>> announceCompetitors(List<IClient> clients) {
        List<Pair<IClient, IClient>> result = new ArrayList<>();
        for (int i = 0; i < clients.size(); i += 2) {
            result.add(new Pair<>(clients.get(i), clients.get(i + 1)));
        }
        return result;
    }

    @Override
    public String toString() {
        return "{ DummyPitBoss }";
    }
}
