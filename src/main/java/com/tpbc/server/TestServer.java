package com.tpbc.server;

import com.tpbc.battlefield.DummyBattlefield;
import com.tpbc.battlefield.IBattleField;
import com.tpbc.battlefield.IBattleResult;
import com.tpbc.client.IClient;
import com.tpbc.mutator.DummyMutator;
import com.tpbc.mutator.IMutator;
import com.tpbc.pitboss.IPitBoss;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class TestServer implements IServer {
    private static final Logger log = LogManager.getLogger();
    private List<IClient> players;
    private boolean isGameContinue;
    private IPitBoss pitBoss;
    private IMutator mutator;

    @Override
    public void init(List<IClient> clients, IPitBoss pitBoss) {
        log.info("Server initialization has been started.");
        this.players = new ArrayList<>(clients);
        this.isGameContinue = true;
        this.pitBoss = pitBoss;
        this.mutator = new DummyMutator();
        log.info("Server initialization has been completed.");
    }

    @Override
    public void run() {
        log.info("Run has been started.");
        int round = 0;
        while (isGameContinue) {
            round++;
            log.info("Round #" + round + " has been started.");
            // Prepare phase
            log.info("Prepare phase has been started.");
            for (IClient player: players) {
                player.prepare();
            }

            // Pitboss enemy phase
            log.info("Pitboss phase has been started.");
            List<Pair<IClient, IClient>> competitors = pitBoss.announceCompetitors(players);
            log.info("Competitors: " + competitors);

            // Fight phase
            log.info("Fight phase has been started.");
            List<IBattleResult> results = new ArrayList<>();
            for (Pair<IClient, IClient> fighters: competitors) {
                log.info("Fight between fighters "
                        + fighters.getKey() + " and "
                        + fighters.getValue()
                        + " has been started.");
                IBattleField battleField = new DummyBattlefield();
                battleField.init(fighters.getKey(), fighters.getValue());
                IBattleResult result = battleField.fight();
                results.add(result);
                log.info("Fight between fighters "
                        + fighters.getKey() + " and "
                        + fighters.getValue()
                        + " has been finished.");
            }

            // Show phase
            log.info("Show phase has been started.");
            for (IBattleResult result: results) {
                log.info("Battle result: " + result.showResult());
                result.getLooser().removeHP(1);
            }
            // Win condition check phase
            log.info("Win condition phase has been started.");
            List<IClient> alivePlayers = new ArrayList<>();
            for (IClient player: players) {
                if (!player.checkIsAlive()) {
                    log.info("Player " + player + " has been defeated.");
                }
                else {
                    log.info("Player " + player + " has " + player.getHP() + " HP.");
                    alivePlayers.add(player);
                }
            }
            players = alivePlayers;
            if (players.size() <= 1) {
                if (players.size() == 1) {
                    log.info("Player " + players.get(0) + " has won.");
                }
                else {
                    log.info("Game has no winner.");
                }
                isGameContinue = false;
                continue;
            }
            // Mutation phase
            log.info("Mutation phase has been started.");
            for (IClient player: players) {
                log.info("Mutating player " + player);
                mutator.mutate(player);
            }
        }
        log.info("Run has been finished.");
    }

    public List<IClient> getPlayers() {
        return players;
    }

    public void setPlayers(List<IClient> players) {
        this.players = players;
    }

    public boolean isGameContinue() {
        return isGameContinue;
    }

    public void setGameContinue(boolean gameContinue) {
        isGameContinue = gameContinue;
    }

    public IPitBoss getPitBoss() {
        return pitBoss;
    }

    public void setPitBoss(IPitBoss pitBoss) {
        this.pitBoss = pitBoss;
    }

    @Override
    public String toString() {
        return "{" + "players: " + players + ",\n"
                + "isGameContinue: " + isGameContinue + ",\n"
                + "pitBoss: " + pitBoss + "}";
    }
}