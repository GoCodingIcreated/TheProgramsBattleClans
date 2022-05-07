package com.tpbc.pitboss;

import com.tpbc.client.IClient;
import javafx.util.Pair;

import java.util.List;

public interface IPitBoss {
    List<Pair<IClient, IClient>> announceCompetitors(List<IClient> clients);
}
