package com.tpbc.server;

import com.tpbc.client.IClient;
import com.tpbc.pitboss.IPitBoss;

import java.util.List;

public interface IServer {
    void init(List<IClient> clients, IPitBoss pitBoss);
    void run();
}
