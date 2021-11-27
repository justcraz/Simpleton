package banan.edu.model;

public class Battle {
    private Card attack;
    private Card defence;

    public Battle(Card attack, Card defence) {
        this.attack = attack;
        this.defence = defence;
    }

    public Battle() {
    }

    public Card getAttack() {
        return attack;
    }

    public void setAttack(Card attack) {
        this.attack = attack;
    }

    public Card getDefence() {
        return defence;
    }

    public void setDefence(Card defence) {
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "attack=" + attack +
                ", defence=" + defence +
                '}';
    }
}
