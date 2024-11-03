import org.glassfish.tyrus.server.Server;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WebSocketServerApp {
    public static void main(String[] args) {
        // Configure server properties if needed
        Map<String, Object> properties = new HashMap<>();

        // Create the server instance
        Server server = new Server("localhost", 8080, "/ws", properties, Collections.singleton(WebSocketEndpoints.class));

        try {
            server.start();
            System.out.println("WebSocket server started at ws://localhost:8080/ws/dex-server");
            System.out.println("Press any key to stop the server...");
            System.in.read(); // Waits for user input to stop the server
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
