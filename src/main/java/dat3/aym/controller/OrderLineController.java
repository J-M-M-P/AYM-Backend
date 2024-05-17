package dat3.aym.controller;

import dat3.aym.dto.OrderLineDto;
import dat3.aym.entity.OrderLine;
import dat3.aym.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orderlines")
public class OrderLineController {

    @Autowired
    OrderLineService orderLineService;

    @GetMapping("")
    public List<OrderLineDto> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    //Get orderline based on id
    @GetMapping("/{id}")
    public OrderLineDto getOrderLineById(@PathVariable int id) {
        return orderLineService.getOrderLineById(id);
    }

    //Post orderline to database
    @PostMapping("")
    public OrderLine addOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineService.createOrderLine(orderLine);
    }

    //Update orderline in database
    @PutMapping("/{id}")
    public OrderLine updateOrderLine(@PathVariable int id, @RequestBody OrderLine orderLine) {
        return orderLineService.updateOrderLine(id, orderLine);
    }

    //Delete orderline in database
    @DeleteMapping("/{id}")
    public String deleteOrderLine(@PathVariable int id) {
        orderLineService.deleteOrderLine(id);
        return "Orderline with ID: " + id + " has been deleted";
    }

}
