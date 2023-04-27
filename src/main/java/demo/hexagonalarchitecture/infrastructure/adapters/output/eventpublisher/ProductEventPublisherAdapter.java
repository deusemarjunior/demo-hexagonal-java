package demo.hexagonalarchitecture.infrastructure.adapters.output.eventpublisher;

import demo.hexagonalarchitecture.application.ports.output.ProductEventPublisher;
import demo.hexagonalarchitecture.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
