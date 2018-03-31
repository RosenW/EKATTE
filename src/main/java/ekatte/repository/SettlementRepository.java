package ekatte.repository;

import ekatte.entities.Municipality;
import ekatte.entities.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long>{
}
