package com.tsaplev.backend.initializers;

import com.tsaplev.backend.repositories.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsaplev.backend.entities.Department;
import com.tsaplev.backend.entities.Barber;

import jakarta.annotation.PostConstruct;

@Component
public class BarberInitializer {
    @Autowired
    private BarberRepository barberRepository;

    @PostConstruct
    public void init() {
        // department 1 
        Department dep1 = new Department();
        dep1.setId((long)(1));

        Barber doc1 = new Barber();
        doc1.setBarbername("Ултас Исмаглы");
        doc1.setDepartment(dep1);

        Barber doc2 = new Barber();
        doc2.setBarbername("Баржакбил Нияев");
        doc2.setDepartment(dep1);

        Barber doc3 = new Barber();
        doc3.setBarbername("Абдаренше Ахмететов");
        doc3.setDepartment(dep1);

        barberRepository.save(doc1);
        barberRepository.save(doc2);
        barberRepository.save(doc3);

        // department 2
        Department dep2 = new Department();
        dep2.setId((long)(2));

        Barber doc4 = new Barber();
        doc4.setBarbername("Монлетияр Есимбай");
        doc4.setDepartment(dep2);

        Barber doc5 = new Barber();
        doc5.setBarbername("Азамназ Сериаев");
        doc5.setDepartment(dep2);

        Barber doc6 = new Barber();
        doc6.setBarbername("Архлетияр Ашиетов");
        doc6.setDepartment(dep2);

        barberRepository.save(doc4);
        barberRepository.save(doc5);
        barberRepository.save(doc6);

        // department 3
        Department dep3 = new Department();
        dep3.setId((long)(3));

        Barber doc7 = new Barber();
        doc7.setBarbername("Жарфу Омарлаев");
        doc7.setDepartment(dep3);

        Barber doc8 = new Barber();
        doc8.setBarbername("Насуп Валимов");
        doc8.setDepartment(dep3);

        Barber doc9 = new Barber();
        doc9.setBarbername("Есназа Идрибеков");
        doc9.setDepartment(dep3);

        barberRepository.save(doc7);
        barberRepository.save(doc8);
        barberRepository.save(doc9);
    }
}
