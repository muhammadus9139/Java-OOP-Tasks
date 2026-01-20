public class Main{
    public static void main(String args[]){


        Game game1= new Game(3);

        game1.distribute();

        while(Game.counter < 5)
            game1.playhand();

        game1.getvictor();

        //Card c1=new Card(Suit.SPADES,Rank.ACE);
        //System.out.println("Before Shuffle");
        //System.out.println(c1.toString());
        //Deck deck=new Deck();
        //deck.display();

        //System.out.println("================");
        //deck.Shuffle();
        //deck.display();

    }
}