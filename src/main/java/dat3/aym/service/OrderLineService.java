package dat3.aym.service;

import dat3.aym.dto.OrderLineDto;
import dat3.aym.entity.OrderLine;
import dat3.aym.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


}
