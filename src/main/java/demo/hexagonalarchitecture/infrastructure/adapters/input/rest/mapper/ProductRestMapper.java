package demo.hexagonalarchitecture.infrastructure.adapters.input.rest.mapper;

import demo.hexagonalarchitecture.domain.model.Product;
import demo.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import demo.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import demo.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);

}
