package dat3.aym.service;

import dat3.aym.dto.OrderDto;
import dat3.aym.entity.OrderEntity;
import dat3.aym.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //Get all orders
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (OrderEntity order : orderList) {
            orderDtoList.add(new OrderDto(order));
        }

        return orderDtoList;
    }
}
