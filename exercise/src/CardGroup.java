public class CardGroup
{
    private Card c1;
    private Card c2;
    private Card c3;
    public CardGroup(Card c1, Card c2, Card c3)
    {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }
    public CardGroup()
    {

    }
    public int numOfSameNumber()
    {
        int temp = 0;
     if(c1.getNumber() == c2.getNumber() &&c1.getNumber()== c3.getNumber())
        temp =  3;
         //System.out.println(c1);
     else if(c1.getNumber() == c3.getNumber()||c3.getNumber() == c2.getNumber()||c1.getNumber() == c2.getNumber())
            temp =  2;
            //System.out.println(c1);
       else
            temp =  1;
            //System.out.println(c3);
        return temp;
    }
    public boolean isSuitSame()
    {
        boolean temp = false;
        if (this.c1.getSuit() == this.c2.getSuit() && this.c1.getSuit() == this.c3.getSuit())
            temp = true;
        return  temp;

    }
    public int sumOfNumber()
    {
        return c1.getNumber() + c2.getNumber() + c3.getNumber();
    }

    public int compare(CardGroup c)
    {
        int tempa = 0;
        int tempb = 0;
        int temp = 0;
        if (this.c1.getSuit() == this.c2.getSuit() && this.c1.getSuit() == this.c3.getSuit())
            tempa = 4;
        else if (this.c1.getNumber() == this.c2.getNumber() && this.c1.getNumber() == this.c3.getNumber())
            tempa = 3;
        else if (this.c1.getNumber() == this.c3.getNumber()||this.c3.getNumber() == this.c2.getNumber()||this.c1.getNumber() == this.c2.getNumber())
            tempa = 2;
        else
            tempa = 1;
        if (c.c1.getSuit() == c.c2.getSuit() && c.c1.getSuit() == c.c3.getSuit())
            tempb = 4;
        else if (c.c1.getNumber() == c.c2.getNumber() && c.c1.getNumber() == c.c3.getNumber())
            tempb = 3;
        else if (c.c1.getNumber() == c.c3.getNumber()||c.c3.getNumber() == c.c2.getNumber()||c.c1.getNumber() == c.c2.getNumber())
            tempb = 2;
        else
            tempb = 1;

        if (tempa < tempb)
            temp = -1;
        if (tempa == tempb)
            temp = 0;
        if (tempa > tempb)
            temp = 1;
        return temp;
    }

    public void createRandomCardGroup()
    {
        this.c1 = new Card(1,"Hearts");
        this.c2 = new Card(1,"Hearts");
        this.c3 = new Card(1,"Hearts");

        this.c1.generateCard();
        this.c2.generateCard();
        this.c3.generateCard();

    }

    public Card getC1() {
        return c1;
    }

    public Card getC2() {
        return c2;
    }

    public Card getC3() {
        return c3;
    }
}
