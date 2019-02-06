package backend.pages;

public class Customer {
    String groupName;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String password;
    String confirmPassword;
    String newsletterOption;
    String statusOption;

    public Customer(String groupName, String firstNam, String lastName, String email, String phoneNumber,
                    String password, String confirmPassword, String newsletterOption, String statusOption) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.newsletterOption = newsletterOption;
        this.statusOption = statusOption;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFirstNam() {
        return firstName;
    }

    public void setFirstNam(String firstNam) {
        this.firstNam = firstNam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNewsletterOption() {
        return newsletterOption;
    }

    public void setNewsletterOption(String newsletterOption) {
        this.newsletterOption = newsletterOption;
    }

    public String getStatusOption() {
        return statusOption;
    }

    public void setStatusOption(String statusOption) {
        this.statusOption = statusOption;
    }
}
