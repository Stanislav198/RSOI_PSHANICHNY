package com.stas;

import com.stas.entity.Account;
import com.stas.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CRUD {
    @Autowired
    private AccountRepository repo;

    public List<Account> getAllAccounts() {
        return repo.findAll();
    }

    public Account getAccount(long id) {
        return repo.findById(id).get();
    }

    public void addAccount(Account acc) {
        repo.save(acc);
    }

    public void deleteAccount(long id) {
        repo.deleteById(id);
    }

}
