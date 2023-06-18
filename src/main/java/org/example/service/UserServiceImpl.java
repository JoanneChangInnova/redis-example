package org.example.service;

import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.example.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
/**
 * specify the default cache name for all cache operations
 */
@CacheConfig(cacheNames = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userDao;

    /**
     * @Cacheable caches the result of a method.
     * When the method is invoked again, the cached result is returned instead of executing the method logic.
     * The value attribute specifies the key of the cache
     */
    @Override
    @Cacheable(value = "getAllUsers", keyGenerator = "wiselyKeyGenerator")
    public List<User> getAllUsers()
    {
        return userDao.findAll();
    }

    /**
     * The value attribute specifies the cache name
     * key ="#p0" means uses the first parameter of the method as the cache key
     */
    @Override
    @Cacheable(value="userId", key ="#p0")
    public User findById(Integer pId)
    {
        Optional<User> _User = userDao.findById(pId);
        System.out.println("Cache not found in Redis. Querying from database...");
        return Optional.ofNullable(_User).get().orElse(null);
    }

    /**
     * evict (remove) the one with cache name= "userId" and cache key= the 1st param of the method.
     */
    @CacheEvict(value="userId", key ="#p0")
    public void clear(Integer pId)
    {

    }

    /**
     * all entries(keys and values) under the cache name=getAllUsers should be removed.
     */
    @CacheEvict(value = "getAllUsers",allEntries=true)
    public void clearAllUserCache()
    {

    }
}