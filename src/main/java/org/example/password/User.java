package org.example.password;

/**
 * 테스트 하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을 수 있음
 */
public class User {

    private String password;

    /**
     * 비밀번호는 최소 8자, 최대 12자 이하여야 한다.
     */
    public void initPassword(PasswordGenerator passwordGenerator) {
        //as -is
        // RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();

        if (password.length() >= 8 && password.length() <= 12) {
            setPassword(password);
        }
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
