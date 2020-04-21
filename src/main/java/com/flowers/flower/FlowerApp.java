package com.flowers.flower;

import com.flowers.flower.dao.CareRepository;
import com.flowers.flower.dao.FamilyRepository;
import com.flowers.flower.dao.FlowerRepository;
import com.flowers.flower.entities.Care;
import com.flowers.flower.entities.Family;
import com.flowers.flower.entities.Flower;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class FlowerApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(FlowerApp.class);
        FlowerRepository flowerRepository = context.getBean(FlowerRepository.class);
        FamilyRepository familyRepository = context.getBean(FamilyRepository.class);
        CareRepository careRepository = context.getBean(CareRepository.class);

        List<Care> cares = new ArrayList<>();
        Collections.addAll(cares,
                new Care("Влаголюбивые"),
                new Care("Засухоустойчивые"),
                new Care("Светолюбивые"),
                new Care("Теневыносливые"),
                new Care("Теплолюбивые"),
                new Care("Морозоустойчивые")
        );

        List<Family> families = new ArrayList<>();
        Collections.addAll(families,
                new Family("Пальмовые", cares.get(0)),
                new Family("Тутовые", cares.get(0)),
                new Family("Кактусовые", cares.get(1)),
                new Family("Асфоделовые", cares.get(1)),
                new Family("Бегониевые", cares.get(2)),
                new Family("Спаржевые", cares.get(2)),
                new Family("Ужовниковые", cares.get(3)),
                new Family("Ароидные", cares.get(3)),
                new Family("Розовые", cares.get(4)),
                new Family("Толстянковые", cares.get(4)),
                new Family("Вечнозеленые", cares.get(5)),
                new Family("Кипарисовые", cares.get(5))
        );

        for (int i = 0; i < cares.size() - 1; i++) {
            cares.get(i).setFamilies(families.subList(2 * i, 2 * i + 2));
        }
        List<Family> families1 = new ArrayList<>();
        families1.add(families.get(10));
        families1.add(families.get(11));
        cares.get(5).setFamilies(families1);

        List<Flower> flowers = new ArrayList<>();
        Collections.addAll(flowers,
                new Flower("Ховея", families.get(0), "img/Ховея.jpg", "Нет", 500),
                new Flower("Фикус Бенджамин", families.get(1), "img/Фикус Бенджамин.jpg", "Нет", 600),
                new Flower("Астрофитум", families.get(2), "img/Астрофитум.jpg", "Белый", 1200),
                new Flower("Алоэ вера", families.get(3), "img/Алоэ вера.jpg", "Нет", 700),
                new Flower("Декоративно-лиственная бегония", families.get(4), "img/Декоративно-лиственная бегония.png", "Нет", 400),
                new Flower("Драцена", families.get(5), "img/Драцена.jpg", "Нет", 750),
                new Flower("Адиантум — венерин волос", families.get(6), "img/Адиантум.jpg", "Нет", 1000),
                new Flower("Замиокулькас, долларовое дерево", families.get(7), "img/Замиокулькас.jpg", "Нет", 600),
                new Flower("Чайная роза", families.get(8), "img/Чайная роза Ж.jpg", "Желтый", 300),
                new Flower("Чайная роза", families.get(8), "img/Чайная роза Р.jpg", "Розовый", 300),
                new Flower("Каланхое", families.get(9), "img/Каланхое.jpg", "Розовый", 950),
                new Flower("Вереск", families.get(10), "img/Вереск.jpg", "Фиолетовый", 500),
                new Flower("Можжевельник", families.get(11), "img/Можжевельник.jpg", "Нет", 800)
        );

        for (int i = 0; i < 8; i++) {
            families.get(i).setFlowers(flowers.subList(i, i + 1));
        }
        families.get(8).setFlowers(flowers.subList(8, 10));
        families.get(9).setFlowers(flowers.subList(10, 11));
        families.get(10).setFlowers(flowers.subList(11, 12));
        List<Flower> flowers1 = new ArrayList<>();
        flowers1.add(flowers.get(12));
        families.get(11).setFlowers(flowers1);

        for (Care care : cares) {
            careRepository.save(care);
        }
        for (Family f : families) {
            familyRepository.save(f);
        }
        for (Flower flower : flowers) {
            flowerRepository.save(flower);
        }
    }
}
