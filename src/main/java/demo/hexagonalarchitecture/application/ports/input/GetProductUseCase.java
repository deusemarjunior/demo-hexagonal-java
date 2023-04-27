package demo.hexagonalarchitecture.application.ports.input;

import demo.hexagonalarchitecture.domain.model.Product;

public interface GetProductUseCase {

    Product getProductById(Long id);

}
