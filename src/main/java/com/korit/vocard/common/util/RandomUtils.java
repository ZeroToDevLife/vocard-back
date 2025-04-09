package com.korit.vocard.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * class: 랜덤 문자열 생성 유틸리티
 * 
 * description: 다양한 랜덤 문자열 생성 기능을 제공합니다.
 */
public class RandomUtils {
    private static final Random random = new Random();
    
    /**
     * description: 랜덤 닉네임 생성에 사용되는 영문 형용사 목록
     * 
     * <p>모두 영문자로 시작하는 형용사 목록</p>
     */
    private static final List<String> ADJECTIVES = Arrays.asList(
        "Cool", "Super", "Mega", "Brave", "Smart", "Wise", "Happy", "Lucky", 
        "Great", "Epic", "Funny", "Swift", "Clever", "Mighty", "Noble", "Royal"
    );
    
    /**
     * description: 랜덤 닉네임 생성에 사용되는 기본 영문 명사 목록
     * 
     * <p>영문자만 포함된 명사 목록</p>
     */
    private static final List<String> NOUNS = Arrays.asList(
        "Tiger", "Dragon", "Eagle", "Lion", "Wolf", "Bear", "Panda", "Shark",
        "Hero", "Star", "Moon", "Sun", "Cloud", "River", "Ocean", "Mountain"
    );
    
    /**
     * description: 동물 테마 닉네임 생성에 사용되는 영문 명사 목록
     * 
     * <p>동물 관련 영문 명사 목록</p>
     */
    private static final List<String> ANIMAL_NOUNS = Arrays.asList(
        "Tiger", "Dragon", "Eagle", "Lion", "Wolf", "Bear", "Panda", "Shark",
        "Hawk", "Falcon", "Dolphin", "Fox", "Rabbit", "Turtle", "Elephant"
    );
    
    /**
     * description: 자연 테마 닉네임 생성에 사용되는 영문 명사 목록
     * 
     * <p>자연 관련 영문 명사 목록</p>
     */
    private static final List<String> NATURE_NOUNS = Arrays.asList(
        "Ocean", "Mountain", "River", "Sky", "Forest", "Meadow", "Valley", 
        "Cloud", "Star", "Moon", "Sun", "Rain", "Snow", "Wind", "Wave"
    );
    
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!?";
    
    /**
     * description: 지정된 범위 내의 랜덤 정수 생성
     *
     * @param min 최소값(포함)
     * @param max 최대값(포함)
     * @return min 이상 max 이하의 랜덤 정수
     */
    public static int randomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * description: 지정된 길이의 랜덤 영숫자 문자열 생성
     *
     * @param length 생성할 문자열 길이
     * @return 영문자와 숫자로 구성된 랜덤 문자열
     */
    public static String randomAlphanumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    /**
     * description: 지정된 길이의 랜덤 숫자 문자열 생성
     *
     * @param length 생성할 문자열 길이
     * @return 숫자로만 구성된 랜덤 문자열
     */
    public static String randomNumeric(int length) {
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return sb.toString();
    }
    
    /**
     * description: 문자열의 문자들을 랜덤하게 섞기
     *
     * @param input 섞을 문자열
     * @return 문자들이 섞인 문자열
     */
    public static String shuffle(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int j = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
    
    /**
     * description: 랜덤 문자 선택
     *
     * @param chars 문자들이 포함된 문자열
     * @return chars에서 무작위로 선택된 한 문자
     */
    public static char randomChar(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }
    
    /**
     * description: 랜덤 닉네임 생성 
     * 
     * <p>형식: 영문형용사 + 영문명사 + 숫자(10~99)</p>
     * <p>닉네임 패턴: 영문자로 시작, 영문자와 숫자만 포함, 3~20자 길이</p>
     * 
     * @return 규칙에 맞는 랜덤 닉네임
     */
    public static String generateNickname() {
        String adjective = ADJECTIVES.get(randomNumber(0, ADJECTIVES.size() - 1));
        String noun = NOUNS.get(randomNumber(0, NOUNS.size() - 1));
        
        // 숫자 추가 (2자리)
        int number = randomNumber(10, 99);
        
        // 단어 첫 글자는 대문자, 나머지는 소문자로 통일
        String nickname = capitalize(adjective) + capitalize(noun) + number;
        
        // 닉네임 길이 체크 (최대 20자)
        if (nickname.length() > 20) {
            // 길이 초과시 짧은 버전 생성
            nickname = adjective.substring(0, 3) + noun.substring(0, 3) + number;
        }
        
        return nickname;
    }
    
    /**
     * description: 특정 테마에 맞는 랜덤 닉네임 생성
     * 
     * <p>형식: 영문형용사 + 테마별영문명사 + 숫자(10~99)</p>
     * <p>닉네임 패턴: 영문자로 시작, 영문자와 숫자만 포함, 3~20자 길이</p>
     * 
     * @param theme 닉네임 테마 ("animal", "nature", 또는 기타)
     * @return 규칙에 맞는 랜덤 닉네임
     */
    public static String generateNickname(String theme) {
        String adjective = ADJECTIVES.get(randomNumber(0, ADJECTIVES.size() - 1));
        String noun;
        
        if ("animal".equalsIgnoreCase(theme)) {
            noun = ANIMAL_NOUNS.get(randomNumber(0, ANIMAL_NOUNS.size() - 1));
        } else if ("nature".equalsIgnoreCase(theme)) {
            noun = NATURE_NOUNS.get(randomNumber(0, NATURE_NOUNS.size() - 1));
        } else {
            // 테마가 없거나 지원하지 않는 테마는 기본 명사 목록 사용
            noun = NOUNS.get(randomNumber(0, NOUNS.size() - 1));
        }
        
        // 숫자 추가 (2자리)
        int number = randomNumber(10, 99);
        
        // 단어 첫 글자는 대문자, 나머지는 소문자로 통일
        String nickname = capitalize(adjective) + capitalize(noun) + number;
        
        // 닉네임 길이 체크 (최대 20자)
        if (nickname.length() > 20) {
            // 길이 초과시 짧은 버전 생성
            nickname = adjective.substring(0, 3) + noun.substring(0, 3) + number;
        }
        
        return nickname;
    }
    
    /**
     * description: 문자열의 첫 글자만 대문자로, 나머지는 소문자로 변환
     * 
     * @param input 변환할 문자열
     * @return 변환된 문자열
     */
    private static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
    public static String generateTemporaryPassword() {
        StringBuilder password = new StringBuilder();
        
        // 각 문자 유형별로 최소 1개 포함
        password.append(randomChar(UPPER_CASE));
        password.append(randomChar(LOWER_CASE));
        password.append(randomChar(NUMBERS));
        password.append(randomChar(SPECIAL));
        
        // 나머지 4자리 채우기 (영문+숫자)
        String allChars = UPPER_CASE + LOWER_CASE + NUMBERS + SPECIAL;
        for (int i = 0; i < 4; i++) {
            password.append(randomChar(allChars));
        }
        
        // 문자 섞기
        return shuffle(password.toString());
    }
} 