package com.example.webwork.config;

import com.example.webwork.constants.CategoryEnum;
import com.example.webwork.constants.EngineEnum;
import com.example.webwork.constants.RoleEnum;
import com.example.webwork.constants.TransmissionEnum;
import com.example.webwork.dtos.*;
import com.example.webwork.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleService roleService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final UsersService usersService;
    private final OfferService offerService;
    public DataInitializer(RoleService roleService, BrandService brandService, ModelService modelService,
                           UsersService usersService, OfferService offerService) {
        this.roleService = roleService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.usersService = usersService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args){
        seedData();
    }

    private void seedData() {
        RoleDto role1 = new RoleDto(null, RoleEnum.Admin);
        RoleDto role2 = new RoleDto(null, RoleEnum.User);
        role1 = roleService.registerRole(role1);
        role2 = roleService.registerRole(role2);

        LocalDateTime created1 = LocalDateTime.now();
        LocalDateTime created2 = LocalDateTime.of(2019, 10, 1, 9, 0, 0);
        LocalDateTime modified1 = LocalDateTime.of(2023, 5, 10, 18, 0, 0);
        LocalDateTime modified2 = LocalDateTime.of(2022, 5, 10, 18, 0, 0);

        BrandDto brand1 = new BrandDto(null, "BMW", created1, modified1);
        BrandDto brand2 = new BrandDto(null, "Mersedes", created2, modified2);
        brand1 = brandService.registerBrand(brand1);
        brand2 = brandService.registerBrand(brand2);

        ModelDto model1 = new ModelDto(null, brand2, "EQS", CategoryEnum.Car,
                "https://www.sim-autopro.ru/upload/img/64a4085f9217e.jpg",
                2018, 2023, created1, modified2);
        ModelDto model2 = new ModelDto(null, brand1, "S1000RR", CategoryEnum.Motorcycle,
                "https://autogazette.de/wp-content/uploads/2019/03/BMW-S-1000-RR.jpg",
                2008, 2014, created2, modified2);
        model1 = modelService.registerModel(model1);
        model2 = modelService.registerModel(model2);

        UsersDto user1 = new UsersDto(null, role1, "Viatly228", "1234567890", "Vitaly",
                "Irvanev", true, "http://jjejfbejbf", created1, modified1);
        UsersDto user2 = new UsersDto(null, role2, "AngryL1on", "0987654321", "Vadim",
                "Lushin", true, "http://bebfebufbe", created2, modified2);
        user1 = usersService.registerUser(user1);
        user2 = usersService.registerUser(user2);

        BigDecimal price1 = new BigDecimal(24000000);
        BigDecimal price2 = new BigDecimal(3150000);

        OfferDto offer1 = new OfferDto(null, model1, user2, "Cool car", EngineEnum.ELECTRIC,
                "http://uebubfueb", 20, price1, TransmissionEnum.AUTOMATIC, 2022, created1, modified2);
        OfferDto offer2 = new OfferDto(null, model2, user1, "Cool Motorcycle", EngineEnum.GASOLINE,
                "http://hewbfhbvehf", 2, price2, TransmissionEnum.AUTOMATIC, 2022, created2, modified2);
        offerService.registerOffer(offer1);
        offerService.registerOffer(offer2);
    }
}