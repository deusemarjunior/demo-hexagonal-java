package demo.hexagonalarchitecture.infrastructure.adapters.output.persistence;

import demo.hexagonalarchitecture.application.ports.output.ProductOutputPort;
import demo.hexagonalarchitecture.domain.model.Product;
import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

}
