package ua.light.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.light.shop.dao.model.User;
import ua.light.shop.dao.repositories.UserDao;
import ua.light.shop.services.UserService;
import ua.light.shop.services.convertors.UserConvertor;
import ua.light.shop.services.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserConvertor userConvertor;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserConvertor userConvertor) {
        this.userDao = userDao;
        this.userConvertor = userConvertor;
    }

    @Transactional
    public void create(UserDto user) {
        User userEntity = userConvertor.toEntity(user);
        userDao.create(userEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, UserDto user) {
        User entity = userConvertor.toEntity(user);
        userDao.update(id, entity);
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto dto = userConvertor.toDto(user);
            userDtos.add(dto);
        }
        return userDtos;
    }

    @Override
    public UserDto findById(Long id) {
        return userConvertor.toDto(userDao.get(id));
    }
}