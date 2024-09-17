package br.com.tiagocordeiro.cardsms.service;

import br.com.tiagocordeiro.cardsms.domain.CustomerCard;
import br.com.tiagocordeiro.cardsms.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardService {

    private final CustomerCardRepository customerCardRepository;

    @Transactional(readOnly = true)
    public List<CustomerCard> listCardsByCpf(String cpf) {
        return customerCardRepository.findByCpf(cpf);
    }

}
