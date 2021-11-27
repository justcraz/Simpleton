package banan.edu.model;


import java.util.List;

public class Game{
    List<Battle> battles;

    public Game(List<Battle> battles) {
        this.battles = battles;
    }

    public Game() {
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }

    @Override
    public String toString() {
        return "Game{" +
                "battles=" + battles +
                '}';
    }
}
