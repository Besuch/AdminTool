package ua.Light.shop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.Light.shop.services.ProductService;
import ua.Light.shop.services.UserService;
import ua.Light.shop.services.dto.ProductDto;
import ua.Light.shop.services.dto.UserDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new GenericXmlApplicationContext("context-main.xml");
        UserService userService = context.getBean(UserService.class);
        ProductService productService = context.getBean(ProductService.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = reader.readLine();
            String[] arguments = input.split(" ");

            if ("UC".equals(arguments[0])){
                UserDto dto = new UserDto(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
                userService.create(dto);
                System.out.println("user has been create succesfull");
            } else if ("UL".equals(arguments[0])){
                System.out.println("List of users:");
                System.out.println(userService.findAll());
            }else if ("PC".equals((arguments[0]))){
                ProductDto dto = new ProductDto(
                        arguments[1], arguments[2], arguments[3], arguments[4],
                        Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]));
                productService.create(dto);
                System.out.println("product has been create succesfull");
            }else if ("PL".equals(arguments[0])){
                System.out.println("List of products:");
                System.out.println(productService.getAll());
            }
        }



    }
}
