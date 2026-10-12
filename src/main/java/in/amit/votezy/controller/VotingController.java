package in.amit.votezy.controller;

import in.amit.votezy.dto.VoteRequestDTO;
import in.amit.votezy.dto.VoteResponseDTO;
import in.amit.votezy.entity.Vote;
import in.amit.votezy.service.VotingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin
public class VotingController {

    private VotingService votingService;

    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }


    @PostMapping("/cast")
    public ResponseEntity<VoteResponseDTO> castVote(@Valid @RequestBody VoteRequestDTO voteRequest) {
        Vote vote = votingService.castVote(voteRequest.getVoterId(), voteRequest.getCandidateId());
        VoteResponseDTO response = new VoteResponseDTO(
                "Vote cast successfully",
                true,
                vote.getVoter().getId(),
                vote.getCandidate().getId()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vote>> getA11Votes() {
        List<Vote> voteList = votingService.getA11Votes();
        return new ResponseEntity<>(voteList, HttpStatus.OK);
    }
}
