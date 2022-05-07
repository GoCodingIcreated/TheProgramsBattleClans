package com.tpbc;

import com.tpbc.client.IClient;
import com.tpbc.client.TestClient;
import com.tpbc.pitboss.DummyPitBoss;
import com.tpbc.pitboss.IPitBoss;
import com.tpbc.server.IServer;
import com.tpbc.server.TestServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        logger.error("Test");

        logger.warn("Test");

        logger.info("Test");
        IServer server = new TestServer();
        IClient client1 = new TestClient();
        IClient client2 = new TestClient();
        client1.init("Player 1");
        client2.init("Player 2");
        List<IClient> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        IPitBoss pitBoss = new DummyPitBoss();
        server.init(clients, pitBoss);
        server.run();
    }
}
