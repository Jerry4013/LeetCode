package Medium;

public class P134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        start:
        for (int i = 0; i < n; i++) {
            int tank = gas[i];
            for (int j = i; j < n + i; j++) {
                if (tank - cost[j % n] < 0) {
                    continue start;
                }
                tank = tank - cost[j % n] + gas[(j + 1) % n];
            }
            return i;
        }
        return -1;
    }
}
