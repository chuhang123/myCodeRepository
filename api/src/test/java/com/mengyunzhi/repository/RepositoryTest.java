package com.mengyunzhi.repository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by chuhang on 17-11-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public abstract class RepositoryTest {
}
