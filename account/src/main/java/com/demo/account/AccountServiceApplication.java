package com.demo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class AccountServiceApplication {

  public static void main(String[] args) throws UnknownHostException {
    SpringApplication app = new SpringApplication(AccountServiceApplication.class);
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

}
