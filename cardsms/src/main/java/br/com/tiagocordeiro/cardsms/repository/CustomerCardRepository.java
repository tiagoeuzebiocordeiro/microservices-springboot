package br.com.tiagocordeiro.cardsms.repository;

import br.com.tiagocordeiro.cardsms.domain.CustomerCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerCardRepository  extends JpaRepository<CustomerCard, Long> {

    List<CustomerCard> findByCpf(String cpf);

}
