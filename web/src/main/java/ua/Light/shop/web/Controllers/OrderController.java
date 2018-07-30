package ua.Light.shop.web.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.Light.shop.services.OrderService;
import ua.Light.shop.services.dto.OrderDto;
import ua.Light.shop.services.dto.ProductDto;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    public final static Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<OrderDto> findAll(){
        log.info("Find all users {}", orderService.findAll());
        return orderService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public @ResponseBody OrderDto findById(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrderDto order){
        log.info("Create order {}", order);
        orderService.create(order);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        orderService.delete(id);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id,@RequestBody OrderDto order){
        orderService.update(id, order);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll(){
        orderService.deleteAll();

    }
}
