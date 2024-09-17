package br.com.tiagocordeiro.cardsms.service;

import br.com.tiagocordeiro.cardsms.domain.Card;
import br.com.tiagocordeiro.cardsms.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card obj) {
        return cardRepository.save(obj);
    }

    @Transactional(readOnly = true)
    public List<Card> getCardsIncomeLessThan(Long income)  {
        BigDecimal bigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(bigDecimal);
    }


}
