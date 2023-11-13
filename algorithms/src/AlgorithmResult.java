public class AlgorithmResult {
    private String algorithmName;
    private long time;

    public AlgorithmResult(String algorithmName, long time) {
        this.algorithmName = algorithmName;
        this.time = time;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public long getTime() {
        return time;
    }
}