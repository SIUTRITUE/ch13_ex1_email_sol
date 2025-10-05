package murach.data;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConfig {
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            try {
                // Get database configuration from environment variables
                String dbHost = System.getenv("DB_HOST");
                String dbPort = System.getenv("DB_PORT");
                String dbName = System.getenv("DB_NAME");
                String dbUser = System.getenv("DB_USER");
                String dbPassword = System.getenv("DB_PASSWORD");
                
                Map<String, String> properties = new HashMap<>();
                
                // If environment variables are set (production), use them
                if (dbHost != null && dbPort != null && dbName != null) {
                    String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
                                                   dbHost, dbPort, dbName);
                    properties.put("jakarta.persistence.jdbc.url", jdbcUrl);
                    properties.put("jakarta.persistence.jdbc.user", dbUser != null ? dbUser : "root");
                    properties.put("jakarta.persistence.jdbc.password", dbPassword != null ? dbPassword : "");
                    System.out.println("Using production database: " + jdbcUrl);
                } else {
                    // Use default local settings (already in persistence.xml)
                    System.out.println("Using local database configuration");
                }
                
                // Common properties
                properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
                properties.put("jakarta.persistence.schema-generation.database.action", "create");
                properties.put("eclipselink.logging.level", "FINE");
                properties.put("eclipselink.ddl-generation", "create-or-extend-tables");
                
                emf = Persistence.createEntityManagerFactory("emailListPU", properties);
                System.out.println("EntityManagerFactory created successfully");
            } catch (Exception e) {
                System.err.println("Failed to create EntityManagerFactory: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        }
        return emf;
    }
    
    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }
}