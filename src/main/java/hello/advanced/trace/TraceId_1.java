package hello.advanced.trace;

import java.util.UUID;

public class TraceId_1 {

    private String id;
    private int level;

    public TraceId_1() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId_1(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId_1 createNextId() {
        return new TraceId_1(id, level + 1);
    }

    public TraceId_1 createPreviousId() {
        return new TraceId_1(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
