package com.gr.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	protected static Logger logger = Logger.getLogger(RedisUtil.class);

	// Redis������IP
	private static String ADDR_ARRAY = "192.168.23.130,192.168.23.130";

	// Redis�Ķ˿ں�
	private static int PORT = 6379;

	// ��������
	 private static String AUTH = "122333";

	// ��������ʵ���������Ŀ��Ĭ��ֵΪ8��
	// �����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
	private static int MAX_ACTIVE = 8;

	// ����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��
	private static int MAX_IDLE = 300;

	// �ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
	private static int MAX_WAIT = 300;

	// ��ʱʱ��
	private static int TIMEOUT = 300;
	
	// ��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	/**
	 * redis����ʱ��,����Ϊ��λ
	 */
	public final static int EXRP_HOUR = 60 * 60; // һСʱ
	public final static int EXRP_DAY = 60 * 60 * 24; // һ��
	public final static int EXRP_MONTH = 60 * 60 * 24 * 30; // һ����

	/**
	 * ��ʼ��Redis���ӳ�
	 */
	private static void initialPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT,
					TIMEOUT,AUTH);
		} catch (Exception e) {
			logger.error("First create JedisPool error : " + e);
			try {
				// �����һ��IP�쳣������ʵڶ���IP
				JedisPoolConfig config = new JedisPoolConfig();
				config.setMaxTotal(MAX_ACTIVE);
				config.setMaxIdle(MAX_IDLE);
				config.setMaxWaitMillis(MAX_WAIT);
				config.setTestOnBorrow(TEST_ON_BORROW);
				jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[1],
						PORT, TIMEOUT);
			} catch (Exception e2) {
				logger.error("Second create JedisPool error : " + e2);
			}
		}
	}

	/**
	 * �ڶ��̻߳���ͬ����ʼ��
	 */
	private static synchronized void poolInit() {
		if (jedisPool == null) {
			initialPool();
		}
	}

	/**
	 * ͬ����ȡJedisʵ��
	 * 
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		if (jedisPool == null) {
			poolInit();
		}
		Jedis jedis = null;
		try {
			if (jedisPool != null) {
				jedis = jedisPool.getResource();
			}
		} catch (Exception e) {
			logger.error("Get jedis error : " + e);
		} finally {
			returnResource(jedis);
		}
		return jedis;
	}

	/**
	 * �ͷ�jedis��Դ
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null && jedisPool != null) {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * ���� String
	 * 
	 * @param key
	 * @param value
	 */
	public static void setString(String key, String value) {
		try {
			value = StringUtils.isEmpty(value) ? "" : value;
			getJedis().set(key, value);
		} catch (Exception e) {
			logger.error("Set key error : " + e);
		}
	}

	/**
	 * ���� ����ʱ��
	 * 
	 * @param key
	 * @param seconds
	 *            ����Ϊ��λ
	 * @param value
	 */
	public static void setString(String key, int seconds, String value) {
		try {
			value = StringUtils.isEmpty(value) ? "" : value;
			getJedis().setex(key, seconds, value);
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
		}
	}

	/**
	 * ��ȡStringֵ
	 * 
	 * @param key
	 * @return value
	 */
	public static String getString(String key) {
		if (getJedis() == null || !getJedis().exists(key)) {
			return null;
		}
		return getJedis().get(key);
	}
}
