import java.util.*;

public class destroyAsteroids {

    private boolean solution1(int mass, int[] asteroids) {
        long ans = mass;

        Arrays.sort(asteroids);

        for (int stone : asteroids) {
            if (stone > ans) {
                return false;
            }
            ans += stone;
        }

        return true;
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // return solution1(mass, asteroids);
        return solution2(mass, asteroids);
    }

    private boolean solution2(int mass, int[] asteroids) {
        int weg = mass;
        List<Integer> miss = new ArrayList<>();

        for (int i : asteroids) {
            if (i < weg) {
                weg += i;
            } else {
                miss.add(i);
            }
        }

        Iterator<Integer> it = miss.iterator();

        while (it.hasNext()) {
            int x = it.next();

            if (x <= weg) {
                weg += x;
                it.remove();
            }
        }

        return miss.isEmpty();
    }

    public static void main(String[] args) {
        destroyAsteroids obj = new destroyAsteroids();

        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};

        boolean result = obj.asteroidsDestroyed(mass, asteroids);

        System.out.println("Result: " + result);
    }
}