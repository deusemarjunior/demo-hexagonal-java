package demo.hexagonalarchitecture.application.ports.input;

import demo.hexagonalarchitecture.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);

}
