package checkpoint;

import java.util.ArrayList;
import java.util.Iterator;

public class CheckPoint99 {

    static class CartForSongs {
        ArrayList<Song> cart = new ArrayList<Song>();

        public double calculateTotalPrice() {
            double total = 0.0;
            Iterator<Song> itr = cart.iterator();
            while (itr.hasNext()) {
                Song song = itr.next();
                total += song.getMode().getDiscountedPrice(song.getPrice());
            }
            return total;
        }

        public void add(Song song) {
            this.cart.add(song);
        }
    }

    static class Song {
        private DiscountMode mode;

        public void setMode(DiscountMode mode) {
            this.mode = mode;
        }

        public double getPrice() {
            return 10.0;
        }

        public DiscountMode getMode() {
            return this.mode;
        }
    }

    public static abstract class DiscountMode {
        public abstract double getDiscountedPrice(double price);
    }

    public static class NonDiscounted extends DiscountMode {

        public double getDiscountedPrice(double price) {
            return price;
        }
    }

    public static class OnSale extends DiscountMode {
        public double getDiscountedPrice(double price) {
            return price - 0.1 * price;
        }
    }

    public static class TodayEvent extends DiscountMode {
        public double getDiscountedPrice(double price) {
            return price + 0.1 * price;
        }
    }

    public static void main(String[] args) {
        CartForSongs cart = new CartForSongs();
        Song song = new Song();
        song.setMode(new NonDiscounted());
        cart.add(song);

        song = new Song();
        song.setMode(new OnSale());
        cart.add(song);

        song = new Song();
        song.setMode(new TodayEvent());
        cart.add(song);

        System.out.println(cart.calculateTotalPrice());
    }



}
