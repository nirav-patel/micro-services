package com.demo.customer;

import com.demo.customer.config.KeycloakServerProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableConfigurationProperties({ KeycloakServerProperties.class })
public class AuthApplication {

  public static void main(String[] args) throws UnknownHostException {
    SpringApplication app = new SpringApplication(AuthApplication.class);
    Environment env = app.run(args).getEnvironment();
    if (log.isInfoEnabled()) {
      final String serverPort = env.getProperty("server.port");
      final String serverContextPath = env.getProperty("server.servlet.context-path");
      final String hostAddress = InetAddress.getLocalHost().getHostAddress();
      log.info("Access URLs:"
              + "\n----------------------------------------------------------\n\t"
              + "Local: \t\thttp://localhost:{}{}\n\t"
              + "External: \thttp://{}:{}{}"
              + "\n----------------------------------------------------------",
          serverPort, serverContextPath, hostAddress, serverPort, serverContextPath);
    }
  }

  @Bean
  ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(
      ServerProperties serverProperties, KeycloakServerProperties keycloakServerProperties) {
    return (evt) -> {
      Integer port = serverProperties.getPort();
      String keycloakContextPath = keycloakServerProperties.getContextPath();
      log.info("Embedded Keycloak started: http://localhost:{}{} to use keycloak",
          port, keycloakContextPath);
    };
  }

}
