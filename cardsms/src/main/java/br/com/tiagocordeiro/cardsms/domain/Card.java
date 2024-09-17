package br.com.tiagocordeiro.cardsms.domain;

import br.com.tiagocordeiro.cardsms.domain.enums.CardFlag;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal cardLimit;

    public Card(String name, CardFlag flag, BigDecimal income, BigDecimal cardLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.cardLimit = cardLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
