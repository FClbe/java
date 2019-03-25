import java.util.Random;
public class Card
{
    private int number;
    private String suit;//Hearts 红桃 Spade 黑桃 Diamond 方块 Club 梅花
    public Card (int number, String suit)
    {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public String getSuit()
    {
        return suit;
    }

    public void generateCard()
    {
        Random r  = new Random();
        this.number = r.nextInt(800)%13+1;
        int temp = r.nextInt()%4;
        if (temp == 0)
            this.suit = "Hearts";
        else if (temp == 1)
            this.suit = "Spade";
        else if (temp == 2)
            this.suit = "Diamond";
        else
            this.suit = "Club";
    }

}
