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
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;



public class HelloHandler extends FunctionInvoker<String, String> {

  @FunctionName("aphorism")
  public HttpResponseMessage execute(
      @HttpTrigger(name = "request", methods = {HttpMethod.GET,
          HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {

    String message = handleRequest("", context);

    return request.createResponseBuilder(HttpStatus.OK)
        .body(message)
        .build();
  }

}
