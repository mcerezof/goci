package uk.ac.ebi.spot.goci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uk.ac.ebi.spot.goci.model.Ancestry;

import java.util.Collection;

/**
 * Created by emma on 28/11/14.
 *
 * @author emma
 *         <p>
 *         Repository accessing Ancestry entity object
 */
@RepositoryRestResource//(excerptProjection = AncestryProjection.class)
public interface AncestryRepository extends JpaRepository<Ancestry, Long> {
    Collection<Ancestry> findByStudyIdAndType(Long studyId, String type);

    Collection<Ancestry> findByStudyId(Long studyId);

    Collection<Ancestry> findByStudyPubmedIdAndType(String pubmedId, String type);

    Collection<Ancestry> findByStudyPubmedId(String pubmedId);

    Collection<Ancestry> findByAncestralGroupsAncestralGroup(String ancestralGroup);
}
