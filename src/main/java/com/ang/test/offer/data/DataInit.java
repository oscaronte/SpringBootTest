package com.ang.test.offer.data;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ang.test.offer.domain.Offer;
import com.ang.test.offer.domain.Product;
import com.ang.test.offer.repository.OfferRepository;
import com.ang.test.offer.repository.ProductRepository;

@Component
public class DataInit implements ApplicationRunner {

    private ProductRepository productRepository;
    private OfferRepository offerRepository;
    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    @Autowired
    public DataInit(ProductRepository productRepository, OfferRepository offerRepository) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        List<Product> prods = new ArrayList<>();
        prods.add(new Product(null, "Playstation 4 PRO", BigDecimal.valueOf(500d)));
        prods.add(new Product(null, "Playstation 4", BigDecimal.valueOf(300d)));
        prods.add(new Product(null, "XBox ONE", BigDecimal.valueOf(280d)));
        prods.add(new Product(null, "Nintendo Switch", BigDecimal.valueOf(480d)));
        prods.add(new Product(null, "Nintendo Switch 1.1", BigDecimal.valueOf(580d)));
        prods.add(new Product(null, "NES Mini", BigDecimal.valueOf(100d)));
        productRepository.saveAll(prods);

        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer(null, new BigDecimal("0.20"), df.parse("09/01/2019"), df.parse("09/22/2019"), prods.get(1)));
        offers.add(new Offer(null, new BigDecimal("0.60"), df.parse("09/10/2019"), df.parse("09/15/2019"), prods.get(5)));
        offers.add(new Offer(null, new BigDecimal("0.30"), df.parse("08/15/2019"), df.parse("10/02/2019"), prods.get(3)));
        offers.add(new Offer(null, new BigDecimal("0.30"), df.parse("08/20/2019"), df.parse("08/22/2019"), prods.get(0)));
        offers.add(new Offer(null, new BigDecimal("0.10"), df.parse("11/20/2019"), df.parse("11/22/2019"), prods.get(4)));
        offerRepository.saveAll(offers);
    }
}
