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
import lombok.RequiredArgsConstructor;
import org.enricogiurin.poc.sbai.component.AphorismGenerator;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class HelloHandler {

  private final AphorismGenerator aphorismGenerator;

  @FunctionName("egch-aphorism")
  public HttpResponseMessage execute(
      @HttpTrigger(name = "request", methods = {HttpMethod.GET,
          HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {

    String message = aphorismGenerator.apply("");

    return request.createResponseBuilder(HttpStatus.OK)
        .body(message)
        .build();
  }

}
