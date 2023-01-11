package com.swcoaching.example1.user;

import com.swcoaching.example1.user.jpa.UserEntity;
import com.swcoaching.example1.user.jpa.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @DisplayName("ID로 회원 조회 한다")
    @Test
    void findByUsername() {
        // given
        UserEntity userEntity = mock(UserEntity.class);
        UserRepository userRepository = mock(UserRepository.class);

        long testMemberId = 1L;
        String testUserEmail = "test@test.com";
        String testUserUsername = "testUsername";
        String testUserPassword = "testPassword";
        String testUserName = "테스트 회원명";
        String testIntroduction = "회원 소개";

        when(userEntity.getId()).thenReturn(testMemberId);
        when(userEntity.getEmail()).thenReturn(testUserEmail);
        when(userEntity.getUsername()).thenReturn(testUserUsername);
        when(userEntity.getPassword()).thenReturn(testUserPassword);
        when(userEntity.getName()).thenReturn(testUserName);
        when(userEntity.getIntroduction()).thenReturn(testIntroduction);

        when(userRepository.findByUsername(testUserUsername)).thenReturn(userEntity);

        // when
        UserService userService = new UserServiceImpl(userRepository);
        User user = userService.findByUsername(testUserUsername);

        // then
        assertEquals(user.getId(), testMemberId);
        assertEquals(user.getEmail(), testUserEmail);
        assertEquals(user.getUsername(), testUserUsername);
        assertEquals(user.getPassword(), testUserPassword);
        assertEquals(user.getName(), testUserName);
        assertEquals(user.getIntroduction(), testIntroduction);
    }
}
