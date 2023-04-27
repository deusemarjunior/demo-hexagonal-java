package demo.hexagonalarchitecture.infrastructure.adapters.config;

import demo.hexagonalarchitecture.domain.service.ProductService;
import demo.hexagonalarchitecture.infrastructure.adapters.output.eventpublisher.ProductEventPublisherAdapter;
import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import demo.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }

}
