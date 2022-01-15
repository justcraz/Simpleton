package banan.edu.model;

public class Card {
    private int id;
    private Suit suit;
    private Denomination denomination;
    private int value;
    private String image;

    public Card() {
    }

    public Card(int id, Suit suit, Denomination denomination, int value, String image) {
        this.id = id;
        this.suit = suit;
        this.denomination = denomination;
        this.value = value;
        this.image = image;
    }

    public Card(int id, String image, int value) {
        this.id = id;
        this.image = image;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", suit=" + suit +
                ", denomination=" + denomination +
                ", value=" + value +
                ", image='" + image + '\'' +
                '}';
    }
}
