package in.amit.votezy.service;

import in.amit.votezy.entity.Candidate;
import in.amit.votezy.entity.Vote;
import in.amit.votezy.entity.Voter;
import in.amit.votezy.exception.ResourceNotFoundException;
import in.amit.votezy.exception.VoteNotAllowedException;
import in.amit.votezy.repository.CandidateRepository;
import in.amit.votezy.repository.VoteRepository;
import in.amit.votezy.repository.VoterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    private VoteRepository voteRepository;
    private CandidateRepository candidateRepository;
    private VoterRepository voterRepository;

    public VotingService(VoteRepository voteRepository, CandidateRepository candidateRepository, VoterRepository voterRepository) {
        this.voteRepository = voteRepository;
        this.candidateRepository = candidateRepository;
        this.voterRepository = voterRepository;
    }


    @Transactional
    public Vote castVote(Long voterId, Long candidateId) {
        if(!voterRepository.existsById(voterId)) {
            throw new ResourceNotFoundException("Voter not found with ID:" + voterId);
        }
        if(!candidateRepository.existsById(candidateId)) {
            throw new ResourceNotFoundException("Candidate not found with ID:" + candidateId);
        }

        Voter voter = voterRepository.findById(voterId).get();
        if(voter.isHasVoted()) {
            throw new VoteNotAllowedException("Voter ID: "+voterId+" has already cast !!!");

        }
        Candidate candidate = candidateRepository.findById(candidateId).get();
        Vote vote = new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);
        voteRepository.save(vote);
        candidate.setVoteCount(candidate.getVoteCount() + 1);
        candidateRepository.save(candidate);
        voter.setHasVoted(true);
        voterRepository.save(voter);

        return vote;
    }

    public List<Vote> getA11Votes() {
        return voteRepository.findAll();
    }

}