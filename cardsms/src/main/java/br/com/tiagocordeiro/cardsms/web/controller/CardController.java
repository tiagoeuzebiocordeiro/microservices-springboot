package br.com.tiagocordeiro.cardsms.web.controller;

import br.com.tiagocordeiro.cardsms.domain.Card;
import br.com.tiagocordeiro.cardsms.domain.CustomerCard;
import br.com.tiagocordeiro.cardsms.domain.CustomerCardResponse;
import br.com.tiagocordeiro.cardsms.domain.dto.CardDTO;
import br.com.tiagocordeiro.cardsms.service.CardService;
import br.com.tiagocordeiro.cardsms.service.CustomerCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardController {
    private final CustomerCardService customerCardService;
    private final CardService cardService;

    @GetMapping("status")
    public String status() {
        return "Ok!";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CardDTO dto) {
        Card card = dto.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsLessThan(@RequestParam("income") Long income) {
        List<Card> cards = cardService.getCardsIncomeLessThan(income);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CustomerCardResponse>> getCardsByCustomerCpf(@RequestParam("cpf") String cpf) {
        List <CustomerCard> list = customerCardService.listCardsByCpf(cpf);
        List<CustomerCardResponse> stream = list.stream().map(CustomerCardResponse::fromModel).toList();
        return ResponseEntity.ok(stream);
    }

}
