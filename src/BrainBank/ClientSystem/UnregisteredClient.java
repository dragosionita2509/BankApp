package BrainBank.ClientSystem;

import java.util.Objects;

public class UnregisteredClient {

    protected String CNP;

    public UnregisteredClient(String CNP) {
        this.CNP = CNP;
    }

    public UnregisteredClient() {
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    @Override
    public String toString() {
        return "UnregisteredClient{" +
                "CNP='" + CNP + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnregisteredClient that = (UnregisteredClient) o;
        return CNP.equals(that.CNP);
    }

}
