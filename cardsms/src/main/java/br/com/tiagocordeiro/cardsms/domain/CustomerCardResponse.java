package br.com.tiagocordeiro.cardsms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardResponse {
    private String name;
    private String brand;
    private BigDecimal availableLimit;

    public static CustomerCardResponse fromModel(CustomerCard model) {
        return new CustomerCardResponse(model.getCard().getName(), model.getCard().getFlag().toString(), model.getCardLimit());
    }

}
