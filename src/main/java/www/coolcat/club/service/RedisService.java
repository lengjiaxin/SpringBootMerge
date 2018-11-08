package www.coolcat.club.service;

import java.util.List;
import java.util.Set;

/**
 * @ClassName RedisService
 * @Description
 * @Author Lengjx
 * @Date 2018-11-08 10:15
 * @Version 1.0
 **/
public interface RedisService {
    public boolean set(final String key, Object value);
    public boolean set(final String key, Object value, Long expireTime);
    public void remove(final String... keys);
    public void removePattern(final String pattern);
    public void remove(final String key);
    public boolean exists(final String key);
    public Object get(final String key);
    public void hmSet(String key, Object hashKey, Object value);
    public Object hmGet(String key, Object hashKey);
    public void lPush(String k, Object v);
    public List<Object> lRange(String k, long l, long l1);
    public void add(String key, Object value);
    public Set<Object> setMembers(String key);
    public Set<Object> rangeByScore(String key, double scoure, double scoure1);
    public void zAdd(String key, Object value, double scoure);
}
