package dat3.aym.service;

import dat3.aym.dto.CategoryDto;
import dat3.aym.dto.OrderLineDto;
import dat3.aym.entity.Category;
import dat3.aym.entity.OrderLine;
import dat3.aym.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    //Get all orderlines
    public List<OrderLineDto> getAllOrderLines() {
        List<OrderLine> orderLineList = orderLineRepository.findAll();
        List<OrderLineDto> orderLineDtoList = new ArrayList<>();

        for (OrderLine orderLine : orderLineList) {
            orderLineDtoList.add(new OrderLineDto(orderLine));
        }

        return orderLineDtoList;
    }

    //Get orderline by id
    public OrderLineDto getOrderLineById(int id) {
        OrderLine orderLine = orderLineRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "OrderLine not found"));
        return new OrderLineDto(orderLine);
    }

    //Create orderLine
    public OrderLine createOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    //Delete orderLine
    public void deleteOrderLine(int orderLineId) {
        orderLineRepository.deleteById(orderLineId);
    }

    //Update orderLine
    public OrderLine updateOrderLine(int orderLineId, OrderLine updatedOrderLine) {
        // Check if orderLine with that ID exists in database
        Optional<OrderLine> existingOrderLineOptional = orderLineRepository.findById(orderLineId);

        if (existingOrderLineOptional.isPresent()) {
            // If orderLine exists, update the rest of the properties
            OrderLine existingOrderLine = existingOrderLineOptional.get();
            existingOrderLine.setQty(updatedOrderLine.getQty());

            // Save updated color in database
            return orderLineRepository.save(existingOrderLine);
        } else {
            // If color does not exist in database, throw error
            throw new RuntimeException("Category with ID: " + orderLineId + " not found");
        }
    }


}
