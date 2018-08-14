package object;

public class Company {
    private long id;

    private String companyName;

    private int inn;

    private String address;

    private String tel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString(){
        return "Company{"+
                "id="+id+
                ", companyName='"+companyName+"\'"+
                ", Inn='"+inn+"\'"+
                ", adds='"+address+"\'" +
                ", tel='"+tel+"\'}";
    }
}
