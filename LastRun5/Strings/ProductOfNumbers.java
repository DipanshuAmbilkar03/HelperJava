import java.util.ArrayList;

public class ProductOfNumbers {

    private ArrayList<Integer> productArr = new ArrayList<>();
    private int size = 0;

    public ProductOfNumbers() {
        this.productArr.add(1);
        this.size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            this.productArr = new ArrayList<Integer>();
            this.productArr.add(1);
            this.size = 0;
        } else {
            this.productArr.add(this.productArr.get(size) * num);
            this.size++;
        }
    }

    public int getProduct(int k) {
        if (k > this.size) return 0;

        return (this.productArr.get(this.size) / this.productArr.get(this.size - k));
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println("getProduct(2) -> " + productOfNumbers.getProduct(2));
        System.out.println("getProduct(3) -> " + productOfNumbers.getProduct(3));
        System.out.println("getProduct(4) -> " + productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println("after add(8), getProduct(2) -> " + productOfNumbers.getProduct(2));

        ProductOfNumbers allZeros = new ProductOfNumbers();
        allZeros.add(0);
        allZeros.add(0);
        allZeros.add(7);
        System.out.println("after 0, 0, 7: getProduct(1) -> " + allZeros.getProduct(1));
        System.out.println("after 0, 0, 7: getProduct(2) -> " + allZeros.getProduct(2));
        System.out.println("after 0, 0, 7: getProduct(3) -> " + allZeros.getProduct(3));

        ProductOfNumbers negatives = new ProductOfNumbers();
        negatives.add(-2);
        negatives.add(3);
        System.out.println("after -2, 3: getProduct(2) -> " + negatives.getProduct(2));
        System.out.println("after -2, 3: getProduct(1) -> " + negatives.getProduct(1));

        ProductOfNumbers empty = new ProductOfNumbers();
        System.out.println("empty getProduct(1) -> " + empty.getProduct(1));

        ProductOfNumbers tooLarge = new ProductOfNumbers();
        tooLarge.add(5);
        tooLarge.add(6);
        System.out.println("after 5, 6: getProduct(3) -> " + tooLarge.getProduct(3));
    }
}
