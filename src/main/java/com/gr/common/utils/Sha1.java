package com.gr.common.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;


/**
 * ��ϢժҪ�����Ի��CRC32��MD5��SHA-1ֵ
 * @version 1.0
 * @author dongliyang
 */
public class Sha1 {
    
    /**
     * �����ļ���32λѭ������У���CRC32
     * @param filepath �ļ���
     * @return String
     * @throws IOException IOException�쳣
     */
    public static String crc32Digest(String filepath) {
        
        try {
            
            InputStream in = new BufferedInputStream(new FileInputStream(filepath));
            CRC32 crc = new CRC32();
            
            int c;
            while((c = in.read()) != -1){
                crc.update(c);
            }
            in.close();
            return Long.toHexString(crc.getValue());
        } catch (FileNotFoundException e) {
            System.out.println("�ļ�δ�ҵ��쳣!");
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO�쳣!");
            throw new RuntimeException(e.getMessage());
        }
        
    }
    
    /**
     * �����ļ���32λѭ������У���CRC32
     * @param file �ļ�
     * @return String
     * @throws IOException IOException�쳣
     */
    public static String crc32Digest(File file){
        
        try {
            
            InputStream in = new BufferedInputStream(new FileInputStream(file));
            CRC32 crc = new CRC32();
            
            int c;
            while((c = in.read()) != -1){
                crc.update(c);
            }
            in.close();
            return Long.toHexString(crc.getValue());
        } catch (FileNotFoundException e) {
            System.out.println("�ļ�δ�ҵ��쳣!");
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO�쳣!");
            throw new RuntimeException(e.getMessage());
        }
        

    }
    
    /**
     * �����ַ�����MD5ֵ
     * @param input �ַ���
     * @return String
     */
    public static String md5Digest(String input){
        
        byte[] data = input.getBytes();
        try {
            MessageDigest messageDigest = getMD5();
            messageDigest.update(data);
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5�㷨��ʼ��ʧ��!");
            throw new RuntimeException(e.getMessage());
        }
        
    }
    
    /**
     * �����ļ���MD5ֵ
     * @param filename �ļ���
     * @return String
     */
    public static String md5FileDigest(String filepath){
        String md5 = "";
        File file = new File(filepath);
        if(file.exists()){
            try {
                MessageDigest messageDigest = getMD5();
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                byte[] cache = new byte[CACHE_SIZE];
                int len;
                while((len = in.read(cache)) != -1){
                    messageDigest.update(cache, 0, len);
                }
                in.close();
                byte[] data = messageDigest.digest();
                md5 = toHexString(data);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("MD5�㷨��ʼ��ʧ��!");
                throw new RuntimeException(e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("�ļ�δ�ҵ��쳣!");
                throw new RuntimeException(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO�쳣!");
                throw new RuntimeException(e.getMessage());
            }
        }
        return md5;
    }
    
    /**
     * �����ļ���MD5ֵ
     * @param file �ļ�
     * @return String
     */
    public static String md5FileDigest(File file){
        
        String md5 = "";
        if(file.exists()){
            try {
                MessageDigest messageDigest = getMD5();
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                byte[] cache = new byte[CACHE_SIZE];
                int len;
                while((len = in.read(cache)) != -1){
                    messageDigest.update(cache, 0, len);
                }
                in.close();
                byte[] data = messageDigest.digest();
                md5 = toHexString(data);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("MD5�㷨��ʼ��ʧ��!");
                throw new RuntimeException(e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("�ļ�δ�ҵ��쳣!");
                throw new RuntimeException(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO�쳣!");
                throw new RuntimeException(e.getMessage());
            }
        }
        return md5;
    }
    
    /**
     * �����ַ�����SHA-1ֵ
     * @param input �ַ���
     * @return String
     */
    public static String sha1Digest(String input){
        
        byte[] data = input.getBytes();
        try {
            MessageDigest messageDigest = getSHA1();
            messageDigest.update(data);
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5�㷨��ʼ��ʧ��!");
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * �����ļ���SHA-1ֵ
     * @param filepath �ļ���
     * @return String
     */
    public static String sha1FileDigest(String filepath){
        
        String sha1 = "";
        File file = new File(filepath);
        if(file.exists()){
            try {
                MessageDigest messageDigest = getSHA1();
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                byte[] cache = new byte[CACHE_SIZE];
                int len;
                while((len = in.read(cache)) != -1){
                    messageDigest.update(cache, 0, len);
                }
                in.close();
                byte[] data = messageDigest.digest();
                sha1 = toHexString(data);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("MD5�㷨��ʼ��ʧ��!");
                throw new RuntimeException(e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("�ļ�δ�ҵ��쳣!");
                throw new RuntimeException(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO�쳣!");
                throw new RuntimeException(e.getMessage());
            }
        }
        return sha1;
    }
    
    /**
     * �����ļ���SHA-1ֵ
     * @param file �ļ�
     * @return String
     */
    public static String sha1FileDigest(InputStream in){
        
        String sha1 = "";
            try {
                MessageDigest messageDigest = getSHA1();
                byte[] cache = new byte[CACHE_SIZE];
                int len;
                while((len = in.read(cache)) != -1){
                    messageDigest.update(cache, 0, len);
                }
                in.close();
                byte[] data = messageDigest.digest();
                sha1 = toHexString(data);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("MD5�㷨��ʼ��ʧ��!");
                throw new RuntimeException(e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("�ļ�δ�ҵ��쳣!");
                throw new RuntimeException(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO�쳣!");
                throw new RuntimeException(e.getMessage());
            }
        return sha1;
        
    }
    /**
     * �ֽ�����ת��Ϊ16�����ַ���
     * @param data �ֽ�����
     * @return String
     */    
    private static String toHexString(byte[] data){
        StringBuilder digestStr = new StringBuilder();
        String stmp = "";
        for(int i = 0;i < data.length; i++){
            stmp = Integer.toHexString(data[i] & 0XFF);
            if(stmp.length() == 1){
                digestStr.append("0" + stmp);
            }else {
                digestStr.append(stmp);
            }
        }
        return digestStr.toString();
    }
    
    /**
     * ��ȡMD5ʵ��
     * @return MessageDigest
     * @throws NoSuchAlgorithmException �쳣
     */
    private static MessageDigest getMD5() throws NoSuchAlgorithmException{
        return MessageDigest.getInstance(ALGORIGTHM_MD5);
    }
    
    private static MessageDigest getSHA1() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(ALGORIGTHM_SHA1);
    }
    
    /** MD5�㷨���� */
    private static final String ALGORIGTHM_MD5 = "MD5";
    /** SHA-1�㷨���� */
    private static final String ALGORIGTHM_SHA1 ="SHA-1";
    /** �ֽ����黺���С */
    private static final int CACHE_SIZE = 2048;
    
    public static void main(String[] args) {
    	System.out.println(sha1FileDigest("C:/Users/liuwl/Desktop/fff.mp3"));
	}
}