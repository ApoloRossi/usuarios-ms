package br.com.sempreva.usuarios.service;

import br.com.sempreva.usuarios.dto.UserDto;
import br.com.sempreva.usuarios.model.User;
import br.com.sempreva.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<UserDto> getUsers(Pageable pagination) {
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, UserDto.class));
    }

    public UserDto getUserById(Long id) {
        User user = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(user, UserDto.class);

    }

    public UserDto createUser(UserDto newUser) {

        User user = modelMapper.map(newUser, User.class);

        repository.save(user);

        return modelMapper.map(user, UserDto.class);

    }

    public UserDto updateUser(Long id, UserDto newUser) {

        User user = modelMapper.map(newUser, User.class);
        user.setId(id);

        user = repository.save(user);

        return modelMapper.map(user, UserDto.class);

    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

}
