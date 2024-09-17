package br.com.tiagocordeiro.cardsms.domain.dto;

import br.com.tiagocordeiro.cardsms.domain.Card;
import br.com.tiagocordeiro.cardsms.domain.enums.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDTO {
    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal cardLimit;

    public Card toModel() {
        return new Card(name,flag,income, cardLimit);
    }

}
