package in.amit.votezy.service;

import in.amit.votezy.entity.Candidate;
import in.amit.votezy.entity.Vote;
import in.amit.votezy.entity.Voter;
import in.amit.votezy.exception.DuplicateResourceException;
import in.amit.votezy.exception.ResourceNotFoundException;
import in.amit.votezy.repository.CandidateRepository;
import in.amit.votezy.repository.VoterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private CandidateRepository CandidateRepository;
    private VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository,CandidateRepository candidateRepository) {
        this.voterRepository = voterRepository;
        this.CandidateRepository = candidateRepository;
    }

     public Voter registerVoter(Voter voter) {

         if (voterRepository.existsByEmail(voter.getEmail())) {
             throw new DuplicateResourceException("Voter with E-mail id : " + voter.getEmail() + " already exists !!!");
         }

         return voterRepository.save(voter);
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();

    }

    public Voter getVoterById(Long id) {
        Voter voter = voterRepository.findById(id).orElse(null);

        if (voter == null) {
            throw new ResourceNotFoundException("Voter with id : " + id + " not found");
        }

        return voter;
    }

    public Voter updateVoter(Long id, Voter updatedVoter) {

        Voter voter = voterRepository.findById(id).orElse(null);

        if (voter == null) {
            throw new ResourceNotFoundException("Voter with id : " + id + " not found");
        }
        if (updatedVoter.getName() != null) {
            voter.setName(updatedVoter.getName());
        }

        if (updatedVoter.getEmail() != null) {
            voter.setEmail(updatedVoter.getEmail());
        }

        return voterRepository.save(voter);
    }

    @Transactional
    public void deleteVoter(Long id) {

        Voter voter = voterRepository.findById(id).orElse(null);

        if (voter == null) {
            throw new ResourceNotFoundException("Can't delete voter with id : " + id + " as it does not exist !!");
        }

        Vote vote = voter.getVote();

        if (vote != null) {
            Candidate candidate = vote.getCandidate();
            candidate.setVoteCount(candidate.getVoteCount() - 1);
            CandidateRepository.save(candidate);
        }

        voterRepository.delete(voter);



    }








}
