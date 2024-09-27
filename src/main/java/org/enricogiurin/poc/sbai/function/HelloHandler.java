package org.enricogiurin.poc.sbai.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

@Slf4j
public class HelloHandler {

  private final String message;

  public HelloHandler(@Qualifier("churchill") String message) {
    this.message = message;
  }

  @FunctionName("hello")
  public HttpResponseMessage execute(
      @HttpTrigger(name = "request", methods = {HttpMethod.GET,
          HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {
    log.info("Azure function invoked");

    return request.createResponseBuilder(HttpStatus.OK)
        .body(message)
        .build();
  }

}
