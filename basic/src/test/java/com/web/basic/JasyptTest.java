package com.web.basic;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class JasyptTest {

    @Test
    void jasyptTest(){
        String password = "secret";
        String result_password = jasyptEncoding(password);
        log.info("---{}---", result_password);
        String url = "jdbc:mariadb://localhost:3306/mydatabase";
        String result_url = jasyptEncoding(url);
        log.info("---{}---", result_url);
    }

	public String jasyptEncoding(String value) {
		String key = "rpK9PXssARhDAOSnG1rL0o8DlYwzIAxl";
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
		pbeEnc.setPassword(key);
		return pbeEnc.encrypt(value);
	}
}
