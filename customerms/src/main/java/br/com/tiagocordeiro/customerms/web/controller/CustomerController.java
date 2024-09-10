package br.com.tiagocordeiro.customerms.web.controller;

import br.com.tiagocordeiro.customerms.domain.Customer;
import br.com.tiagocordeiro.customerms.domain.dto.CustomerDTO;
import br.com.tiagocordeiro.customerms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CustomerDTO dto) {
        Customer customer = dto.toModel();
        service.save(customer);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequestUri().query("cpf={cpf}")
                .buildAndExpand(dto.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Customer> getByCpf(@RequestParam("cpf") String cpf) {
        Optional<Customer> customer = service.findByCpf(cpf);
        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer.get());
    }

}
