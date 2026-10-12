package in.amit.votezy.repository;

import in.amit.votezy.entity.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ElectionResultRepository extends JpaRepository<ElectionResult, Long> {

    Optional<ElectionResult> findByElectionName(String electionName);

}