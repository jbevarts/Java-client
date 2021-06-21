package feign;

import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String responseBody = StringUtils.EMPTY;

        try {
            if (null != response.body()) {
                responseBody = IOUtils.toString(response.body().asReader());
            } else {
                responseBody = "Upstream system returned failure without response body";
            }
        } catch (IOException e) {
            // No handle
        }

        if (response.status() >= 400 && response.status() < 500) {
            return new Exception("_invalid_request with response status " + response.status());
        } else {
            return new Exception("_system_error with response status " + response.status());
        }

    }
}
