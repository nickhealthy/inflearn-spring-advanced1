package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0_1 {

    private final OrderRepositoryV0_1 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
