package no.fintlabs.integration.validation;

public class CouldNotFindMetadataException extends RuntimeException {

    public CouldNotFindMetadataException(Long metadataId) {
        super("Could not find metadata with id=" + metadataId);
    }
}
