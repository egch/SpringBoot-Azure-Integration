package org.enricogiurin.poc.sbai.component;

import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AphorismGenerator implements Function<String, String> {

  @Autowired
  @Qualifier("aphorism")
  private String aphorism;

  @Override
  public String apply(String s) {
    return aphorism;
  }

}
