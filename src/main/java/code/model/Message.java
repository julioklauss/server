package code.model;

public enum Message {
    UserNameTaken("Username is already taken!"),
    EmailTaken("Email Address already in use!"),
    RoleInvalid("User Role not set."),
    UserRegisterSuccess("User registered successfully"),
    LogOutMsg("logout"),
    FailMsg("Fail");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
