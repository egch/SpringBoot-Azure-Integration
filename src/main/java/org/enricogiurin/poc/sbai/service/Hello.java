package org.enricogiurin.poc.sbai.service;

import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class Hello implements Function<String, String> {


  @Override
  public String apply(String s) {
    return s.toUpperCase();
  }
}
