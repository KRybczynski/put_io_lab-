package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver {
    @Override
    public void update(SystemMonitor monitor) {
        // Run garbage collector when out of memory
        if (monitor.getLastSystemState().getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }
    }
}
