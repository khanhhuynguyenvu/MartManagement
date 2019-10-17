package group.jpa.ogm.app.repository.account;

import java.util.List;

import group.jpa.ogm.app.entities.Account;

public interface AccountRepository {
	Account findAccount(String id);
	List<Account> findAcccountByUsername(String username);
    void save(Account Account);
    void remove(Account Account);
    void update(Account Account);
}
