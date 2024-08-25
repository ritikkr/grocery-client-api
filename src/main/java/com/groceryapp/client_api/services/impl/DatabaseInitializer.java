package com.groceryapp.client_api.services.impl;

import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.model.Product;
import com.groceryapp.client_api.model.Role;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.repository.CategoryRepository;
import com.groceryapp.client_api.repository.ProductRepository;
import com.groceryapp.client_api.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DatabaseInitializer {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private List<String> initialCategories = Arrays.asList("Dairy", "Medicine",
            "Namkeen & Biscuits", "Stationary", "Beverages" , "Personal Care" );

    @PostConstruct
    public void initialize(){
        feedCategoryDatabase();
        feedUserDatabase();
        feedProductDatabase();
    }

    public void feedCategoryDatabase(){
        List<Category> categories = new ArrayList<>();
        for(String category: initialCategories){
            if(categoryRepository.findByName(category).isEmpty()){
                categories.add(Category.builder()
                        .name(category)
                        .build());
            }
        }
        categoryRepository.saveAll(categories);

    }

    public void feedUserDatabase(){
        if(userRepository.findByEmail("admin@email.com").isEmpty()){
            userRepository.save(
                    User.builder()
                            .firstName("admin")
                            .lastName("")
                            .role(Role.ADMIN)
                            .email("admin@email.com")
                            .password(passwordEncoder.encode("admin123"))
                            .build()
            );
        }

    }

    public void feedProductDatabase(){
        List<Product> productList = new ArrayList<>();

            productList.add(
                    Product.builder()
                            .name("Milk")
                            .brand("Amul")
                            .rating(4.2)
                            .price(new BigDecimal(27))
                            .discountPercent(new BigDecimal(20))
                            .description("Calcium Rich protein")
                            .imageUrl("https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=900/app/assets/products/sliding_images/jpeg/1c0db977-31ab-4d8e-abf3-d42e4a4b4632.jpg?ts=1706182142")
                            .stockQuantity(20L)
                            .category(categoryRepository.findByName(initialCategories.get(0)).get())
                    .build()
            );



        productList.add(
                Product.builder()
                        .name("Paneer")
                        .brand("Heritage")
                        .rating(4.5)
                        .price(new BigDecimal(27))
                        .discountPercent(new BigDecimal(18))

                        .description("High  protein")
                        .imageUrl("https://www.jiomart.com/images/product/original/490319577/heritage-paneer-200-g-pouch-product-images-o490319577-p490319577-0-202203170527.jpg?im=Resize=(420,420)")
                        .stockQuantity(20L)
                        .category(categoryRepository.findByName(initialCategories.get(0)).get())
                        .build()
        );


        productList.add(
                Product.builder()
                        .name("Paracetamol")
                        .brand("Medicpore")
                        .rating(3.8)
                        .price(new BigDecimal(27))
                        .discountPercent(new BigDecimal(12))

                        .description("Fever")
                        .imageUrl("https://5.imimg.com/data5/SELLER/Default/2021/6/AC/ZD/LY/122822982/85513-1-1000-500x500.jpg")
                        .stockQuantity(20L)
                        .category(categoryRepository.findByName(initialCategories.get(1)).get())
                        .build()
        );

        productList.add(
                Product.builder()
                        .name("Levocitrazine")
                        .brand("Meloncisy")
                        .rating(4.0)
                        .price(new BigDecimal(27))
                        .discountPercent(new BigDecimal(2))

                        .description("Allergy")
                        .imageUrl("https://5.imimg.com/data5/SELLER/Default/2024/2/382823352/BX/VG/QY/109604861/levocetirizine-dihydrochloride-tablets.jpg")
                        .stockQuantity(400L)
                        .category(categoryRepository.findByName(initialCategories.get(1)).get())
                        .build()
        );

        productList.add(
                Product.builder()
                        .name("Parle Gold")
                        .brand("Parle")
                        .rating(4.6)
                        .price(new BigDecimal(27))
                        .discountPercent(new BigDecimal(9))

                        .description(" Biscuits")
                        .imageUrl("https://kumaribasket.com/wp-content/uploads/2020/10/Parle-%E2%80%93-G-Gold-Biscuits2.jpg")
                        .stockQuantity(400L)
                        .category(categoryRepository.findByName(initialCategories.get(2)).get())
                        .build()
        );

        productList.add(
                Product.builder()
                        .name("Aloo Bhujia")
                        .brand("Bikaji")
                        .rating(4.2)
                        .discountPercent(new BigDecimal(22))

                        .price(new BigDecimal(27))
                        .description("Tasty Aloo bhujia")
                        .imageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3kxHQlR7_3p4xB7iSe-oepCKgjgxXUIRuWQ&s")
                        .stockQuantity(400L)
                        .category(categoryRepository.findByName(initialCategories.get(2)).get())
                        .build()
        );

        productList.add(
                Product.builder()
                        .name("Blue Pen")
                        .brand("Doms")
                        .rating(4.2)
                        .discountPercent(new BigDecimal(15))

                        .price(new BigDecimal(27))
                        .description("Blue ball pen")
                        .imageUrl("https://www.submarinepens.com/cdn/shop/files/Black1_9bef5d3a-1c4a-480e-9223-7a5604c53148.jpg?v=1704542825")
                        .stockQuantity(400L)
                        .category(categoryRepository.findByName(initialCategories.get(3)).get())
                        .build()
        );

        productList.add(
                Product.builder()
                        .name("A4 Copy Pen")
                        .brand("Hauser")
                        .discountPercent(new BigDecimal(7))

                        .rating(4.2)
                        .price(new BigDecimal(27))
                        .description("Textbook")
                        .imageUrl("https://www.mystore.in/s/62ea2c599d1398fa16dbae0a/64c2f80ada9800b73f8317e1/61hhcallcul.jpg")
                        .stockQuantity(400L)
                        .category(categoryRepository.findByName(initialCategories.get(3)).get())
                        .build()
        );

        // Beverages
        productList.add(Product.builder()
                .name("Juice")
                .brand("Tropicana")
                .rating(4.2)
                .price(new BigDecimal(24))
                .discountPercent(new BigDecimal(8))
                .description("Orange juice")
                .imageUrl("https://m.media-amazon.com/images/I/714kIox4UzL.jpg") // Replace with actual image URL
                .stockQuantity(200L)
                .category(categoryRepository.findByName(initialCategories.get(4)).get())
                .build());

        productList.add(Product.builder()
                .name("Soda")
                .brand("Coca-Cola")
                .rating(4.0)
                .price(new BigDecimal(1))
                .discountPercent(new BigDecimal(3))
                .description("Classic cola")
                .imageUrl("https://5.imimg.com/data5/SELLER/Default/2023/9/341372302/SC/BB/OF/142165623/1-25-l-coca-cola-juice-500x500.jpg") // Replace with actual image URL
                .stockQuantity(400L)
                .category(categoryRepository.findByName(initialCategories.get(4)).get())
                .build());


        // Personal Care
        productList.add(Product.builder()
                .name("Shampoo")
                .brand("Head & Shoulders")
                .rating(4.7)
                .price(new BigDecimal(5))
                .discountPercent(new BigDecimal(12))
                .description("Anti-dandruff shampoo")
                .imageUrl("https://www.bigbasket.com/media/uploads/p/l/267845_11-head-shoulders-anti-dandruff-shampoo-cool-menthol-energizes-scalp.jpg") // Replace with actual image URL
                .stockQuantity(200L)
                .category(categoryRepository.findByName(initialCategories.get(5)).get())
                .build());

        productList.add(Product.builder()
                .name("Toothpaste")
                .brand("Colgate")
                .rating(4.6)
                .price(new BigDecimal(3))
                .discountPercent(new BigDecimal(7))
                .description("Cavity protection toothpaste")
                .imageUrl("https://images.apollo247.in/pub/media/catalog/product/D/A/DAB0441_1-JULY23_1.jpg") // Replace with actual image URL
                .stockQuantity(300L)
                .category(categoryRepository.findByName(initialCategories.get(5)).get())
                .build());


        productRepository.saveAll(productList);

    }



}
