package by.myself.controller;

import by.myself.entities.Shop;
import by.myself.service.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @ModelAttribute
    public List<Shop> shops() {
        List<Shop> shops = new ArrayList<>();
        shopRepository.findAll().forEach(shops::add);
        return shops;
    }

    @GetMapping("/contact/shop")
    public String showShopPage() {
        return "contact/shop";
    }
}
