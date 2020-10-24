package domain;

public class User {
    public String pwd;
    public String usr_name;
    public String tk;
    public String phone_num;
    public long tct;

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTk() {
        return tk;
    }

    public long getTct() { return tct; }

    public void setTct(long timeInMillis){this.tct = timeInMillis;}

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
