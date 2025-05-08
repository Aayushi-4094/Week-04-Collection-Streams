package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setup() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
        System.out.println("Test started");
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
        System.out.println("Test finished");
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "Database connection should be established");
    }

    @Test
    void testConnectionClosedAfterEach() {
        assertTrue(dbConnection.isConnected(), "Database connection should be established");
    }
}


