package in.amit.votezy.repository;

import in.amit.votezy.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    boolean existsByEmail(String email);


}

