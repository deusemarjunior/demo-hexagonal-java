package demo.hexagonalarchitecture.domain.service;

import demo.hexagonalarchitecture.application.ports.input.GetProductUseCase;
import demo.hexagonalarchitecture.application.ports.output.ProductEventPublisher;
import demo.hexagonalarchitecture.application.ports.output.ProductOutputPort;
import demo.hexagonalarchitecture.domain.event.ProductCreatedEvent;
import demo.hexagonalarchitecture.domain.exception.ProductNotFound;
import demo.hexagonalarchitecture.domain.model.Product;
import demo.hexagonalarchitecture.application.ports.input.CreateProductUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }

}
