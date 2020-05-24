package cn.springcloud.book.eureka;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

/**
 * eureka server
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);

    public static void main(String[] args) throws UnknownHostException {

        Environment env = SpringApplication.run(EurekaServerApplication.class, args)
                                           .getEnvironment();
        String protocol = "http";

        logger.info(
            "\n----------------------------------------------------------\n\t"
            + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
            + "External: \t{}://{}:{}\n\t"
            + "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
            InetAddress.getLocalHost()
                       .getHostAddress(), env.getProperty("server.port"), env.getActiveProfiles());
    }
}
