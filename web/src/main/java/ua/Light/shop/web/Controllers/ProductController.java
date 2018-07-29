package ua.Light.shop.web.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.Light.shop.services.ProductService;
import ua.Light.shop.services.dto.ProductDto;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    public final static Logger log = LoggerFactory.getLogger(UserController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDto> findAll(){
        log.info("Find all users {}", productService.findAll());
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public @ResponseBody ProductDto findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductDto product){
        log.info("Create product {}", product);
        productService.create(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id,@RequestBody ProductDto product){
        productService.update(id, product);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll(){
        productService.deleteAll();

    }
}
