package LastRun7.arrays;

class largestAltitude_ {
    public int largestAltitude(int[] gain) {

        int altitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            altitude += g;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}