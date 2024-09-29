package org.enricogiurin.poc.sbai.component;

import java.util.function.Function;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class AphorismGenerator implements Function<String, String> {

  private final String aphorism;

  public AphorismGenerator(@Qualifier("aphorism") String aphorism) {
    this.aphorism = aphorism;
  }

  @Override
  public String apply(String s) {
    return aphorism;
  }

}
