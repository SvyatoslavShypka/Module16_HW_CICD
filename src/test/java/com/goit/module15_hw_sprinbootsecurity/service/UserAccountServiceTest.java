package com.goit.module15_hw_sprinbootsecurity.service;

import com.goit.module15_hw_sprinbootsecurity.dto.UserAccountDto;
import com.goit.module15_hw_sprinbootsecurity.entity.UserAccountEntity;
import com.goit.module15_hw_sprinbootsecurity.mapper.AccountMapper;
import com.goit.module15_hw_sprinbootsecurity.repository.UserAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {
    private static final String TEST_USERNAME = "super_admin@gmail.com";

    @Mock
    private UserAccountRepository userAccountRepository;
    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private UserAccountService userAccountService;

    @Test
    void loadUserByUsername() {
        //GIVEN
        UserAccountEntity accountEntity = createTestAccount();
        UserAccountDto expectedAccount = createTestAccountDto(accountEntity);
        //WHEN
        Mockito.when(userAccountRepository.findUserAccountEntityByUsername(TEST_USERNAME)).thenReturn(accountEntity);
        Mockito.when(accountMapper.mapEntityToDto(accountEntity)).thenReturn(expectedAccount);
        //THEN
        UserAccountDto actualAccount = userAccountService.loadUserByUsername(TEST_USERNAME);

        Assertions.assertEquals(expectedAccount.getUsername(), actualAccount.getUsername());
    }

    private UserAccountDto createTestAccountDto(UserAccountEntity accountEntity) {
        UserAccountDto dto = new UserAccountDto();
        dto.setId(accountEntity.getId());
        dto.setUsername(accountEntity.getUsername());
        return dto;
    }

    private UserAccountEntity createTestAccount() {
        UserAccountEntity accountEntity = new UserAccountEntity();
        accountEntity.setId(2L);
        accountEntity.setUsername(TEST_USERNAME);
        return accountEntity;
    }
}
