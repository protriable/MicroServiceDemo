package com.protry;

import com.protry.db.ProductDetailRepository;
import com.protry.entity.ProductDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        ProductDetail detail = new ProductDetail();
        detail.setProductId("ABCD1234");
        detail.setProductName("Dan's Book of Writing");
        detail.setShortDescription("A book about writing books.");
        detail.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
        detail.setInventoryId("009178461");
        ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
        repository.save(detail);
        for (ProductDetail productDetail : repository.findAll()) {
            System.out.println(productDetail.getProductId());
        }
    }
}
