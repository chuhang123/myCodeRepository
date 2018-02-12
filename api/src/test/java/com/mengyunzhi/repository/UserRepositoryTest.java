package com.mengyunzhi.repository;

import com.mengyunzhi.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by chuhang on 17-11-29
 */
public class UserRepositoryTest extends RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        User user = new User();
        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }


}