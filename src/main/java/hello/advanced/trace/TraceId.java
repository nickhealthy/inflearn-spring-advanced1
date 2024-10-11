package hello.advanced.trace;

import java.util.UUID;

/**
 * 로그추적기 - 트랜잭션 ID, level 값
 */
public class TraceId {
    private final String id;    // 트랜잭션 ID
    private final int level;    // 트랜잭션 depth

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
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