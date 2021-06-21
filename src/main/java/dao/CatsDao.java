package dao;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface CatsDao {
    @RequestLine("GET /facts/random?animal_type={catType}&amount={quantity}")
    @Headers({"Content-Type: application/json", "Accept: application/json" })
    Object fetchCatFacts(@Param("catType") String catType, @Param("quantity") int quantity);
}
