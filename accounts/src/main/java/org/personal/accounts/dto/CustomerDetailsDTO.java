package org.personal.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer, Account, Cards and Loans information"
)
public class CustomerDetailsDTO {

    @Schema(
            description = "Name of the customer", example = "Arjunan"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the name shoould be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the customer", example = "arjunan@test.com"
    )
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message="Email address should be valid")
    private String email;

    @Schema(
            description = "Mobile No of the customer", example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDTO accountsDTO;

    @Schema(
            description = "Loans details of the customer"
    )
    private LoansDTO loansDTO;

    @Schema(
            description = "Cards details of the customer"
    )
    private CardsDTO cardsDTO;

}
