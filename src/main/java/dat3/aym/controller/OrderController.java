package dat3.aym.controller;

import dat3.aym.dto.CategoryDto;
import dat3.aym.dto.OrderDto;
import dat3.aym.entity.Category;
import dat3.aym.entity.OrderEntity;
import dat3.aym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    //Get all colors
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
    public OrderEntity addOrder(@RequestBody OrderEntity order) {
        return orderService.createOrder(order);
    }

    //Update order in database
    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable int id, @RequestBody OrderEntity order) {
        return orderService.updateOrder(id, order);
    }

    //Delete order in database
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order with ID: " + id + " has been deleted";
    }

}
