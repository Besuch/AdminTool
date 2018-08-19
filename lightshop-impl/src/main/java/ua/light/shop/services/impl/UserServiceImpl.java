package ua.light.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.light.shop.entity.User;
import ua.light.shop.dao.UserDao;
import ua.light.shop.services.UserService;
import ua.light.shop.services.convertors.UserConvertor;
import ua.light.shop.services.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

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
        entity.setId(id);
        userDao.update(entity);
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();
        return users.stream().map(userConvertor::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return userConvertor.toDto(userDao.get(id));
    }
}