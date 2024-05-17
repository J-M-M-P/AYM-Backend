package dat3.aym.service;

import dat3.aym.dto.OrderDto;
import dat3.aym.entity.Order;
import dat3.aym.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //Get all orders
    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (Order order : orderList) {
            orderDtoList.add(new OrderDto(order));
        }

        return orderDtoList;
    }

    //Get order by id
    public OrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return new OrderDto(order);
    }

    //Create order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    //Delete order
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    // Update order
    public Order updateOrder(int orderId, Order updatedOrder) {
        // Check if order with that ID exists in database
        Optional<Order> existingOrderOptional = orderRepository.findById(orderId);

        if (existingOrderOptional.isPresent()) {
            // If order exists, update the rest of the properties
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setCreated(updatedOrder.getCreated());
            existingOrder.setShipped(updatedOrder.isShipped());
            existingOrder.setUser(updatedOrder.getUser()); // Update whole user, not just username(?)

            // Save updated order in database
            return orderRepository.save(existingOrder);
        } else {
            // If order does not exist in database, throw error
            throw new RuntimeException("Order with ID: " + orderId + " not found");
        }
    }

}
