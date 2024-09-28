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
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;


@Slf4j
public class HelloHandler extends FunctionInvoker<String, String> {


  @FunctionName("uppercase")
  public HttpResponseMessage execute(
      @HttpTrigger(name = "request", methods = {HttpMethod.GET,
          HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {
    log.info("Azure function invoked");

    return request.createResponseBuilder(HttpStatus.OK)
        .body(handleRequest("so stanco", context))
        .build();
  }

}
