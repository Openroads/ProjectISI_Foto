package pl.fotoszop.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pl.fotoszop.model.HashGenerator;

public class LoginFormDTO {
    @NotEmpty
    @Email
    private String login;

    @NotEmpty(message = "Password cannot be empty.")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to change plaintext password to hash
     */
    public void doHash() {

        password = HashGenerator.doHash(password);

    }


}
