package com.example.restapi_ex.service;

import com.example.restapi_ex.entity.ItemEntity;
import com.example.restapi_ex.controller.model.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class RestExService {

//    private final ItemRepository itemRepository;
    @Autowired
    private final SessionFactory sessionFactory;

    public boolean registerItem(ItemDto itemDto){
        //dto -> entity
        ItemEntity entity = new ItemEntity();
        entity.setId(itemDto.getId());
        entity.setName(itemDto.getName());

        // DB insert
//        var itemEntity = itemRepository.save(entity);
//        log.info("save item entity: " + itemEntity);

        // Hibernate Session 사용해서 데이터 저장
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        var saveEntity = session.save(entity);
        session.getTransaction().commit();
        session.clear();

        log.info("save item entity: " + saveEntity);

        return true; // DB insert 성공했을 경우 true
    }

}
