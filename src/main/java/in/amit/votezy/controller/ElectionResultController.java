package in.amit.votezy.controller;

import in.amit.votezy.dto.ElectionResultRequestDTO;
import in.amit.votezy.dto.ElectionResultResponseDTO;
import in.amit.votezy.entity.ElectionResult;
import in.amit.votezy.service.ElectionResultService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/election-results")
@CrossOrigin
public class ElectionResultController {

    private final ElectionResultService electionResultService;

    public ElectionResultController(ElectionResultService electionResultService) {
        this.electionResultService = electionResultService;
    }

    @PostMapping("/declare")
    public ResponseEntity<ElectionResultResponseDTO> declareResult(
            @Valid @RequestBody ElectionResultRequestDTO request) {

        ElectionResult result = electionResultService.declareElectionResult(request.getElectionName());

        ElectionResultResponseDTO response = new ElectionResultResponseDTO();
        response.setElectionName(result.getElectionName());
        response.setTotalVotes(result.getTotalVotes());
        response.setWinnerId(result.getWinner().getId());
        response.setWinnerVotes(result.getWinner().getVoteCount());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<List<ElectionResult>> getAllResults() {
        List<ElectionResult> results = electionResultService.getAllResults();
        return ResponseEntity.ok(results);
    }
}