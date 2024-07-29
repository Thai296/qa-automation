package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

public class RandomCharacters {
    private static final Logger LOG = Logger.getLogger(RandomCharacters.class);

    // Private method to generate random strings
    private String generateRandomString(int length, String charset) {
        String randomString = RandomStringUtils.random(length, charset.toCharArray());
        LOG.info("Returned Random String: " + randomString);
        return randomString;
    }

    // Get random alphabetic characters
    public String getRandomAlphaString(int length) {
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return generateRandomString(length, charset);
    }

    // Get random numeric characters
    public String getRandomNumericString(int length) {
        String charset = "1234567890";
        return generateRandomString(length, charset);
    }

    // Get random alphanumeric characters
    public String getRandomAlphaNumericString(int length) {
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        return generateRandomString(length, charset);
    }

    // Get random Non-Zero numeric characters
    public String getNonZeroRandomNumericString(int length) {
        String charset = "123456789";
        return generateRandomString(length, charset);
    }

    // Get random alphabetic and special characters
    public String getRandomAlphaStringWithSpecialCharacters(int length) {
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ>&\"'";
        return generateRandomString(length, charset);
    }

    // Get random special characters
    public String getRandomStringWithSpecialCharacters(int length) {
        String charset = "@#$%&*!>&\"'";
        return generateRandomString(length, charset);
    }

    // Get random alphanumeric and special characters
    public String getRandomStringNumberSpecialCharacters(int length) {
        String charset = "@#$%&*!>&\"'ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        return generateRandomString(length, charset);
    }
}
