public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("John", 10, 120, 100, 60);
        Fighter f2 = new Fighter("Jacob", 15, 100, 85, 50);

        Ring match = new Ring(f1, f2, 85, 100);
        match.run();
    }
}