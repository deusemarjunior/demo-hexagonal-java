package demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper;

import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import demo.hexagonalarchitecture.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}
