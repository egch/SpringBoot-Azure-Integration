package org.enricogiurin.poc.sbai.component;

import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class UpperCase implements Function<String, String> {

  @Override
  public String apply(String s) {
    return s.toUpperCase();
  }
}
