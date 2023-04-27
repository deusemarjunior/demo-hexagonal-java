package demo.hexagonalarchitecture.application.ports.output;

import demo.hexagonalarchitecture.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);

}
