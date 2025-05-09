package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.Timeout;
        import java.util.concurrent.TimeUnit;
        import static org.junit.jupiter.api.Assertions.*;

class TaskUtilsTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)  // Test fails if execution exceeds 2 seconds
    void testLongRunningTask_WithTimeout() throws InterruptedException {
        String result = TaskUtils.longRunningTask();
        assertEquals("Task completed", result);
    }

    // Alternative version that handles the timeout more gracefully
    @Test
    void testLongRunningTask_WithAssertTimeout() {
        assertTimeoutPreemptively(
                java.time.Duration.ofSeconds(2),
                () -> {
                    String result = TaskUtils.longRunningTask();
                    assertEquals("Task completed", result);
                }
        );
    }
}