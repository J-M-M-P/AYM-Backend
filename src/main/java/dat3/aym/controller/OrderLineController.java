package dat3.aym.controller;

import dat3.aym.dto.CategoryDto;
import dat3.aym.dto.OrderLineDto;
import dat3.aym.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
