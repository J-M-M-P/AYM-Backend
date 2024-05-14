package dat3.aym.controller;

import dat3.aym.dto.OrderDto;
import dat3.aym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
