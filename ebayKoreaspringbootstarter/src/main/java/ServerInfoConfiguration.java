import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServerInfoProperties.class)
public class ServerInfoConfiguration {
    @Bean
    public ServerInfo serverInfo() {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setAddress("172.0.0.1");
        serverInfo.setPort(8080);
        return serverInfo;
    }
}
