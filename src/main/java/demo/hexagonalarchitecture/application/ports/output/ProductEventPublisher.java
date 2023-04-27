package demo.hexagonalarchitecture.application.ports.output;

import demo.hexagonalarchitecture.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {

    void publishProductCreatedEvent(ProductCreatedEvent event);

}
