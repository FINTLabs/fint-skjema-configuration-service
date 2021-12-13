package no.fintlabs.integration.cache.ehcache;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.integration.cache.FintCacheEvent;

@Slf4j
public class FintEhCacheEventLogger<K, V> extends FintEhCacheEventListener<K, V> {

    private final String cacheAlias;

    public FintEhCacheEventLogger(String cacheAlias) {
        this.cacheAlias = cacheAlias;
    }

    @Override
    public void onEvent(FintCacheEvent<K, V> event) {
        switch (event.getType()) {
            case CREATED:
                log.info(String.format("Cache entry in '%s' with key='%s' created with value=%s",
                        this.cacheAlias, event.getKey(), event.getNewValue()));
                break;
            case UPDATED:
                log.info(String.format("Cache entry in '%s' with key='%s' updated from %s to %s",
                        this.cacheAlias, event.getKey(), event.getOldValue(), event.getNewValue()));
                break;
            case REMOVED:
                log.info(String.format("Cache entry in '%s' with key='%s' removed",
                        this.cacheAlias, event.getKey()));
                break;
            case EVICTED:
                log.info(String.format("Cache entry in '%s' with key='%s' evicted",
                        this.cacheAlias, event.getKey()));
                break;
            case EXPIRED:
                log.info(String.format("Cache entry in '%s' with key='%s' expired",
                        this.cacheAlias, event.getKey()));
        }
    }
}
