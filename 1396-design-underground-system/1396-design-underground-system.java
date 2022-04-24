class Info {
    int id;
    String stationName;
    int t;
    public Info(int id, String stationName, int t) {
        this.id = id;
        this.stationName = stationName;
        this.t = t;
    } 
}
class Average {
    int sum;
    int n;
    public Average() {
        this.sum = 0;
        this.n = 0;
    }
    public Average(int sum, int n) {
        this.sum = sum;
        this.n = n;
    } 
}
class UndergroundSystem {
    Map<String, Average> averageTimes;
    Map<Integer, Info> checks; 
    public UndergroundSystem() {
        averageTimes = new HashMap<>();
        checks = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checks.put(id, new Info(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Info info = checks.get(id);
        String stations = info.stationName + "-" + stationName;
        Average avg = averageTimes.getOrDefault(stations, new Average());
        avg.sum += (t - info.t);
        avg.n += 1;
        averageTimes.put(stations, avg);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String stations = startStation + "-" + endStation;
        Average avg = averageTimes.get(stations);
        return (double)avg.sum / (double)avg.n;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */