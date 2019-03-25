
public class exercise5
{
     public static void main (String[] args)
     {
         Card c1 = new Card(1,"Hearts");
         Card c2 = new Card(2,"Hearts");
         Card c3 = new Card(3,"Hearts");
         CardGroup cg1 = new CardGroup(c1, c2, c3);
         CardGroup cg2 = new CardGroup(c1, c2, c3);
         CardGroup cg3 = new CardGroup(c1, c2, c3);

         cg1.createRandomCardGroup();
         cg2.createRandomCardGroup();
         cg3.createRandomCardGroup();

         System.out.println(cg1.getC1().getNumber() + " " + cg2.getC1().getNumber() + " " + cg3.getC1().getNumber());
         System.out.println(cg1.getC2().getNumber() + " " + cg2.getC2().getNumber() + " " + cg3.getC2().getNumber());
         System.out.println(cg1.getC3().getNumber() + " " + cg2.getC3().getNumber() + " " + cg3.getC3().getNumber());
         System.out.println(cg1.getC1().getSuit() + " " + cg2.getC1().getSuit() + " " + cg3.getC1().getSuit());
         System.out.println(cg1.getC2().getSuit() + " " + cg2.getC2().getSuit() + " " + cg3.getC2().getSuit());
         System.out.println(cg1.getC3().getSuit() + " " + cg2.getC3().getSuit() + " " + cg3.getC3().getSuit());
         if (cg1.compare(cg3) == 1)
         {
             if (cg1.compare(cg2) == 1)
                 System.out.println("最大的是 cg1");
             else if (cg1.compare(cg2) == 0)
                 System.out.println("最大的是 cg1  cg2");
             else
                 System.out.println("最大的是 cg2");
         }
         else if(cg1.compare(cg3) == 0)
         {
             if (cg1.compare(cg2) == 1)
                 System.out.println("最大的是 cg1 cg3");
             else if (cg1.compare(cg2) == 0)
                 System.out.println("全部相等");
             else
                 System.out.println("最大的是 cg2");
         }
         else
         {
             if (cg3.compare(cg2) == 1)
                 System.out.println("最大的是 cg3");
             else if (cg3.compare(cg2) == 0)
                 System.out.println("最大的是 cg3  cg2");
             else
                 System.out.println("最大的是 cg2");
         }
     }

}









/*import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private ArrayList<Card> cards;
    Random random;
    public Deck()
    {
        this.cards = new ArrayList<Card>();
        this.random = (new Random());
        this.generateDeck();
    }
    Deck deck;
    private  void generateDeck()
    {
        int Anumber = deck.random.nextInt(12)+1;
        int Asuit = deck.random.nextInt(3);

    }

}*/
