package com.hn.springbootmobilestore.config;

import com.hn.springbootmobilestore.entity.*;
import com.hn.springbootmobilestore.repository.CategoryRepository;
import com.hn.springbootmobilestore.repository.ProductRepository;
import com.hn.springbootmobilestore.repository.RoleRepository;
import com.hn.springbootmobilestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //Category
//        if(categoryRepository.findByName("Iphone") == null){
//            categoryRepository.save(new Category("Iphone"));
//        }
        //Product
//        Category cate = new Category("Iphone");
//        Product product = new Product();
//        product.setProductName("abcd");
//        product.setCategory(cate);
//        cate.setProducts(Collections.singleton(product));
//        categoryRepository.saveAndFlush(cate);

        // Roles
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }

        // Admin account
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByUsername("member") == null) {
            User user = new User();
            user.setUsername("member");
            user.setPassword(passwordEncoder.encode("123"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }

    }
}