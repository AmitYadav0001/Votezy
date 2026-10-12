package in.amit.votezy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteRequestDTO {

    @NotNull(message = "Voter Id is required !!!")
    Long voterId;

    @NotNull(message = "Candidate Id is required !!!")
    Long candidateId;

}
