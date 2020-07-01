package org.yearup.moviecatalog.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yearup.moviecatalog.account.model.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
}
