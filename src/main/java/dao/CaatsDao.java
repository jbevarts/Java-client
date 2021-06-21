package dao;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface CaatsDao {
    @RequestLine("GET /api/tags")
    @Headers({"Content-Type: application/json", "Accept: application/json" })
    Object fetchCatTags();
}
