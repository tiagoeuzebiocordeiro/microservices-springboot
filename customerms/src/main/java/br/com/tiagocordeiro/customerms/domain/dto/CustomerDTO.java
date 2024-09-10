package br.com.tiagocordeiro.customerms.domain.dto;

import br.com.tiagocordeiro.customerms.domain.Customer;
import lombok.Data;

@Data
public class CustomerDTO {

    private String cpf;
    private String name;
    private Integer age;

    public Customer toModel() {
        return new Customer(cpf,name,age);
    }

}
