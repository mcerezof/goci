package uk.ac.ebi.spot.goci.model;

import org.apache.solr.client.solrj.beans.Field;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;

/**
 * Javadocs go here!
 *
 * @author Tony Burdett
 * @date 23/12/14
 */
public class StudyDocument extends Document<Study> {
    @Field private String pubmedId;
    @Field private String title;
    @Field private String author;
    @Field private String publication;
    @Field private String publicationDate;
    @Field private String catalogAddedDate;

    @Field private String platform;
    @Field private Boolean cnv;

    @Field private String initialSampleDescription;
    @Field private String replicateSampleDescription;

    @Field private String trait;
    @Field("traitUri") private Collection<String> traitUris;
    @Field private Collection<String> rsIds;
    @Field private Collection<String> chromosomePositions;
    @Field private Collection<String> regions;


    @Field private int associationCount;

    public StudyDocument(Study study) {
        super(study);
        this.pubmedId = study.getPubmedId();
        this.title = study.getTitle();
        this.author = study.getAuthor();
        this.publication = study.getPublication();

        this.platform = study.getPlatform();
        this.cnv = study.getCnv();

        this.initialSampleDescription = study.getInitialSampleSize();
        this.replicateSampleDescription = study.getReplicateSampleSize();

        if (study.getDiseaseTrait() != null) {
            this.trait = study.getDiseaseTrait().getTrait();
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (study.getStudyDate() != null) {
            this.publicationDate = df.format(study.getStudyDate());
        }
        if (study.getHousekeeping().getPublishDate() != null) {
            this.catalogAddedDate = df.format(study.getHousekeeping().getPublishDate());
        }


        this.traitUris = new ArrayList<>();
        study.getEfoTraits().forEach(efoTrait -> traitUris.add(efoTrait.getUri()));

        this.associationCount = study.getAssociations().size();
    }

    public String getPubmedId() {
        return pubmedId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getCatalogAddedDate() {
        return catalogAddedDate;
    }

    public String getPlatform() {
        return platform;
    }

    public Boolean getCnv() {
        return cnv;
    }

    public String getInitialSampleDescription() {
        return initialSampleDescription;
    }

    public String getReplicateSampleDescription() {
        return replicateSampleDescription;
    }

    public String getTrait() {
        return trait;
    }

    public Collection<String> getTraitUris() {
        return traitUris;
    }

    public int getAssociationCount() {
        return associationCount;
    }

    public void setAssociationCount(int associationCount) {
        this.associationCount = associationCount;
    }

    public void addRsId(String rsId) {
         rsIds.add(rsId);
    }

    public Collection<String> getRsIds() {
        return rsIds;
    }

    public void setRsIds(Collection<String> rsIds) {
        this.rsIds = rsIds;
    }

    public void addChromosomePosition(String chromosomePosition) {
        chromosomePositions.add(chromosomePosition);
    }

    public void addRegion(String region) {
        regions.add(region);
    }

    public Collection<String> getChromosomePositions() {
        return chromosomePositions;
    }

    public void setChromosomePositions(Collection<String> chromosomePositions) {
        this.chromosomePositions = chromosomePositions;
    }

    public Collection<String> getRegions() {
        return regions;
    }

    public void setRegions(Collection<String> regions) {
        this.regions = regions;
    }

    public void addMappedGene(Gene gene) {
        //TO DO - ADD MAPPED GENE STUFF
    }
}
