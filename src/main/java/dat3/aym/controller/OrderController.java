package dat3.aym.controller;

import dat3.aym.dto.OrderDto;
import dat3.aym.entity.Order;
import dat3.aym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    //Get all orders
    @GetMapping("")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    //Get order based on id
    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    //Post order to database
    @PostMapping("")
    public Order addOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    //Update order in database
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    //Delete order in database
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order with ID: " + id + " has been deleted";
    }

}
