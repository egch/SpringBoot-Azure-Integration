package org.enricogiurin.poc.sbai.conf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeansFactory {

  @Bean
  @Qualifier("churchill")
  String churchill(@Value("${aphorism.path:path}") String basePath) throws IOException {

    try (InputStream inputStream = BeansFactory.class.getClassLoader().getResourceAsStream(
        basePath + "/Churchill.txt")) {
      assert inputStream != null;
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
      }
    }
  }

  @Bean
  @Qualifier("uppercase")
  public Function<String, String> uppercase() {
    return String::toUpperCase;

  }
}
