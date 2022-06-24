package br.com.senior.crm.http.camel.services.cache;

import br.com.senior.seniorx.http.camel.authentication.Token;
import org.apache.camel.Exchange;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.time.Duration;

import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ExpiryPolicyBuilder.timeToLiveExpiration;
import static org.ehcache.config.units.MemoryUnit.B;

public class CacheAccount {
    private static final String CACHE_NAME = "idAccount";
    // Token cache size in bytes.
    private static final long TOKEN_CACHE_SIZE = 64000000;
    // Refresh token TTL in seconds (See environment variable KONG_REFRESH_TOKEN_TTL at https://git.senior.com.br/arquitetura/kong-rest-client/-/wikis/home).
    private static final int REFRESH_TOKEN_TTL = 15552000;

    private static final CacheManager CACHE_MANAGER = newCacheManagerBuilder().build(true);

    private static final Cache<String, String> CACHE = CACHE_MANAGER.createCache(CACHE_NAME, //
        newCacheConfigurationBuilder(String.class, String.class, //
            ResourcePoolsBuilder.newResourcePoolsBuilder().heap(TOKEN_CACHE_SIZE, B).build()) //
            .withExpiry(timeToLiveExpiration(Duration.ofSeconds(REFRESH_TOKEN_TTL))) //
            .build());

    public static void setCache(String idAccount) {
        CACHE.put(idAccount, idAccount);
    }

    public static boolean hasCache(String idAccount) {
        return CACHE.containsKey(idAccount);
    }

    public static void removeCache(String idAccount) {
        CACHE.remove(idAccount);
    }
}
