package in.amit.votezy.service;

import in.amit.votezy.entity.Candidate;
import in.amit.votezy.entity.ElectionResult;
import in.amit.votezy.exception.ResourceNotFoundException;
import in.amit.votezy.repository.CandidateRepository;
import in.amit.votezy.repository.ElectionResultRepository;
import in.amit.votezy.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionResultService {

    private final CandidateRepository candidateRepository;
    private final ElectionResultRepository electionResultRepository;
    private final VoteRepository voteRepository;

    public ElectionResultService(CandidateRepository candidateRepository,
                                 ElectionResultRepository electionResultRepository,
                                 VoteRepository voteRepository) {
        this.candidateRepository = candidateRepository;
        this.electionResultRepository = electionResultRepository;
        this.voteRepository = voteRepository;
    }

    public ElectionResult declareElectionResult(String electionName) {
        // 1. Check if result is already declared
        Optional<ElectionResult> existingResult = this.electionResultRepository.findByElectionName(electionName);
        if (existingResult.isPresent()) {
            return existingResult.get();
        }

        // 2. Check if any votes exist
        if (this.voteRepository.count() == 0) {
            throw new IllegalStateException("Cannot declare the result as no votes have been cast");
        }

        List<Candidate> a11Candidates = candidateRepository.findAllByOrderByVoteCountDesc();
        List<Candidate> allCandidates = candidateRepository.findAllByOrderByVoteCountDesc();
        if (allCandidates.isEmpty()) {
            throw new ResourceNotFoundException("No candidates available");
        }

        Candidate winner = allCandidates.get(0);
        int totalVotes = 0;
        for (Candidate candidate : allCandidates) {
            totalVotes += candidate.getVoteCount();
        }

        ElectionResult result = new ElectionResult();
        result.setElectionName(electionName);
        result.setWinner(winner);
        result.setTotalVotes(totalVotes);
        return electionResultRepository.save(result);
    }

    public List<ElectionResult> getAllResults() {
        return electionResultRepository.findAll();
    }

}