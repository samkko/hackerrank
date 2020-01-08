package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hs kim on 2020/01/08
 * <p>
 * https://www.hackerrank.com/challenges/password-cracker/problem
 */
public class PasswordCracker {

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public static String passwordCracker(List<String> passwords, String loginAttempt) {

        return passwordCracker(passwords, loginAttempt, new HashMap<>());
    }

    private static String passwordCracker(List<String> passwords, String loginAttempt, Map<String, String> answerMap){

        if (answerMap.get("") != null) {
            return String.join(" ", answerMap.get("").split(" "));
        }

        for (String password : passwords) {
            if (loginAttempt.startsWith(password)) {
                String nextLoginAttempt = loginAttempt.substring(password.length());
                answerMap.put(nextLoginAttempt, answerMap.getOrDefault(loginAttempt, "") + password + " ");
                passwordCracker(passwords, nextLoginAttempt, answerMap);
                if (answerMap.get("") != null) {
                    return String.join(" ", answerMap.get("").split(" "));
                }
            }
        }

        return "WRONG PASSWORD";
    }

    public static void main(String[] args) {
        List<String> passWordList = //Arrays.asList("because", "can", "do", "must", "we", "what");
                //Arrays.asList("a", "aa" , "aaa", "aaaa" ,"aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
                Arrays.asList("ab", "abcd", "cd");
        String loginAttempt = //"wedowhatwemustbecausewecan";
                //"aaaaaaaaaab";
                "abcd";
        System.out.println(PasswordCracker.passwordCracker(passWordList, loginAttempt));
    }

}

