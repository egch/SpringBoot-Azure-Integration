package org.enricogiurin.poc.sbai.conf;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class Loader {

  @Bean
  @Qualifier("aphorism")
  public String getChurchillAphorism(
      @Value("classpath:sentences/churchill.txt") Resource resourceFile) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(resourceFile.getInputStream(), StandardCharsets.UTF_8))) {
      return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    } catch (IOException e) {
      throw new RuntimeException("Error reading churchill.txt", e);
    }
  }

}


