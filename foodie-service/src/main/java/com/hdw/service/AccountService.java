package com.hdw.service;

import com.hdw.pojo.Account;

public interface AccountService {

    public Account saveAccount(Account account);

    public Account selectAccountIsExistByUsername(String username);
}
